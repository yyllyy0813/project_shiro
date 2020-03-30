package com.z_y.project_shiro.dao;

import com.z_y.project_shiro.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface RoleMapper
{
    @Select("select ur.id as id, r.name as name, r.description as description from user_role ur " +
            "left join role r on r.id=ur.role_id " +
            "where ur.user_id = #{userId}")
    @Results(
            value = {
                    @Result(id=true, property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "permissionList", column = "id",
                    many = @Many(select  = "com.z_y.project_shiro.dao.PermissionMapper.findPermissionListByRoleId", fetchType = FetchType.DEFAULT)
                    )
            }
    )
    List<Role> findRoleListByUserId(@Param("userId") int userId);
}
