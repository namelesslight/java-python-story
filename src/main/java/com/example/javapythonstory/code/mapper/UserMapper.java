package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.User;
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
public interface UserMapper extends BaseMapper<User> {

    Integer addUser();

    Integer queryCountByEmailAndPassword();

    Integer updateUserHeader();

    Integer updateUserInfo();

    User queryOneUserById();

    List<User> queryUserByDirection();
}
