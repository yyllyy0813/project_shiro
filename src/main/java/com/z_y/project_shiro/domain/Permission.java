package com.z_y.project_shiro.domain;

import java.io.Serializable;

public class Permission implements Serializable
{
    private int id;

    private String name;

//    private String url;

    /**
     * 权限类型 1为菜单 2为功能（按钮）3为API
     */
    private Integer type;

    /**
     * 权限编码
     */
    private String code;

    private String description;

    private String pid;

    private Integer enVisible;

    public Permission(String name, Integer type, String code, String description)
    {
        this.name = name;
        this.type = type;
        this.code = code;
        this.description = description;
    }

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

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getPid()
    {
        return pid;
    }

    public void setPid(String pid)
    {
        this.pid = pid;
    }

    public Integer getEnVisible()
    {
        return enVisible;
    }

    public void setEnVisible(Integer enVisible)
    {
        this.enVisible = enVisible;
    }
}
