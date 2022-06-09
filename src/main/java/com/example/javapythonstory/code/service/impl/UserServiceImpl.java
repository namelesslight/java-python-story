package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.User;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
import com.example.javapythonstory.code.mapper.UserMapper;
import com.example.javapythonstory.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserService userService;

    @Override
    public Integer userRegister() {
        return null;
    }

    @Override
    public Integer userLogin() {
        return null;
    }

    @Override
    public Integer adminRegister() {
        return null;
    }

    @Override
    public Integer adminLogin() {
        return null;
    }

    @Override
    public Integer updateUserInfo() {
        return null;
    }

    @Override
    public Integer updateUserDirection() {
        return null;
    }

    @Override
    public Integer updateHeadPicture() {
        return null;
    }

    @Override
    public Integer updateEmail() {
        return null;
    }

    @Override
    public Integer updatePassword() {
        return null;
    }

    @Override
    public Integer deleteUserById() {
        return null;
    }

    @Override
    public UserVo queryOneUser() {
        return null;
    }

    @Override
    public List<UserVo> listUserByDirection() {
        return null;
    }
}
