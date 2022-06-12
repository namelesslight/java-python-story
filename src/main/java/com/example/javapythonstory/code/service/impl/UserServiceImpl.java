package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.User;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
import com.example.javapythonstory.code.mapper.UserMapper;
import com.example.javapythonstory.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javapythonstory.code.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
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

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender jms;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String EMAIL = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    @Override
    public Map<String, Object> userRegister(String name, String email,String code, String password, String rwPassword) {
        Map<String, Object> registerInfo = new HashMap<>();
        String realCode = (String) RedisUtil.getValue(email);
        Integer registerCode = 1;
        Boolean nameJudge = nameLen(name);
        Boolean emailJudge = Pattern.matches(EMAIL, email);
        Boolean codeJudge = code.equals(realCode);
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
        if (codeJudge){
            registerInfo.put("codeInfo","验证码正确");
        } else {
            registerCode = 0;
            registerInfo.put("codeInfo","验证码错误,请查看邮箱是否正确");
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
            registerInfo.put("emailInfo","邮箱已被使用");
        }
        registerInfo.put("registerCode",registerCode);
        if (registerCode == 1){
            String secretPassword = SecretUtil.secretString(password);
            userMapper.addUser(name, email, secretPassword);
            //Redis删除对应邮箱验证码
            RedisUtil.remove(email);
        }
        return registerInfo;
    }

    @Override
    public String sendMessage(String email) {
        String code = this.getRandomCode();
        //相对应邮箱发送信息
        try{
            MimeMessage message = null;
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject("Python学习网站");
            helper.setText("验证码为:" + code);
            jms.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set(email, code, 30L, TimeUnit.MINUTES);
        return "success";
    }

    @Override
    public Map<String, Object> userLogin(String email, String password) {
        Map<String, Object> loginInfo = new HashMap<>();
        Integer loginCode = 1;
        String secretPassword = SecretUtil.secretString(password);
        UserVo userInfo = userMapper.queryCountByEmailAndPassword(email, secretPassword);
        if (userInfo != null){
            Map<String, String> claims = new HashMap<>();
            Integer id = userInfo.getId();
            String role = userInfo.getRole();
            claims.put("id", String.valueOf(id));
            claims.put("role", role);
            String token = JWTUtil.createToken(claims);
            loginInfo.put("userInfo", userInfo);
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
            String secretPassword = SecretUtil.secretString(password);
            registerCode = userMapper.addAdmin(name, secretPassword);
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
            Integer id = userInfo.getId();
            String role = userInfo.getRole();
            claims.put("id", String.valueOf(id));
            claims.put("role", role);
            String token = JWTUtil.createToken(claims);
            loginInfo.put("userInfo", userInfo);
            loginInfo.put("token", token);
        } else {
            loginCode = 0;
        }
        loginInfo.put("loginCode", loginCode);
        return loginInfo;
    }

    @Override
    public Integer updateUserInfo(Integer userId, String name) {
        Integer updateCode = userMapper.updateUserInfoById(userId, name);
        return updateCode;
    }

    @Override
    public Integer updateUserDirection(Integer userId, Integer direction) {
        Integer updateCode = userMapper.updateUserDirectionById(userId, direction);
        return updateCode;
    }

    @Override
    public Integer updateHeadPicture(Integer userId, MultipartFile headPicture) throws IOException {
//        String imagePath = "C:/Users/Lenovo/Desktop/image/" + userId;
        //服务器路径
        String imagePath = "/usr/local/src/spring/file/image/" + userId;
        String headPicturePath = FileUtil.addImg(headPicture, imagePath);
        Integer updateCode = userMapper.updateUserHeaderById(userId, headPicturePath);
        return updateCode;
    }

    @Override
    public Integer updateEmail(Integer userId, String email) {
        Integer updateCode = userMapper.updateEmailById(userId, email);
        return updateCode;
    }

    @Override
    public Map<String, Object> updatePassword(Integer userId, String oldPassword, String newPassword, String rwPassword) {
        Map<String, Object> updateInfo = new HashMap<>();
        Integer updateCode = 1;
        String secretOldPassword = SecretUtil.secretString(oldPassword);
        Boolean oldPasswordJudge = userMapper.queryCountByIdAndPassword(userId, secretOldPassword) == 1;
        Boolean newPasswordJudge = passwordLen(oldPassword);
        Boolean rwPasswordJudge = newPassword.equals(rwPassword);
        if (oldPasswordJudge){
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
    public Integer deleteUserById(Integer userId) {
        return null;
    }

    @Override
    public UserVo queryOneUser(Integer userId) {
        UserVo data = userMapper.queryOneUserById(userId);
        return data;
    }

    @Override
    public List<UserVo> listUserByDirection(Integer directionId) {
        List<UserVo> data = userMapper.listUsersByDirection(directionId);
        return data;
    }

    private Boolean passwordLen(String password) {
        int length = password.length();
        return (length >= 6) && (length <= 20);
    }

    private Boolean nameLen(String name) {
        int length = name.length();
        return length <= 50;
    }

    private static String getRandomCode(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++){
            Integer num = random.nextInt(10);
            sb.append(num);
        }
        return sb.toString();
    }
}
