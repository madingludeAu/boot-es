package com.es.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName ="github",type = "file")
@Data
public class DocFile {

    @Id
    private String id;


    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String fileName;

    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String fileContent;

    @Field
    private String filePath;

    private Integer sort;


}
