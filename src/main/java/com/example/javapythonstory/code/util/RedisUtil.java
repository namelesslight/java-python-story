package com.example.javapythonstory.code.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * RedisUtil
 * @author ZCL
 * @since 2022/1/11
 */
@Component
public class RedisUtil {

    private static RedisTemplate<String,Object> redisTemplate;

    /**
     * redis储存值
     * @param key 键
     * @param value 值
     * @param expireTime 过期时间数字
     * @param timeUnit 过期时间单位(天，时，分，秒等)
     */
    public static void save(final String key, Object value, Long expireTime, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,expireTime,timeUnit);
    }

    /**
     * 移除一个键及其所对应的值
     * @param key 键
     */
    public static void remove(final String key){
        redisTemplate.delete(key);
    }

    /**
     * 移除全部键
     * @param keys 键
     */
    public static void removeAll(final String... keys){
        for (String key:keys){
            remove(key);
        }
    }

    /**
     * 获取一个键所对应的值
     * @param key 键
     * @return java.lang.Object
     */
    public static Object getValue(String key){
        Object value = null;
        value = redisTemplate.opsForValue().get(key);
        return value;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate){
        RedisUtil.redisTemplate = redisTemplate;
    }

}
