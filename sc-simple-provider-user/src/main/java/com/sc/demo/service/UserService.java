package com.sc.demo.service;

import com.sc.demo.dao.UserInfoMapper;
import com.sc.demo.entity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserById(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

}
