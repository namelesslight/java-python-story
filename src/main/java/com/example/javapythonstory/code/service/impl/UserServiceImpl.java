package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.User;
import com.example.javapythonstory.code.mapper.UserMapper;
import com.example.javapythonstory.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
