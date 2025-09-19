package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.SqlSessionFactoryUtil;

public class UserService {
//    获取sessionfactory
    SqlSessionFactory factoryUtil = SqlSessionFactoryUtil.getSqlSessionFactory();

    public User login(String name, String password) {
        SqlSession sqlSession = factoryUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findOne(name, password);
        sqlSession.close();

        if (user != null) {
            // Set password to null before returning, for security
            user.setPassword(null);
        }

        return user;
    }
}
