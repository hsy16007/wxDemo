package com.dhcc.wechatdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.entity.AccessToken;
import com.dhcc.wechatdemo.entity.menu.base.*;
import com.dhcc.wechatdemo.service.BaseService;
import com.dhcc.wechatdemo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 菜单相关控制层
 * @author: Liu Denghui
 * @time: 2019/11/26 14:37
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    BaseService baseService;
    @Autowired
    MenuService menuService;

    /**
     * 创建菜单
     * @return string
     */
    @RequestMapping("/createMenu")
    public JSONObject createMenu(){
        AccessToken token = baseService.getAccessToken();

        Menu menu = new Menu();

        ComplexButton button1 = new ComplexButton();
        button1.setName("选择");
        //view类型按钮
        ViewButton button1_1 = new ViewButton();
        button1_1.setType("view");
        button1_1.setName("搜索");
        button1_1.setUrl("http://www.baidu.com/");
        //media_id类型按钮
        OtherButton button1_2 = new OtherButton();
        button1_2.setType("media_id");
        button1_2.setName("视频");
        button1_2.setMedia_id("0gJtGI8J6ZGeCeFMFAYU9W0RbmhYX37cHya3QAnVPVk");
        //普通类型按钮
        CommonButton button1_3 = new CommonButton();
        button1_3.setType("click");
        button1_3.setName("点击");
        button1_3.setKey("图片");
        //view_limited类型按钮
//        OtherButton button1_4 = new OtherButton();
//        button1_4.setType("view_limited");
//        button1_4.setName("图文消息");
//        button1_4.setMedia_id("0gJtGI8J6ZGeCeFMFAYU9W0RbmhYX37cHya3QAnVPVk");
        //小程序类型按钮
//        MiniprogramButton button1_4 = new MiniprogramButton();
//        button1_4.setType("miniprogram");
//        button1_4.setName("小程序");
//        button1_4.setUrl("http://mp.weixin.qq.com");
//        button1_4.setAppid();
//        button1_4.setPagepath();
        button1.setSub_button(new Button[]{button1_1,button1_2,button1_3});

        //其他类型按钮
        ComplexButton button2 = new ComplexButton();
        button2.setName("其他");
        //系统拍照发图
        CommonButton button2_1 = new CommonButton();
        button2_1.setType("pic_sysphoto");
        button2_1.setName("系统拍照发图");
        button2_1.setKey("rselfmenu_1_0");
        //发送位置
        CommonButton button2_2 = new CommonButton();
        button2_2.setType("location_select");
        button2_2.setName("发送位置");
        button2_2.setKey("rselfmenu_2_0");
        //扫码推事件
        CommonButton button2_3 = new CommonButton();
        button2_3.setType("scancode_push");
        button2_3.setName("扫码推事件");
        button2_3.setKey("rselfmenu_0_1");
        button2.setSub_button(new Button[]{button2_1, button2_2,button2_3});
        //扫码推事件
        CommonButton button2_4 = new CommonButton();
        button2_4.setType("scancode_waitmsg");
        button2_4.setName("扫码带提示");
        button2_4.setKey("rselfmenu_0_0");
        button2.setSub_button(new Button[]{button2_1, button2_2,button2_3,button2_4});

        menu.setButton( new Button[]{button1, button2});
        return menuService.createMenu(token.getAccess_token(), menu);
    }

    /**
     * 获取菜单
     * @return string
     */
    @RequestMapping("/getMenu")
    public JSONObject getMenu(){
        AccessToken token = baseService.getAccessToken();
        return menuService.getMenu(token.getAccess_token());
    }

    /**
     * 删除
     * @return string
     */
    @RequestMapping("/delMenu")
    public JSONObject delMenu(){
        AccessToken token = baseService.getAccessToken();
        return menuService.delMenu(token.getAccess_token());
    }
}
