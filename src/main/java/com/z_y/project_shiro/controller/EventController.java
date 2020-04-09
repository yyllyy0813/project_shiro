package com.z_y.project_shiro.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.xml.fastinfoset.stax.events.EventBase;
import com.z_y.project_shiro.domain.Event;
import com.z_y.project_shiro.domain.JsonData;
import com.z_y.project_shiro.service.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("event")
public class EventController
{

    @Autowired
    private EventRepository eventRepository;

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

    @GetMapping("/findAll/{page}/{size}")
    public JsonData findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size)
    {
        Map<String, Object> eventData = new HashMap<>();
        PageRequest request = PageRequest.of(page, size);
        eventData.put("eventData", eventRepository.findAll(request));
        return JsonData.buildSuccess(eventData);
    }

    /**
     * 从前端获取新的事件属性增加事件
     * @param event
     * @return
     */
    @PostMapping("save")
    public JsonData save(@RequestBody Event event)
    {
        System.out.println(event.getTime());

        Calendar time = event.getTime();
        System.out.println(time.getTimeZone());
        time.set(Calendar.DATE, time.get(Calendar.DATE)+1);
        event.setTime(time);
        System.out.println(event.getTime());

        Event result = eventRepository.save(event);
        if(result != null)
        {
            return JsonData.buildSuccess("添加成功");
        }
        else
        {
            return JsonData.buildError("添加失败");
        }
    }

    @PutMapping("update")
    public JsonData update(@RequestBody Event event)
    {
        System.out.println(event.getTime());

        Calendar time = event.getTime();
        System.out.println(time.getTimeZone());
        time.set(Calendar.DATE, time.get(Calendar.DATE)+1);
        event.setTime(time);
        System.out.println(event.getTime());

        Event result = eventRepository.save(event);
        if(result != null)
        {
            return JsonData.buildSuccess("修改成功");
        }
        else
        {
            return JsonData.buildError("修改失败");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public JsonData deleteById(@PathVariable("id") Integer id)
    {
        eventRepository.deleteById(id);
        return JsonData.buildSuccess("删除成功");
    }

    @RequestMapping("eventList")
    public JsonData eventList()
    {

        return JsonData.buildSuccess("查看事件列表");
    }

    @GetMapping("/findById/{id}")
    public JsonData findById(@PathVariable("id") Integer id){
        Event event = eventRepository.findById(id).get();
        return JsonData.buildSuccess(event);

    }

}
