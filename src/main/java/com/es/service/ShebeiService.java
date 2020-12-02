package com.es.service;

import com.es.entity.Shebei;
import com.es.repository.ShebeiRepository;
import com.es.mapper.ShebeiMapper;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShebeiService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ShebeiRepository shebeiRepository;

    @Autowired
    private ShebeiMapper shebeiMapper;


    public List<Shebei> findList(Shebei shebei){
        return shebeiMapper.findList(shebei);
    }




    public List<Shebei> eSfindList(){

        BoolQueryBuilder builder = QueryBuilders.boolQuery();




        return null;
    }


}
