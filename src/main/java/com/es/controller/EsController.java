package com.es.controller;

import com.es.config.ConfigConf;
import com.es.config.Testw;
import com.es.entity.DocFile;
import com.es.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EsController {

    @Autowired
    private EsService esService;

    @Autowired
    private ConfigConf configConf;

    @GetMapping("search")
    public List<DocFile> search(String content){

       return esService.search(content);
    }


    @RequestMapping("/")
    public  void s(){

        configConf.initStatic();
        System.out.println(Testw.getTest1());
    }

    @GetMapping("getContext")
    public List<DocFile> getContext(String content){

        return esService.getContext(content);
    }




}
