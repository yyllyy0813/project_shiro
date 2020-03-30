package com.z_y.project_shiro.controller;

import com.z_y.project_shiro.domain.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class UserController
{
    @RequestMapping("register")
    public JsonData add()
    {
        return JsonData.buildSuccess("注册用户");
    }

    @RequestMapping("userList")
    public JsonData userList()
    {
        return JsonData.buildSuccess("查看用户列表");
    }


}
