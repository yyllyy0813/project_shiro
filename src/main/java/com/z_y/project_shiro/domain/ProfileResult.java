package com.z_y.project_shiro.domain;

import java.util.List;
import java.util.Map;

public class ProfileResult
{
    private String username;
    private Map<String, Object> roles;

    public ProfileResult(User user)
    {
        this.username = user.getUsername();
        List<Role> roleList = user.getRoleList();


        for (Role role : roleList)
        {
            List<Permission> permissionList = role.getPermissionList();
            for (Permission permission : permissionList)
            {

            }
        }
    }

}
