package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Direction;
import com.example.javapythonstory.code.mapper.DirectionMapper;
import com.example.javapythonstory.code.service.DirectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@Service
public class DirectionServiceImpl extends ServiceImpl<DirectionMapper, Direction> implements DirectionService {

    @Autowired
    private DirectionMapper directionMapper;

    /**
     * <p>
     *     添加学习方向
     * </p>
     * @param directionName 学习方向名
     * @return
     */
    @Override
    public Integer addDirection(String directionName) {
        Integer addCode = directionMapper.addDirection(directionName);
        return addCode;
    }

    /**
     * <p>
     *     修改学习方向
     * </p>
     * @param directionId 学习方向编号
     * @param directionName 学习方向名
     * @return
     */
    @Override
    public Integer updateDirection(Integer directionId, String directionName) {
        Integer updateCode = directionMapper.updateDirection(directionId, directionName);
        return updateCode;
    }

    /**
     * <p>
     *     删除学习方向
     * </p>
     * @param directionId 学习方向编号
     * @return
     */
    @Override
    public Integer deleteDirection(Integer directionId) {
        Integer deleteCode = directionMapper.deleteDirection(directionId);
        return deleteCode;
    }

    /**
     * <p>
     *     获取全部学习方向
     * </p>
     * @return
     */
    @Override
    public List<Direction> listDirection() {
        List<Direction> directions = directionMapper.listDirection();
        return directions;
    }

    /**
     * <p>
     *     获取单个学习方向
     * </p>
     * @param directionId 学习方向编号
     * @return
     */
    @Override
    public Direction queryOneDirectionById(Integer directionId) {
        Direction direction = directionMapper.queryOneDirectionById(directionId);
        return direction;
    }
}
