package com.z_y.project_shiro.dao;

import com.z_y.project_shiro.domain.User;
import com.z_y.project_shiro.domain.UserView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper
{
    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username") String username);

    @Select("select * from user where id = #{userId}")
    User findById(@Param("userId") int id);

    @Select("select id, username from user")
    List<UserView> findAllUser();

    @Select("select * from user where username = #{username} and password = #{pwd}")
    User findByUsernameAndPwd(@Param("username") String username, @Param("pwd") String pwd);

    @Insert("insert into user(username, password) values(#{username}, #{pwd})")
    int insertUser(@Param("username") String username, @Param("pwd") String pwd);
}
