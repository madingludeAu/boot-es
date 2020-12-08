package com.es.controller;

import com.es.entity.Student;
import com.es.utils.ExcelUtil;
import com.es.utils.excel.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExportCotroller {

    private Logger logger = LoggerFactory.getLogger(ExportCotroller.class);


    @RequestMapping("/index")
    public String index(){


        return "index";
    }



    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public String exportExcel(HttpServletResponse response) throws Exception {
        String[] headers = {"姓名", "性别", "年龄", "学校", "班级"};
        String fileName = "学生表";
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setStudentName("guandezhi");
        student.setGrade("三年二班");
        student.setAge("20");
        student.setSchool("XX大学");
        student.setSex("男");
        studentList.add(student);

        Map<String, Object> studentMap = new HashMap();
        studentMap.put("headers", headers);
        studentMap.put("dataList", studentList);
        studentMap.put("fileName", fileName);

        List<Map> mapList = new ArrayList();
        mapList.add(studentMap);
        ExcelUtils.exportMultisheetExcel(fileName, mapList, response);
        return "success";
    }

    @RequestMapping(value = "/readExcel")
    public String readExcel(@RequestParam("file") MultipartFile file) throws Exception {

        List<Map<String, String>> mapList = ExcelUtils.readExcel(file, 0);
        logger.info("mapList:" + mapList);
        return "success";
    }


    @RequestMapping("de")
    public void de(HttpServletResponse response) throws Exception{
        String fileName = "数据统计.xls";
        response.setContentType("application/octet-stream");
        response.setHeader("name", fileName);
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setDateHeader("Expires", 0);
        response.setHeader("Content-disposition",
                "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
        List list = new ArrayList();
        list.add("test");
        list.add("test1");
        List<String[]> list1 = new ArrayList<>();
        String[] data = {"xiao","ming"};
        list1.add(data);
        ExcelUtil.createExcel(list,list1,response.getOutputStream());
    }

}
