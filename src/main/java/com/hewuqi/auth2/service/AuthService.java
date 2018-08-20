package com.hewuqi.auth2.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/5 18:46
 */
public interface AuthService {
    /**
     * 新用户注册
     * @param user
     */
    int regist(JSONObject user);
}
