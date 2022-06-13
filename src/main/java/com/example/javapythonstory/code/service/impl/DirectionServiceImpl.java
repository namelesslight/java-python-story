package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Direction;
import com.example.javapythonstory.code.mapper.DirectionMapper;
import com.example.javapythonstory.code.service.DirectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@Service
public class DirectionServiceImpl extends ServiceImpl<DirectionMapper, Direction> implements DirectionService {

    @Autowired
    private DirectionMapper directionMapper;

    @Override
    public Integer addDirection(String directionName) {
        Integer addCode = directionMapper.addDirection(directionName);
        return addCode;
    }

    @Override
    public Integer updateDirection(Integer directionId, String directionName) {
        Integer updateCode = directionMapper.updateDirection(directionId, directionName);
        return updateCode;
    }

    @Override
    public Integer deleteDirection(Integer directionId) {
        Integer deleteCode = directionMapper.deleteDirection(directionId);
        return deleteCode;
    }

    @Override
    public List<Direction> listDirection() {
        List<Direction> directions = directionMapper.listDirection();
        return directions;
    }

    @Override
    public Direction queryOneDirectionById(Integer directionId) {
        Direction direction = directionMapper.queryOneDirectionById(directionId);
        return direction;
    }
}
