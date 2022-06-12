package com.example.javapythonstory;

import com.example.javapythonstory.code.util.RedisUtil;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestClass {

    @Test
    void test1(){
        RedisUtil.save("a","B",1L, TimeUnit.DAYS);
    }

}
