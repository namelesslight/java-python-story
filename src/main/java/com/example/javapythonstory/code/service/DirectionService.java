package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Direction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
public interface DirectionService extends IService<Direction> {

    /**
     * <p>
     *     添加学习方向
     * </p>
     * @param directionName 学习方向名
     * @return
     */
    Integer addDirection(String directionName);

    /**
     * <p>
     *     修改学习方向
     * </p>
     * @param directionId 学习方向编号
     * @param directionName 学习方向名
     * @return
     */
    Integer updateDirection(Integer directionId, String directionName);

    /**
     * <p>
     *     删除学习方向
     * </p>
     * @param directionId 学习方向编号
     * @return
     */
    Integer deleteDirection(Integer directionId);

    /**
     * <p>
     *     获取全部学习方向
     * </p>
     * @return
     */
    List<Direction> listDirection();

    /**
     * <p>
     *     获取单个学习方向
     * </p>
     * @param directionId 学习方向编号
     * @return
     */
    Direction queryOneDirectionById(Integer directionId);

}
