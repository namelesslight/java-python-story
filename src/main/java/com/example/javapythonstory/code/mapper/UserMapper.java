package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
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

    Integer addUser(String username,String email,String password);

    Integer queryCountByEmail(String email);

    UserVo queryCountByEmailAndPassword(String email, String password);

    Integer addAdmin(String username, String password);

    Integer queryCountBySuperName(String username);

    UserVo queryCountByNameAndPassword(String username, String password);

    Integer updateUserHeaderById(Integer id, String headPath);

    Integer updateUserInfoById(Integer id, String username);

    Integer updateUserDirectionById(Integer id, Integer direction);

    Integer updateEmailById(Integer id,String email);

    Integer updatePasswordById(Integer id, String password);

    Integer queryCountByIdAndPassword(Integer id, String password);

    UserVo queryOneUserById(Integer id);

    List<UserVo> listUsersByDirection(Integer direction);
}
