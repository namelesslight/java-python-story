package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.javapythonstory.code.entity.vo.user.UpdateDirectionVo;
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
 * @author ZCL
 * @since 2022-06-08
 */
public interface UserService extends IService<User> {

    /**
     * <p>
     *     用户注册
     * </p>
     * @param name 用户名
     * @param email 用户邮箱
     * @param code 验证码
     * @param password 密码
     * @param rwPassword 再次输入密码
     * @return
     */
    Map<String, Object> userRegister(String name, String email,String code, String password, String rwPassword);

    /**
     * <p>
     *     发送邮箱验证码
     * </p>
     * @param email 邮箱
     * @return
     */
    String sendMessage(String email);

    /**
     * <p>
     *     用户登录
     * </p>
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    Map<String, Object> userLogin(String email, String password);

    /**
     * <p>
     *     管理员注册
     * </p>
     * @param name 用户名
     * @param password 密码
     * @param rwPassword 再次输入密码
     * @return
     */
    Map<String, Object> adminRegister(String name, String password, String rwPassword);

    /**
     * <p>
     *     管理员登录
     * </p>
     * @param name 用户名
     * @param password 密码
     * @return
     */
    Map<String, Object> adminLogin(String name, String password);

    /**
     * <p>
     *    修改用户名
     * </p>
     * @param userId 用户编号
     * @param name 用户名
     * @return
     */
    Integer updateUserInfo(Integer userId, String name);

    /**
     * <p>
     *     修改学习方向
     * </p>
     * @param userId 用户编号
     * @param direction 学习方向编号
     * @return
     */
    UpdateDirectionVo updateUserDirection(Integer userId, Integer direction);

    /**
     * <p>
     *     用户修改头像
     * </p>
     * @param userId 用户编号
     * @param headPicture 用户头像
     * @return
     * @throws IOException
     */
    Integer updateHeadPicture(Integer userId, MultipartFile headPicture) throws IOException;

    /**
     * <p>
     *     用户修改邮箱
     * </p>
     * @param userId 用户编号
     * @param email 邮箱
     * @return
     */
    Integer updateEmail(Integer userId, String email);

    /**
     * <p>
     *     用户修改密码
     * </p>
     * @param userId 用户编号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param rwPassword 再次输入新密码
     * @return
     */
    Map<String, Object> updatePassword(Integer userId, String oldPassword, String newPassword, String rwPassword);

    Integer deleteUserById(Integer userId);

    /**
     * <P>
     *     获取单个用户信息
     * </P>
     * @param userId 用户编号
     * @return
     */
    UserVo queryOneUser(Integer userId);

    /**
     * <p>
     *     根据学习路线查询用户信息
     * </p>
     * @param directionId 学习路线编号
     * @return
     */
    List<UserVo> listUserByDirection(Integer directionId);
}
