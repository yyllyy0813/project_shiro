package com.z_y.project_shiro.controller;

import com.z_y.project_shiro.domain.JsonData;
import com.z_y.project_shiro.domain.Role;
import com.z_y.project_shiro.domain.RoleView;
import com.z_y.project_shiro.domain.UserView;
import com.z_y.project_shiro.serviceImp.RoleServiceImp;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("role")
public class RoleController
{

    @Autowired
    RoleServiceImp roleServiceImp;

    @RequestMapping("roleList")
    public JsonData getRoleViewList()
    {
        Map<String, Object> info = new HashMap<>();
        List<RoleView> roleViewList = roleServiceImp.findAllRole();
        info.put("roleData", roleViewList);
        return JsonData.buildSuccess(info,"角色列表");
    }
}
