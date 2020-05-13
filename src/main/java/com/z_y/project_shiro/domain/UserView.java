package com.z_y.project_shiro.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserView implements Serializable
{
    private int id;

    private String username;

    private Date createData;

    private List<String> roleNameList;

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

    public List<String> getRoleNameList()
    {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList)
    {
        this.roleNameList = roleNameList;
    }
}

