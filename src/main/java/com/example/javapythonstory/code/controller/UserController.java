package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.user.*;
import com.example.javapythonstory.code.entity.vo.user.UpdateDirectionVo;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
import com.example.javapythonstory.code.result.Result;
import com.example.javapythonstory.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * <p>
     *     用户注册
     * </p>
     * @param userRegisterDto 用户注册DTO
     * @return
     */
    @PostMapping("/base/userRegister")
    public Result userRegister(@RequestBody UserRegisterDto userRegisterDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> registerInfo = userService.userRegister(
                userRegisterDto.getUsername(),
                userRegisterDto.getEmail(),
                userRegisterDto.getCode(),
                userRegisterDto.getPassword(),
                userRegisterDto.getRwPassword());
        message.put("registerInfo", registerInfo);
        return new Result().result200(message, "/base/userRegister");
    }

    /**
     * <p>
     *     发送邮箱验证码
     * </p>
     * @param sendMessageDto 发送DTO
     * @return
     */
    @PostMapping("/base/sendMessage")
    public Result sendMessage(@RequestBody SendMessageDto sendMessageDto) {
        String email = sendMessageDto.getEmail();
        String message = userService.sendMessage(email);
        return new Result().result200(message,"/base/sendMessage");
    }

    /**
     * <p>
     *     用户登录
     * </p>
     * @param userLoginDto 用户登录DTO
     * @return
     */
    @PostMapping("/base/userLogin")
    public Result userLogin(@RequestBody UserLoginDto userLoginDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> loginInfo = userService.userLogin(
                userLoginDto.getEmail(),
                userLoginDto.getPassword());
        message.put("loginInfo", loginInfo);
        return new Result().result200(message, "/base/userLogin");
    }

    /**
     * <p>
     *     管理员注册
     * </p>
     * @param adminRegisterDto 管理员注册DTO
     * @return
     */
    @PostMapping("/base/adminRegister")
    public Result adminRegister(@RequestBody AdminRegisterDto adminRegisterDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> registerInfo = userService.adminRegister(
                adminRegisterDto.getAdminName(),
                adminRegisterDto.getPassword(),
                adminRegisterDto.getRwPassword());
        message.put("registerInfo",registerInfo);
        return new Result().result200(message ,"/base/adminRegister");
    }

    /**
     * <p>
     *     管理员登录
     * </p>
     * @param adminLoginDto 管理员登录DTO
     * @return
     */
    @PostMapping("/base/adminLogin")
    public Result adminLogin(@RequestBody AdminLoginDto adminLoginDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> loginInfo = userService.adminLogin(
                adminLoginDto.getAdminName(),
                adminLoginDto.getPassword());
        message.put("loginInfo", loginInfo);
        return new Result().result200(message, "/base/adminLogin");
    }

    /**
     * <p>
     *     修改用户名
     * </p>
     * @param updateUserInfoDto 修改用户名DTO
     * @return
     */
    @PostMapping("/common/updateUserInfo")
    public Result updateUserInfo(@RequestBody UpdateUserInfoDto updateUserInfoDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = userService.updateUserInfo(
                updateUserInfoDto.getUserId(),
                updateUserInfoDto.getUsername());
        message.put("updateCode", updateCode);
        return new Result().result200(message, "/common/updateUserInfo");
    }

    /**
     * <p>
     *     修改学习方向
     * </p>
     * @param updateUserDirectionDto 修改学习方向DTO
     * @return
     */
    @PostMapping("/common/updateUserDirection")
    public Result updateUserDirection(@RequestBody UpdateUserDirectionDto updateUserDirectionDto){
        Map<String, Object> message = new HashMap<>();
        UpdateDirectionVo updateInfo = userService.updateUserDirection(
                updateUserDirectionDto.getUserId(),
                updateUserDirectionDto.getUserDirection());
        message.put("updateInfo", updateInfo);
        return new Result().result200(message, "/common/updateUserDirection");
    }

    /**
     * <p>
     *     用户修改头像
     * </p>
     * @param id 用户编号
     * @param headPicture 用户头像
     * @return
     * @throws IOException
     */
    @PostMapping("/common/updateHeadPicture")
    public Result updateHeadPicture(@RequestParam Integer id,
                                    @RequestParam MultipartFile headPicture) throws IOException {
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = userService.updateHeadPicture(id,headPicture);
        message.put("updateCode", updateCode);
        return new Result().result200(message, "/common/updateHeadPicture");
    }

    /**
     * <p>
     *     用户修改邮箱
     * </p>
     * @param updateUserEmailDto 修改邮箱DTO
     * @return
     */
    @PostMapping("/common/updateEmail")
    public Result updateEmail(@RequestBody UpdateUserEmailDto updateUserEmailDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = userService.updateEmail(
                updateUserEmailDto.getUserId(),
                updateUserEmailDto.getNewEmail());
        message.put("updateCode", updateCode);
        return new Result().result200(message, "/common/updateEmail");
    }

    /**
     * <p>
     *     用户修改密码
     * </p>
     * @param updatePasswordDto 修改密码DTO
     * @return
     */
    @PostMapping("/common/updatePassword")
    public Result updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> updateInfo = userService.updatePassword(
                updatePasswordDto.getId(),
                updatePasswordDto.getOldPassword(),
                updatePasswordDto.getNewPassword(),
                updatePasswordDto.getRwPassword());
        message.put("updateInfo", updateInfo);
        return new Result().result200(message, "/common/updatePassword");
    }

    /**
     * <p>
     *     获取单个用户学习
     * </p>
     * @param userId 用户编号
     * @return
     */
    @GetMapping("/common/queryOneUser")
    public Result queryOneUser(@RequestParam Integer userId){
        Map<String, Object> message = new HashMap<>();
        UserVo userInfo = userService.queryOneUser(userId);
        message.put("userInfo", userInfo);
        return new Result().result200(message, "/common/queryOneUser");
    }

    /**
     * <p>
     *     根据学习路线查询用户学习
     * </p>
     * @param directionId 学习路线编号
     * @return
     */
    @GetMapping("/super/listUserByDirection")
    public Result listUserByDirection(@RequestParam Integer directionId){
        Map<String, Object> message = new HashMap<>();
        List<UserVo> userInfo = userService.listUserByDirection(directionId);
        message.put("userInfo", userInfo);
        return new Result().result200(message, "/super/listUserByDirection");
    }

}
