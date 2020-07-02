package com.z_y.project_shiro.domain;

import javax.persistence.Entity;
import java.io.Serializable;

public class PermissionApi implements Serializable
{
    private int id;

    private String apiUrl;

    private String apiMethod;

    private String apiLevel;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getApiUrl()
    {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl)
    {
        this.apiUrl = apiUrl;
    }

    public String getApiMethod()
    {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod)
    {
        this.apiMethod = apiMethod;
    }

    public String getApiLevel()
    {
        return apiLevel;
    }

    public void setApiLevel(String apiLevel)
    {
        this.apiLevel = apiLevel;
    }
}
