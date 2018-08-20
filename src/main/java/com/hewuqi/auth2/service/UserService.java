package com.hewuqi.auth2.service;


import com.hewuqi.auth2.model.User;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/5 23:38
 */
public interface UserService {
    User getUserById(long id);
    List<User> getUserByUsername(String username);
    int insertUser(User user);
}
