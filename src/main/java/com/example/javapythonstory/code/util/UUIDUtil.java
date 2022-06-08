package com.example.javapythonstory.code.util;

import java.util.UUID;

/**
 * 生成UUID工具类
 */
public class UUIDUtil {
    /**
     * 生成UUID
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }
}
