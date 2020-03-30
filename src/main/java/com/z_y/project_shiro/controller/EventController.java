package com.z_y.project_shiro.controller;

import com.z_y.project_shiro.domain.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class EventController
{

    @RequestMapping("add")
    public JsonData add()
    {
        return JsonData.buildSuccess("增加事件");
    }

    @RequestMapping("delete")
    public JsonData delete()
    {
        return JsonData.buildSuccess("删除事件");
    }

    @RequestMapping("view")
    public JsonData view()
    {
        return JsonData.buildSuccess("查看事件");
    }

    @RequestMapping("eventList")
    public JsonData eventList()
    {
        return JsonData.buildSuccess("查看事件列表");
    }

}
