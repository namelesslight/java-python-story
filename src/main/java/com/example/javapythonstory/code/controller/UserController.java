package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.user.*;
import com.example.javapythonstory.code.result.Result;
import com.example.javapythonstory.code.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping("/base/register")
    public Result userRegister(@RequestBody UserRegisterDto userRegisterDto){
        return null;
    }

    @PostMapping("/base/login")
    public Result userLogin(@RequestBody UserLoginDto userLoginDto){
        return null;
    }

    @PostMapping("/base/adminLogin")
    public Result adminRegister(@RequestBody AdminRegisterDto adminRegisterDto){
        return null;
    }

    @PostMapping("/base/adminRegister")
    public Result adminLogin(@RequestBody AdminLoginDto adminLoginDto){
        return null;
    }

    @PostMapping("/common/updateUserInfo")
    public Result updateUserInfo(@RequestBody UpdateUserInfoDto updateUserInfoDto){
        return null;
    }

    @PostMapping("/common/updateUserDirection")
    public Result updateUserDirection(@RequestBody UpdateUserDirectionDto updateUserDirectionDto){
        return null;
    }

    @PostMapping("/common/updateHeadPicture")
    public Result updateHeadPicture(@RequestBody UpdateUserPictureDto updateUserPictureDto){
        return null;
    }

    @PostMapping("/common/updateEmail")
    public Result updateEmail(@RequestBody UpdateEmailDto updateEmailDto){
        return null;
    }

    @PostMapping("/common/updatePassword")
    public Result updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){
        return null;
    }

    @PostMapping("/super/deleteUser")
    public Result deleteUserById(){
        return null;
    }

    @PostMapping("/common/queryOneUser")
    public Result queryOneUser(@RequestParam String userId){
        return null;
    }

    @PostMapping("/super/listUserByDirection")
    public Result listUserByDirection(@RequestParam String directionId){
        return null;
    }

}
