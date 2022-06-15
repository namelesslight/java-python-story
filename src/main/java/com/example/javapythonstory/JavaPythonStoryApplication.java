package com.example.javapythonstory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.example.javapythonstory.code.mapper")
//@ServletComponentScan
@EnableTransactionManagement
public class JavaPythonStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaPythonStoryApplication.class, args);
    }

}
