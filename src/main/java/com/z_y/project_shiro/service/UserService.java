package com.z_y.project_shiro.service;

import com.z_y.project_shiro.domain.User;

public interface UserService
{
    User findAllUserInfoByUsername(String username);

    User findSimpleUserInfoById(int userId);

    User findSimpleUserInfoByUSername(String username);

    int insertUser(String username, String password);
}
