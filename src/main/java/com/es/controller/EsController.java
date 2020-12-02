package com.es.controller;


import com.es.entity.DocFile;
import com.es.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class EsController {

    @Autowired
    private EsService esService;

    @GetMapping("search")
    public List<DocFile> search(String content){

       return esService.search(content);
    }


    @GetMapping("getContext")
    public List<DocFile> getContext(String content){

        return esService.getContext(content);
    }




}
