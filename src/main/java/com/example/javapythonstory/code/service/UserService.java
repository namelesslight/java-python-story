package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
public interface UserService extends IService<User> {

    Map<String, Object> userRegister(String name, String email, String password, String rwPassword);

    Map<String, Object> userLogin(String email, String password);

    Map<String, Object> adminRegister(String name, String password, String rwPassword);

    Map<String, Object> adminLogin(String name, String password);

    Integer updateUserInfo(Integer userId, String name);

    Integer updateUserDirection(Integer userId, Integer direction);

    Integer updateHeadPicture(Integer userId, MultipartFile headPicture) throws IOException;

    Integer updateEmail(Integer userId, String email);

    Map<String, Object> updatePassword(Integer userId, String oldPassword, String newPassword, String rwPassword);

    Integer deleteUserById(Integer userId);

    UserVo queryOneUser(Integer userId);

    List<UserVo> listUserByDirection(Integer directionId);
}
