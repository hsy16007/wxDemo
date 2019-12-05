package com.dhcc.wechatdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.entity.AccessToken;
import com.dhcc.wechatdemo.entity.KfAccount;
import com.dhcc.wechatdemo.entity.message.kf.BaseKfMsg;
import com.dhcc.wechatdemo.service.BaseService;
import com.dhcc.wechatdemo.service.KfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @description: 客服管理控制层
 * @author: Liu Denghui
 * @time: 2019/12/2 15:45
 */
@RestController
@RequestMapping("/kf")
public class KfController {

    @Autowired
    BaseService baseService;
    @Autowired
    KfService kfService;

    /**
     * 添加客服账号
     * @return JSONObject
     */
    @RequestMapping("/addKfAccount")
    public JSONObject addKfAccount(){
        AccessToken token = baseService.getAccessToken();
        KfAccount kfAccount = new KfAccount();
        kfAccount.setKf_account("");
        kfAccount.setNickname("测试人员1");
        kfAccount.setPassword("123456");
        return kfService.addKfAccount(token.getAccess_token(), kfAccount);
    }

    /**
     * 修改客服帐号
     * @return JSONObject
     */
    @RequestMapping("/updateKfAccount")
    public JSONObject updateKfAccount(){
        AccessToken token = baseService.getAccessToken();
        KfAccount kfAccount = new KfAccount();
        kfAccount.setKf_account("");
        kfAccount.setNickname("测试人员1");
        kfAccount.setPassword("123456");
        return kfService.updateKfAccount(token.getAccess_token(), kfAccount);
    }

    /**
     * 删除客服账号
     * @return JSONObject
     */
    @RequestMapping("/delKfAccount")
    public JSONObject delKfAccount(){
        AccessToken token = baseService.getAccessToken();
        KfAccount kfAccount = new KfAccount();
        kfAccount.setKf_account("");
        kfAccount.setNickname("测试人员1");
        kfAccount.setPassword("123456");
        return kfService.delKfAccount(token.getAccess_token(), kfAccount);
    }

    /**
     * 设置客服帐号的头像
     * @return JSONObject
     */
    @RequestMapping("/updateKfHeadImg")
    public JSONObject updateKfHeadImg() {
        AccessToken token = baseService.getAccessToken();
        KfAccount kfAccount = new KfAccount();
        try {
            return kfService.updateKfHeadImg(token.getAccess_token(), kfAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有客服账号
     * @return JSONObject
     */
    @RequestMapping("/getKfList")
    public JSONObject getKfList(){
        AccessToken token = baseService.getAccessToken();
        return kfService.getKfList(token.getAccess_token());
    }

    /**
     * 发送客服消息
     * @return JSONObject
     */
    @RequestMapping("/sendKfMsg")
    public JSONObject sendKfMsg(){
        AccessToken token = baseService.getAccessToken();
        BaseKfMsg message = new BaseKfMsg();
        return kfService.sendKfMsg(token.getAccess_token(), message);
    }

    /**
     * 设置客服输入状态
     * @param toUser 普通用户（openid）
     * @param command 输入状态："Typing"：对用户下发“正在输入"状态 "CancelTyping"：取消对用户的”正在输入"状态
     * @return JSONObject
     */
    @RequestMapping("/typingKfMsg")
    public JSONObject typingKfMsg(String toUser, String command){
        AccessToken token = baseService.getAccessToken();
        return kfService.typingKfMsg(token.getAccess_token(), toUser, command);
    }
}
