package com.dhcc.wechatdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.entity.AccessToken;
import com.dhcc.wechatdemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 基础信息获取
 * @author: Liu Denghui
 * @time: 2019/11/27 13:35
 */
@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    BaseService baseService;

    /**
     * 获取AccessToken，先从redis中查询，若存在，即获取；
     * 若不存在，向微信发送请求获取
     * @return string
     */
    @RequestMapping("/getAccessToken")
    public String getAccessToken(){
        AccessToken token = baseService.getAccessToken();
        return JSON.toJSONString(token);
    }

    /**
     * 获取微信callback IP地址
     * @return json
     */
    @RequestMapping("/getCallbackIp")
    public JSONObject getCallbackIp(){
        AccessToken token = baseService.getAccessToken();
        return baseService.getCallbackIp(token.getAccess_token());
    }

    /**
     * 获取微信API接口 IP地址
     * @return json
     */
    @RequestMapping("/getApiDomainIp")
    public JSONObject getApiDomainIp(){
        AccessToken token = baseService.getAccessToken();
        return baseService.getApiDomainIp(token.getAccess_token());
    }
}
