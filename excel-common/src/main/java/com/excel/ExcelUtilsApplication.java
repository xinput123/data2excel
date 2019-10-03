package com.excel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.excel.mapper")
public class ExcelUtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcelUtilsApplication.class, args);
    }

}
