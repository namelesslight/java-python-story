package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
import org.springframework.web.multipart.MultipartFile;

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

    Integer userRegister(String name, String email, String password, String rwPassword);

    Map<String, Object> userLogin(String email, String password);

    Integer adminRegister(String name, String password, String rwPassword);

    Map<String, Object> adminLogin(String name, String password);

    Integer updateUserInfo(String userId, String name);

    Integer updateUserDirection(String userId, String direction);

    Integer updateHeadPicture(String userId, MultipartFile headPicture);

    Integer updateEmail(String userId, String email);

    Integer updatePassword(String userId, String oldPassword, String newPassword, String rwPassword);

    Integer deleteUserById(String userId);

    UserVo queryOneUser(String userId);

    List<UserVo> listUserByDirection(String directionId);
}
