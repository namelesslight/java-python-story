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

    Integer addUser(String userId, String username,String email,String password);

    Integer queryCountByEmail(String email);

    UserVo queryCountByEmailAndPassword(String email, String password);

    Integer addAdmin(String userId, String username, String password);

    Integer queryCountBySuperName(String username);

    UserVo queryCountByNameAndPassword(String username, String password);

    Integer updateUserHeaderById(String id, String headPath);

    Integer updateUserInfoById(String id, String username);

    Integer updateUserDirectionById(String id, String direction);

    Integer updateEmailById(String id,String email);

    Integer updatePasswordById(String id, String password);

    Integer queryCountByIdAndPassword(String id, String password);

    UserVo queryOneUserById(String id);

    List<UserVo> listUsersByDirection(String direction);
}
