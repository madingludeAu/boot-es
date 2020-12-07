package com;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.es.mapper")
public class EsApplication {

    private static Logger logger = LoggerFactory.getLogger(EsApplication.class);


    public static void main(String[] args) {
        logger.info("启动中、、、、");
        SpringApplication.run(EsApplication.class);
        logger.info("运行中、、、、");
    }
}
