package com.es.service;

import com.es.entity.DocFile;
import com.es.repository.FileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EsService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


        @Autowired
        private FileRepository fileRepository;

        /**
         * 高亮查询
         *
         * @param content
         * @return
         */
        public List<DocFile> search(String content) {
            QueryBuilder builder = new QueryStringQueryBuilder(content);
            //高亮显示规则
            HighlightBuilder highlightBuilder = new HighlightBuilder().field("fileName").field("fileContent").preTags("<span style='color:red'>").postTags("</span>");
            SearchQuery q = new NativeSearchQueryBuilder()
                    //.withIndices("test-file").withTypes("file")
                    .withSort(SortBuilders.fieldSort("sort").order(SortOrder.DESC))
                    .withHighlightBuilder(highlightBuilder)
                    .withHighlightFields(new HighlightBuilder.Field("fileName"), new HighlightBuilder.Field("fileContent"))
                    .withQuery(builder).build();
            List<DocFile> fileList = elasticsearchTemplate.query(q, response -> {
                SearchHits hits = response.getHits();
                List<DocFile> bl = new ArrayList<>();
                if (hits.getHits().length <= 0) {
                    return bl;
                }
                for (SearchHit searchHit : hits) {
                    DocFile file = new DocFile();
                    String bookJson = searchHit.getSourceAsString();
                    if (bookJson == null || "".equals(bookJson)) {
                        continue;
                    }
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        file = mapper.readValue(bookJson, file.getClass());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (searchHit.getHighlightFields().size() > 0) {
                        if (searchHit.getHighlightFields().get("fileName") != null) {
                            String highLightName = searchHit.getHighlightFields().get("fileName").fragments()[0].toString();
                            file.setFileName(highLightName);
                        }
                        if (searchHit.getHighlightFields().get("fileContent") != null) {
                            String highLightContent = searchHit.getHighlightFields().get("fileContent").fragments()[0].toString();
                            file.setFileContent(highLightContent);
                        }
                    }
                    bl.add(file);
                }
                return bl;
            });
            return fileList;
        }


        /**
         * 普通查询
         *
         * @param content
         * @return
         */
        public List<DocFile> getContext(String content) {

            BoolQueryBuilder builder = QueryBuilders.boolQuery();
            //builder下有must、should以及mustNot 相当于sql中的and、or以及not
            //设置要查询博客的标题中含有关键字
            builder.must(new QueryStringQueryBuilder(content));
            //按照博客的评论数的排序是依次降低
            FieldSortBuilder sort = SortBuilders.fieldSort("sort").order(SortOrder.DESC);
            //2.构建查询
            NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
            //将搜索条件设置到构建中
            nativeSearchQueryBuilder.withQuery(builder);
            //设置分页(从第一页开始，一页显示10条) 将分页设置到构建中
            PageRequest pageRequest = PageRequest.of(0, 10);
            nativeSearchQueryBuilder.withPageable(pageRequest);
            //将排序设置到构建中
            nativeSearchQueryBuilder.withSort(sort);
            //生产NativeSearchQuery
            SearchQuery query = nativeSearchQueryBuilder.build();
            //3.执行方法1
            Page<DocFile> page = fileRepository.search(query);
            //执行方法2：注意，这儿执行的时候还有个方法那就是使用elasticsearchTemplate
            //执行方法2的时候需要加上注解
            //@Autowired
            //private ElasticsearchTemplate elasticsearchTemplate;
            // List<DocFile> blogList = elasticsearchTemplate.queryForList(query, DocFile.class);
            //4.获取总条数(用于前端分页)
            int total = (int) page.getTotalElements();
            //5.获取查询到的数据内容（返回给前端）
            List<DocFile> list = page.getContent();
            return list;
        }

}
