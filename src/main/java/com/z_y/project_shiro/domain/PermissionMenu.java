package com.z_y.project_shiro.domain;

import java.io.Serializable;

public class PermissionMenu implements Serializable
{
    private String id;

    private String menuIcon;

    private String menuOrder;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getMenuIcon()
    {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon)
    {
        this.menuIcon = menuIcon;
    }

    public String getMenuOrder()
    {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder)
    {
        this.menuOrder = menuOrder;
    }
}
