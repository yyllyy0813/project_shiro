package com.z_y.project_shiro.domain;

import java.io.Serializable;

public class PermissionIcon implements Serializable
{
    private int id;

    /**
     * 按钮的属性
     */
    private String pointClass;

    private String pointIcon;

    private String pointStatus;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPointClass()
    {
        return pointClass;
    }

    public void setPointClass(String pointClass)
    {
        this.pointClass = pointClass;
    }

    public String getPointIcon()
    {
        return pointIcon;
    }

    public void setPointIcon(String pointIcon)
    {
        this.pointIcon = pointIcon;
    }

    public String getPointStatus()
    {
        return pointStatus;
    }

    public void setPointStatus(String pointStatus)
    {
        this.pointStatus = pointStatus;
    }
}
