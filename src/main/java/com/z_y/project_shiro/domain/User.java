package com.z_y.project_shiro.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable
{
    private int id;

    private String username;

    private String password;

    private Date createData;

    private String salt;

    private List<Role> roleList;

    public List<Role> getRoleList()
    {
        return roleList;
    }

    public void setRoleList(List<Role> roleList)
    {
        this.roleList = roleList;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Date getCreateData()
    {
        return createData;
    }

    public void setCreateData(Date createData)
    {
        this.createData = createData;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }
}
