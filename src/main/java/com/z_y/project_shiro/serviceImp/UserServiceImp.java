package com.z_y.project_shiro.serviceImp;

import com.z_y.project_shiro.dao.RoleMapper;
import com.z_y.project_shiro.dao.UserMapper;
import com.z_y.project_shiro.domain.Role;
import com.z_y.project_shiro.domain.User;
import com.z_y.project_shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService
{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public User findAllUserInfoByUsername(String username)
    {

        User user = userMapper.findByUsername(username);

        List<Role> roleList = roleMapper.findRoleListByUserId(user.getId());

        user.setRoleList(roleList);

        return user;
    }

    @Override
    public User findSimpleUserInfoById(int userId)
    {
        return userMapper.findById(userId);
    }

    @Override
    public User findSimpleUserInfoByUSername(String username)
    {
        return userMapper.findByUsername(username);
    }

    @Override
    public int insertUser(String username, String password)
    {
        return userMapper.insertUser(username, password);
    }
}
