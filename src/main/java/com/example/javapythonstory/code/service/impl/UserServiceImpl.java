package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.User;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
import com.example.javapythonstory.code.mapper.UserMapper;
import com.example.javapythonstory.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    private UserMapper userMapper;


    @Override
    public Integer userRegister(String name, String email, String password, String rwPassword) {
        return null;
    }

    @Override
    public Map<String, Object> userLogin(String email, String password) {
        return null;
    }

    @Override
    public Integer adminRegister(String name, String password, String rwPassword) {
        return null;
    }

    @Override
    public Map<String, Object> adminLogin(String name, String password) {
        return null;
    }

    @Override
    public Integer updateUserInfo(String userId, String name) {
        return null;
    }

    @Override
    public Integer updateUserDirection(String userId, String direction) {
        return null;
    }

    @Override
    public Integer updateHeadPicture(String userId, MultipartFile headPicture) {
        return null;
    }

    @Override
    public Integer updateEmail(String userId, String email) {
        return null;
    }

    @Override
    public Integer updatePassword(String userId, String oldPassword, String newPassword, String rwPassword) {
        return null;
    }

    @Override
    public Integer deleteUserById(String userId) {
        return null;
    }

    @Override
    public UserVo queryOneUser(String userId) {
        return null;
    }

    @Override
    public List<UserVo> listUserByDirection(String directionId) {
        return null;
    }
}
