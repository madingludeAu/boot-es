package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.es.mapper")
public class EsApplication {


    public static void main(String[] args) {
        SpringApplication.run(EsApplication.class);
    }
}
