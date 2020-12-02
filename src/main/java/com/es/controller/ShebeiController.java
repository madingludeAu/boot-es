package com.es.controller;


import com.es.entity.Shebei;
import com.es.service.ShebeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShebeiController {

    @Autowired
    private ShebeiService shebeiService;


    @GetMapping("shebeiList")
    public List<Shebei> findList(){

       return shebeiService.findList(new Shebei());

    }
}
