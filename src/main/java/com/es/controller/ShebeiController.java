package com.es.controller;


import com.es.entity.Shebei;
import com.es.service.ShebeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@RestController
public class ShebeiController {

    @Autowired
    private ShebeiService shebeiService;


    @GetMapping("shebeiList")
    public List<Shebei> findList(){

       return shebeiService.findList(new Shebei());

    }

    @RequestMapping("test")
    public void response(HttpServletResponse response) throws Exception{

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8;");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8;");
        PrintWriter writer=response.getWriter();
        writer.write(
                "<script type=\"text/javascript\">alert('导出失败，请重试！...');</script>");
        writer.flush();
        writer.close();
    }
}
