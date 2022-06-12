package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.user.*;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/base/userRegister")
    public WebResult userRegister(@RequestBody UserRegisterDto userRegisterDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> registerInfo = userService.userRegister(
                userRegisterDto.getUsername(),
                userRegisterDto.getEmail(),
                userRegisterDto.getPassword(),
                userRegisterDto.getRwPassword());
        message.put("registerInfo", registerInfo);
        return new WebResult().result200(message, "/base/userRegister");
    }

    @PostMapping("/base/userLogin")
    public WebResult userLogin(@RequestBody UserLoginDto userLoginDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> loginInfo = userService.userLogin(
                userLoginDto.getEmail(),
                userLoginDto.getPassword());
        message.put("loginInfo", loginInfo);
        return new WebResult().result200(message, "/base/userLogin");
    }

    @PostMapping("/base/adminRegister")
    public WebResult adminRegister(@RequestBody AdminRegisterDto adminRegisterDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> registerInfo = userService.adminRegister(
                adminRegisterDto.getAdminName(),
                adminRegisterDto.getPassword(),
                adminRegisterDto.getRwPassword());
        message.put("registerInfo",registerInfo);
        return new WebResult().result200(message ,"/base/adminRegister");
    }

    @PostMapping("/base/adminLogin")
    public WebResult adminLogin(@RequestBody AdminLoginDto adminLoginDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> loginInfo = userService.adminLogin(
                adminLoginDto.getAdminName(),
                adminLoginDto.getPassword());
        message.put("loginInfo", loginInfo);
        return new WebResult().result200(message, "/base/adminLogin");
    }

    @PostMapping("/common/updateUserInfo")
    public WebResult updateUserInfo(@RequestBody UpdateUserInfoDto updateUserInfoDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = userService.updateUserInfo(
                updateUserInfoDto.getUserId(),
                updateUserInfoDto.getUsername());
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/common/updateUserInfo");
    }

    @PostMapping("/common/updateUserDirection")
    public WebResult updateUserDirection(@RequestBody UpdateUserDirectionDto updateUserDirectionDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = userService.updateUserDirection(
                updateUserDirectionDto.getUserId(),
                updateUserDirectionDto.getUserDirection());
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/common/updateUserDirection");
    }

    @PostMapping("/common/updateHeadPicture")
    public WebResult updateHeadPicture(@RequestParam Integer id,
                                       @RequestParam MultipartFile headPicture) throws IOException {
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = userService.updateHeadPicture(id,headPicture);
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/common/updateHeadPicture");
    }

    @PostMapping("/common/updateEmail")
    public WebResult updateEmail(@RequestBody UpdateUserEmailDto updateUserEmailDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = userService.updateEmail(
                updateUserEmailDto.getUserId(),
                updateUserEmailDto.getNewEmail());
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/common/updateEmail");
    }

    @PostMapping("/common/updatePassword")
    public WebResult updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> updateInfo = userService.updatePassword(
                updatePasswordDto.getId(),
                updatePasswordDto.getOldPassword(),
                updatePasswordDto.getNewPassword(),
                updatePasswordDto.getRwPassword());
        message.put("updateInfo", updateInfo);
        return new WebResult().result200(message, "/common/updatePassword");
    }

    @GetMapping("/common/queryOneUser")
    public WebResult queryOneUser(@RequestParam Integer userId){
        Map<String, Object> message = new HashMap<>();
        UserVo userInfo = userService.queryOneUser(userId);
        message.put("userInfo", userInfo);
        return new WebResult().result200(message, "/common/queryOneUser");
    }

    @GetMapping("/super/listUserByDirection")
    public WebResult listUserByDirection(@RequestParam Integer directionId){
        Map<String, Object> message = new HashMap<>();
        List<UserVo> userInfo = userService.listUserByDirection(directionId);
        message.put("userInfo", userInfo);
        return new WebResult().result200(message, "/super/listUserByDirection");
    }

    @PostMapping("/base/sneCodeMessage")
    public WebResult sendCodeMessage(){
        return null;
    }

}
