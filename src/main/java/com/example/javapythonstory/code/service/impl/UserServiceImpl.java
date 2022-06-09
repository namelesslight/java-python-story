package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.User;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
import com.example.javapythonstory.code.mapper.UserMapper;
import com.example.javapythonstory.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javapythonstory.code.util.FileUtil;
import com.example.javapythonstory.code.util.JWTUtil;
import com.example.javapythonstory.code.util.SecretUtil;
import com.example.javapythonstory.code.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    private static String EMAIL = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    @Override
    public Map<String, Object> userRegister(String name, String email, String password, String rwPassword) {
        Map<String, Object> registerInfo = new HashMap<>();
        Integer registerCode = 1;
        Boolean nameJudge = nameLen(name);
        Boolean emailJudge = Pattern.matches(EMAIL, email);
        Boolean passwordJudge = passwordLen(password);
        Boolean rwPasswordJudge = password.equals(rwPassword);
        if (nameJudge){
            registerInfo.put("nameInfo","用户名合格");
        } else {
            registerCode = 0;
            registerInfo.put("nameInfo","用户名过长");
        }
        if (emailJudge){
            registerInfo.put("emailInfo","邮箱格式正确");
        } else {
            registerCode = 0;
            registerInfo.put("emailInfo","邮箱格式错误");
        }
        if (passwordJudge){
            registerInfo.put("passwordInfo","密码格式正确");
        } else {
            registerCode = 0;
            registerInfo.put("passwordInfo","密码格式有误");
        }
        if (rwPasswordJudge){
            registerInfo.put("rwPasswordInfo","前后密码一致");
        } else {
            registerCode = 0;
            registerInfo.put("rwPasswordInfo","前后密码不一致");
        }
        if (userMapper.queryCountByEmail(email) == 1){
            registerCode = 0;
        }
        registerInfo.put("registerCode",registerCode);
        if (registerCode == 1){
            String userId = UUIDUtil.getUUID();
            String secretPassword = SecretUtil.secretString(userId);
            userMapper.addUser(userId, name, email, secretPassword);
        }
        return registerInfo;
    }

    @Override
    public Map<String, Object> userLogin(String email, String password) {
        Map<String, Object> loginInfo = new HashMap<>();
        Integer loginCode = 1;
        String secretPassword = SecretUtil.secretString(password);
        UserVo userInfo = userMapper.queryCountByEmailAndPassword(email, secretPassword);
        if (userInfo != null){
            Map<String, String> claims = new HashMap<>();
            String id = userInfo.getId();
            String role = userInfo.getRole();
            claims.put("id", id);
            claims.put("role", role);
            String token = JWTUtil.createToken(claims);
            loginInfo.put("userInfo", loginCode);
            loginInfo.put("token", token);
        } else {
            loginCode = 0;
        }
        loginInfo.put("loginCode", loginCode);
        return loginInfo;
    }

    @Override
    public Map<String, Object> adminRegister(String name, String password, String rwPassword) {
        Map<String, Object> registerInfo = new HashMap<>();
        Integer registerCode = 1;
        Boolean nameJudge = nameLen(name);
        Boolean passwordJudge = passwordLen(password);
        Boolean rwPasswordJudge = password.equals(rwPassword);
        if (nameJudge){
            registerInfo.put("nameInfo","用户名合格");
        } else {
            registerCode = 0;
            registerInfo.put("nameInfo","用户名过长");
        }
        if (passwordJudge){
            registerInfo.put("passwordInfo","密码格式正确");
        } else {
            registerCode = 0;
            registerInfo.put("passwordInfo","密码格式有误");
        }
        if (rwPasswordJudge){
            registerInfo.put("rwPasswordInfo","前后密码一致");
        } else {
            registerCode = 0;
            registerInfo.put("rwPasswordInfo","前后密码不一致");
        }
        if (userMapper.queryCountBySuperName(name) == 1){
            registerCode = 0;
        }
        if (registerCode == 1){
            String userId = UUIDUtil.getUUID();
            String secretPassword = SecretUtil.secretString(userId);
            registerCode = userMapper.addAdmin(userId, name, secretPassword);
        }
        registerInfo.put("registerCode",registerCode);
        return registerInfo;
    }

    @Override
    public Map<String, Object> adminLogin(String name, String password) {
        Map<String, Object> loginInfo = new HashMap<>();
        Integer loginCode = 1;
        String secretPassword = SecretUtil.secretString(password);
        UserVo userInfo = userMapper.queryCountByNameAndPassword(name, secretPassword);
        if (userInfo != null){
            Map<String, String> claims = new HashMap<>();
            String id = userInfo.getId();
            String role = userInfo.getRole();
            claims.put("id", id);
            claims.put("role", role);
            String token = JWTUtil.createToken(claims);
            loginInfo.put("userInfo", loginCode);
            loginInfo.put("token", token);
        } else {
            loginCode = 0;
        }
        loginInfo.put("loginCode", loginCode);
        return loginInfo;
    }

    @Override
    public Integer updateUserInfo(String userId, String name) {
        Integer updateCode = userMapper.updateUserInfoById(userId, name);
        return updateCode;
    }

    @Override
    public Integer updateUserDirection(String userId, String direction) {
        Integer updateCode = userMapper.updateUserDirectionById(userId, direction);
        return updateCode;
    }

    @Override
    public Integer updateHeadPicture(String userId, MultipartFile headPicture) throws IOException {
        String imagePath = "C:/Users/Lenovo/Desktop/image/" + userId;
        //服务器路径
        //String imagePath = "/usr/local/src/spring/image/admin/" + delID;
        String headPicturePath = FileUtil.addImg(headPicture, imagePath);
        Integer updateCode = userMapper.updateUserHeaderById(userId, headPicturePath);
        return updateCode;
    }

    @Override
    public Integer updateEmail(String userId, String email) {
        Integer updateCode = userMapper.updateEmailById(userId, email);
        return updateCode;
    }

    @Override
    public Map<String, Object> updatePassword(String userId, String oldPassword, String newPassword, String rwPassword) {
        Map<String, Object> updateInfo = new HashMap<>();
        Integer updateCode = 1;
        Boolean ordPasswordJudge = userMapper.queryCountByIdAndPassword(userId, oldPassword) == 1;
        Boolean newPasswordJudge = passwordLen(oldPassword);
        Boolean rwPasswordJudge = oldPassword.equals(rwPassword);
        if (ordPasswordJudge){
            updateInfo.put("oldPassword","旧密码一致");
        } else {
            updateCode = 0;
            updateInfo.put("oldPassword","旧密码不一致");
        }
        if (newPasswordJudge){
            updateInfo.put("newPasswordInfo","密码格式正确");
        } else {
            updateCode = 0;
            updateInfo.put("newPasswordInfo","密码格式有误");
        }
        if (rwPasswordJudge){
            updateInfo.put("rwPasswordInfo","前后密码一致");
        } else {
            updateCode = 0;
            updateInfo.put("rwPasswordInfo","前后密码不一致");
        }
        updateInfo.put("updateCode", updateCode);
        if (updateCode == 1){
            String secretPassword = SecretUtil.secretString(newPassword);
            userMapper.updatePasswordById(userId, secretPassword);
        }
        return updateInfo;
    }

    @Override
    public Integer deleteUserById(String userId) {
        return null;
    }

    @Override
    public UserVo queryOneUser(String userId) {
        UserVo data = userMapper.queryOneUserById(userId);
        return data;
    }

    @Override
    public List<UserVo> listUserByDirection(String directionId) {
        List<UserVo> data = userMapper.listUsersByDirection(directionId);
        return data;
    }

    private Boolean passwordLen(String password) {
        int length = password.length();
        return (length >= 6) && (length <= 20);
    }

    private Boolean nameLen(String name) {
        int length = name.length();
        return (length >= 0) && (length <= 50);
    }

}
