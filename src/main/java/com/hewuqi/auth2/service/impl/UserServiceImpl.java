package com.hewuqi.auth2.service.impl;

import com.hewuqi.auth2.dao.UserMapper;
import com.hewuqi.auth2.service.UserService;
import com.hewuqi.auth2.model.User;
import com.hewuqi.auth2.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/5 23:40
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getUserByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        return users;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
