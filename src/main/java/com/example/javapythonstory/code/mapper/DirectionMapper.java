package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Direction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@Mapper
public interface DirectionMapper extends BaseMapper<Direction> {

    Integer addDirection(String directionName);

    Integer updateDirection(Integer directionId, String directionName);

    Integer deleteDirection(Integer directionId);

    List<Direction> listDirection();

    Direction queryOneDirectionById(Integer directionId);

}
