package com.z_y.project_shiro.service;

import com.z_y.project_shiro.domain.Permission;
import com.z_y.project_shiro.domain.Role;
import com.z_y.project_shiro.domain.User;
import com.z_y.project_shiro.domain.UserView;

import java.util.List;

public interface UserService
{

    User findAllUserInfoByUsername(String username);

    User findSimpleUserInfoById(int userId);

    User findSimpleUserInfoByUSername(String username);

    int insertUser(String username, String password);

    List<Role> findRoleListByUserId(int userId);

    List<UserView> findAllUser();
}
