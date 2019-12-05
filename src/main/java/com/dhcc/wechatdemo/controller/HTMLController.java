package com.dhcc.wechatdemo.controller;

import com.alibaba.fastjson.JSON;
import com.dhcc.wechatdemo.entity.user.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Liu Denghui
 * @time: 2019/11/25 10:54
 */
@Controller
public class HTMLController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/test")
    public String test(){
        List<Tag> list = new ArrayList<>();
        Tag tag1 = new Tag();
        tag1.setId(1);
        tag1.setName("A");
        Tag tag2 = new Tag();
        tag2.setId(2);
        tag2.setName("B");
        list.add(tag1);
        list.add(tag2);
        System.out.println(JSON.toJSONString(list));

        Tag[] tags = new Tag[]{tag2, tag1};
        System.out.println(JSON.toJSONString(tags));


        System.out.println(JSON.toJSONString(tag1));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tagid", tag1.getId());
        map.put("tagname", tag1.getName());
        System.out.println(JSON.toJSONString(map));
        return "index";
    }
}
