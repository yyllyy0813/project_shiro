package com.z_y.project_shiro.domain;

import java.io.Serializable;

public class JsonData implements Serializable
{

    public static final long serialVersionUID = 1L;

    private Integer code;
    private Object data;
    private String msg;

    public JsonData(Integer code, Object data, String msg)
    {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    // 成功
    public static JsonData buildSuccess()
    {
        return new JsonData(0, null, null);
    }

    // 成功
    public static JsonData buildSuccess(String msg)
    {
        return new JsonData(0, null, msg);
    }

    // 成功，传入数据
    public static JsonData buildSuccess(Object data)
    {
        return new JsonData(0, data, null);
    }

    // 成功，传入数据和描述信息
    public static JsonData buildSuccess(Object data, String msg)
    {
        return new JsonData(0, data, msg);
    }

    // 成功，传入状态码和数据
    public static JsonData buildSuccess(Object data, Integer code)
    {
        return new JsonData(code, data, null);
    }

    // 失败，传入描述信息
    public static JsonData buildError(String msg)
    {
        return new JsonData(-1, null, msg);
    }

    // 失败，传入状态码和描述信息
    public static JsonData buildError(String msg, Integer code)
    {
        return new JsonData(code, null, msg);
    }

    public static JsonData buildError(Object data, String msg)
    {
        return new JsonData(-1, data, msg);
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString()
    {
        return "JsonData{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
