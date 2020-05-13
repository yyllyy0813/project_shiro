package com.z_y.project_shiro.serviceImp;

import com.z_y.project_shiro.dao.PermissionMapper;
import com.z_y.project_shiro.domain.Permission;
import com.z_y.project_shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImp implements PermissionService
{
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<String> findAllPermission()
    {
        return permissionMapper.findAllPermission();
    }
}
