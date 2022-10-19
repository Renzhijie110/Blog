package com.zhijie.daily.service;

import com.zhijie.daily.po.User;

public interface UserService {
    /**
     * 获取用户名、密码
     * @param username
     * @param password
     * @return
     */
    User checkUser(String username, String password);
}
