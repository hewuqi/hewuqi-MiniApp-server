package com.hewuqi.android.service;

import com.hewuqi.android.param.UserInfo;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/10 16:17
 */
public interface BaseService {
    /**
     * 登陆
     * @param user
     * @return
     */
    boolean login(UserInfo user);

    /**
     * 注册
     * @param user
     * @return
     */
    boolean regist(UserInfo user);
}
