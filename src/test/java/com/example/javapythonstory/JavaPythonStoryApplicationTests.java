package com.example.javapythonstory;

import com.example.javapythonstory.code.util.SecretUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaPythonStoryApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void a(){
        System.out.println(SecretUtil.secretString("123456"));
    }

}
