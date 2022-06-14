package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javapythonstory.code.entity.vo.user.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * <p>
     *     添加普通
     * </p>
     * @param username 用户名
     * @param email 用户邮箱
     * @param password 密码
     * @return
     */
    Integer addUser(String username,String email,String password);

    /**
     * <p>
     *     根据邮箱查询是否邮箱已存在
     * </p>
     * @param email 邮箱
     * @return
     */
    Integer queryCountByEmail(String email);

    /**
     * 通过邮箱和密码查询用户数量
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    UserVo queryCountByEmailAndPassword(String email, String password);

    /**
     * <p>
     *     添加管理员用户
     * </p>
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Integer addAdmin(String username, String password);

    /**
     * 查询管理员名字是否相同
     * @param username 用户名
     * @return
     */
    Integer queryCountBySuperName(String username);

    /**
     * <p>
     *     通过用户名和密码查询用户数量了
     * </p>
     * @param username 用户名
     * @param password 密码
     * @return
     */
    UserVo queryCountByNameAndPassword(String username, String password);

    /**
     * <p>
     *     用户修改头像
     * </p>
     * @param id 用户编号
     * @param headPath 用户头像
     * @return
     * @throws IOException
     */
    Integer updateUserHeaderById(Integer id, String headPath);

    /**
     * <p>
     *    修改用户名
     * </p>
     * @param id 用户编号
     * @param username 用户名
     * @return
     */
    Integer updateUserInfoById(Integer id, String username);

    /**
     * <p>
     *     修改学习方向
     * </p>
     * @param id 用户编号
     * @param direction 学习方向编号
     * @return
     */
    Integer updateUserDirectionById(Integer id, Integer direction);

    /**
     * <p>
     *     用户修改邮箱
     * </p>
     * @param id 用户编号
     * @param email 邮箱
     * @return
     */
    Integer updateEmailById(Integer id, String email);

    /**
     * <p>
     *     用户修改密码
     * </p>
     * @param id 用户编号
     * @param password 密码
     * @return
     */
    Integer updatePasswordById(Integer id, String password);

    /**
     * <p>
     *     通过编号和密码查询用户数量
     * </p>
     * @param id 用户编号
     * @param password 密码
     * @return
     */
    Integer queryCountByIdAndPassword(Integer id, String password);

    /**
     * <P>
     *     获取单个用户信息
     * </P>
     * @param id 用户编号
     * @return
     */
    UserVo queryOneUserById(Integer id);

    /**
     * <p>
     *     根据学习路线查询用户信息
     * </p>
     * @param direction 学习路线编号
     * @return
     */
    List<UserVo> listUsersByDirection(Integer direction);
}
