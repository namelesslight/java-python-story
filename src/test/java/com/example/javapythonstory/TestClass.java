package com.example.javapythonstory;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestClass {

    @Test
    void test1(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++){
            Integer num = random.nextInt(10);
            sb.append(num);
        }
        System.out.println(sb);
    }

}
