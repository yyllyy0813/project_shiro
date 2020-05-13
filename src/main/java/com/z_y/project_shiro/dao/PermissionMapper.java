package com.z_y.project_shiro.dao;

import com.z_y.project_shiro.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper
{
    @Select("select p.id as id, p.name as name, p.url as url from role_permission rp " +
            "left join permission p on p.id=rp.permission_id " +
            "where rp.role_id = #{roleId}")
    List<Permission> findPermissionListByRoleId(@Param("roleId") int roleId);

    @Select("select name from permission")
    List<String> findAllPermission();
}
