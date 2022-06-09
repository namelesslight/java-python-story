package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
public interface UserService extends IService<User> {

    Integer userRegister();

    Integer userLogin();

    Integer adminRegister();

    Integer adminLogin();

    Integer updateUserInfo();

    Integer updateUserDirection();

    Integer updateHeadPicture();

    Integer updateEmail();

    Integer updatePassword();

    Integer deleteUserById();

    Integer queryOneUser();

    Integer listUserByDirection();
}
