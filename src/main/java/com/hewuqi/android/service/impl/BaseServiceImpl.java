package com.hewuqi.android.service.impl;

import com.hewuqi.android.constant.AndroidCommonConstant;
import com.hewuqi.android.dao.UserMapper;
import com.hewuqi.android.model.User;
import com.hewuqi.android.param.UserInfo;
import com.hewuqi.android.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

import java.util.Date;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/10 16:17
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private UserMapper userMapper;

    private String salt = AndroidCommonConstant.SALT;

    @Override
    public boolean login(UserInfo userInfo) {
        User user = userMapper.selectByPrimaryKey(userInfo.getUsername());
        return user == null ? false : DigestUtils.md5DigestAsHex((userInfo.getPassword() + salt).getBytes()).equals(user.getPassword());
    }

    @Override
    public boolean regist(UserInfo userInfo) {
        //注册时需要先检查数据库中是否已存在用户名
        User user = userMapper.selectByPrimaryKey(userInfo.getUsername());
        if (user != null) {
            return false;
        }

        userInfo.setPassword(DigestUtils.md5DigestAsHex((userInfo.getPassword() + salt).getBytes()));
        return userMapper.insert(this.convertUserInfoToUser(userInfo)) == 1;
    }

    private User convertUserInfoToUser(UserInfo userInfo) {
        User user = new User();
        user.setUsername(userInfo.getUsername());
        user.setPassword(userInfo.getPassword());
        user.setEmail(userInfo.getEmail());
        user.setRegistDate(new Date());
        return  user;
    }
}
