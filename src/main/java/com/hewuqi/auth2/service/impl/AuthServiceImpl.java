package com.hewuqi.auth2.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hewuqi.auth2.service.AuthService;
import com.hewuqi.auth2.service.UserService;
import com.hewuqi.auth2.model.User;
import com.hewuqi.utils.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/5 23:20
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Override
    public int regist(JSONObject params) {
        User user = new User();

        //先较验用户名是否已存在
        String username = params.getString("username");
        List<User> users = userService.getUserByUsername(username);
        if (users.size() > 0) {
            //用户名已存在
            return ErrorCodeEnum.USER_EXIST.getCode();
        }

        String nickname = params.getString("nickname");
        String activeId = params.getString("activeId");
        String activeCode = params.getString("activeCode");

        user.setUsername(username);
        user.setNickname(nickname);
        user.setActiveCodeId(activeId);

        if (userService.insertUser(user) > 0) { //注册成功
            return ErrorCodeEnum.SUCCESS.getCode();
        }

        return ErrorCodeEnum.UNKONWN_ERROR.getCode();
    }
}
