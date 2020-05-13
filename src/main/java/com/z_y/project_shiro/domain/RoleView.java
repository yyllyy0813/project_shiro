package com.z_y.project_shiro.domain;

import java.util.List;

public class RoleView
{
    private int id;

    private String name;

    private String description;

    private List<String> permissionNameList;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<String> getPermissionNameList()
    {
        return permissionNameList;
    }

    public void setPermissionNameList(List<String> permissionNameList)
    {
        this.permissionNameList = permissionNameList;
    }
}
