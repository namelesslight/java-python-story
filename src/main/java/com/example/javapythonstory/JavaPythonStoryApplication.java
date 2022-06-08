package com.example.javapythonstory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.javapythonstory.code.mapper")
public class JavaPythonStoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaPythonStoryApplication.class, args);
    }

}
