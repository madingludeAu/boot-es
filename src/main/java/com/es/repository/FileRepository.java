package com.es.repository;

import com.es.entity.DocFile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface FileRepository extends ElasticsearchRepository<DocFile,String> {

    List<DocFile> findDocFileByFileContent(String content);

}
