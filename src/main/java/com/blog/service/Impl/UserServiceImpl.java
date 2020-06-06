package com.blog.service.Impl;

import com.blog.dao.UserMapper;
import com.blog.pojo.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }
}
