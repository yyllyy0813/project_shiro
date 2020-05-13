package com.z_y.project_shiro.controller;

import com.z_y.project_shiro.domain.JsonData;
import com.z_y.project_shiro.domain.Permission;
import com.z_y.project_shiro.domain.User;
import com.z_y.project_shiro.domain.UserView;
import com.z_y.project_shiro.serviceImp.PermissionServiceImp;
import com.z_y.project_shiro.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class UserController
{
    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    PermissionServiceImp permissionServiceImp;

    @RequestMapping("register")
    public JsonData add()
    {
        return JsonData.buildSuccess("注册用户");
    }

    @RequestMapping("userList")
    public JsonData userList()
    {
        Map<String, Object> info = new HashMap<>();
        List<UserView> userViewList = userServiceImp.findAllUser();
        info.put("userData", userViewList);
        return JsonData.buildSuccess(info,"查看用户列表");
    }

    @RequestMapping("permissionList")
    public JsonData permissionList()
    {
        Map<String, Object> info = new HashMap<>();
        List<String> permissionList =  permissionServiceImp.findAllPermission();
        info.put("permissionData",permissionList);
        return JsonData.buildSuccess(info, "权限列表");
    }
}
