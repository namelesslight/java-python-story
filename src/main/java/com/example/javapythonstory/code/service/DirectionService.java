package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Direction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
public interface DirectionService extends IService<Direction> {

    Integer addDirection(String directionName);

    Integer updateDirection(Integer directionId, String directionName);

    Integer deleteDirection(Integer directionId);

    List<Direction> listDirection();

    Direction queryOneDirectionById(Integer directionId);

}
