package com.z_y.project_shiro.serviceImp;

import com.z_y.project_shiro.dao.PermissionMapper;
import com.z_y.project_shiro.dao.RoleMapper;
import com.z_y.project_shiro.domain.Permission;
import com.z_y.project_shiro.domain.Role;
import com.z_y.project_shiro.domain.RoleView;
import com.z_y.project_shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService
{

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<RoleView> findAllRole()
    {
        List<RoleView> roleViewList = roleMapper.findAllRole();
        for (RoleView roleView:roleViewList)
        {
            List<String> permissionNameList = new ArrayList<>();
            List<Permission> permissionList = permissionMapper.findPermissionListByRoleId(roleView.getId());
            for (Permission permission:permissionList)
            {
                if (permission != null)
                {
                    permissionNameList.add(permission.getName());
                }
            }
            roleView.setPermissionNameList(permissionNameList);
        }
        return roleViewList;
    }
}
