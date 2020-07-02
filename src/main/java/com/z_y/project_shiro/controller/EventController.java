/**
 * 事件增加、列表、波形
 */
package com.z_y.project_shiro.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;
import com.sun.xml.fastinfoset.stax.events.EventBase;
import com.z_y.project_shiro.domain.Event;
import com.z_y.project_shiro.domain.JsonData;
import com.z_y.project_shiro.service.EventRepository;
import com.z_y.project_shiro.utils.MatDataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @RequestMapping("eventChart")
    public JsonData eventData() throws IOException
    {
//        String path = "/Volumes/NO NAME/次声数据/次声数据/次声背景事件/次声信号的事件数据/*20141024020350 sc/_NO1.mat";
        String path = "/Volumes/NO NAME/次声数据/次声数据/次声背景事件/次声信号的事件数据/20140826113302 GZ/_NO4.mat";
        MatDataReader matDataReader = new MatDataReader(path);
        double[][] filterData = matDataReader.getFilterData();
        double[][] originalData = matDataReader.getOriginalData();
        double[][] timeData = matDataReader.getTimeData();
        Map<String, Object> info = new HashMap<>();
        info.put("filterData", filterData);
        info.put("originalData", originalData);
        info.put("timeData", timeData);
        return JsonData.buildSuccess(info,"查看事件的波形");
    }

}
