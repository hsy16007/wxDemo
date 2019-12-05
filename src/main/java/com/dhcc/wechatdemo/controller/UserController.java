package com.dhcc.wechatdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.entity.AccessToken;
import com.dhcc.wechatdemo.entity.user.GerUserInfoInput;
import com.dhcc.wechatdemo.entity.user.Tag;
import com.dhcc.wechatdemo.service.BaseService;
import com.dhcc.wechatdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 用户管理接口
 * @author: Liu Denghui
 * @time: 2019/11/29 11:30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    BaseService baseService;
    @Autowired
    UserService userService;

    /**
     * 创建标签
     * @param tagName 创建的标签名称
     * @return JSONObject
     */
    @RequestMapping("/createTag")
    public JSONObject createTag(String tagName){
        AccessToken token = baseService.getAccessToken();
        Tag tag = new Tag();
        tag.setName(tagName);
        return userService.createTag(token.getAccess_token(), tag);
    }

    /**
     * 获取已创建标签
     * @return JSONObject
     */
    @RequestMapping("/getTag")
    public JSONObject getTag(){
        AccessToken token = baseService.getAccessToken();
        return userService.getTag(token.getAccess_token());
    }

    /**
     * 更新标签
     * @param accessToken accessToken
     * @param tagId 标签id
     * @param tagName 标签名称
     * @return JSONObject
     */
    @RequestMapping("/updateTag")
    public JSONObject updateTag(String accessToken, int tagId, String tagName){
        AccessToken token = baseService.getAccessToken();
        Tag tag = new Tag();
        tag.setId(tagId);
        tag.setName(tagName);
        return userService.updateTag(token.getAccess_token(), tag);
    }

    /**
     * 删除标签
     * @param accessToken accessToken
     * @param tagId 要删除的标签id
     * @return JSONObject
     */
    @RequestMapping("/deleteTag")
    public JSONObject deleteTag(String accessToken, int tagId){
        AccessToken token = baseService.getAccessToken();
        Tag tag = new Tag();
        tag.setId(tagId);
        return userService.deleteTag(token.getAccess_token(), tag);
    }

    /**
     * 获取标签下粉丝列表
     * @param tagId 标签信息（标签id）
     * @param nextOpenid 第一个拉取的open_id，不填默认从头拉去
     * @return JSONObject
     */
    @RequestMapping("/getUserByTag")
    public JSONObject getUserByTag(int tagId, String nextOpenid){
        AccessToken token = baseService.getAccessToken();
        Tag tag = new Tag();
        tag.setId(tagId);
        return userService.getUserByTag(token.getAccess_token(), tag, nextOpenid);
    }

    /**
     * 批量为用户打标签
     * @param openidList 用户openIdList
     * @param tagId 标签id
     * @return JSONObject
     */
    @RequestMapping("/batchTagging")
    public JSONObject batchTagging(String[] openidList, int tagId){
        AccessToken token = baseService.getAccessToken();
        return userService.batchTagging(token.getAccess_token(), openidList, tagId);
    }

    /**
     * 批量为用户取消标签
     * @param openidList 用户openIdList
     * @param tagId 标签id
     * @return JSONObject
     */
    @RequestMapping("/batchUnTagging")
    public JSONObject batchUnTagging( String[] openidList, int tagId){
        AccessToken token = baseService.getAccessToken();
        return userService.batchUnTagging(token.getAccess_token(), openidList, tagId);
    }

    /**
     * 获取用户身上的标签列表
     * @param openId 用户openId
     * @return JSONObject
     */
    @RequestMapping("/getIdList")
    public JSONObject getIdList(String openId){
        AccessToken token = baseService.getAccessToken();
        return userService.getIdList(token.getAccess_token(), openId);
    }

    /**
     * 获取用户基本信息
     * @param openId 用户openId
     * @return JSONObject
     */
    @RequestMapping("/getUserInfo")
    public JSONObject getUserInfo(String openId){
        AccessToken token = baseService.getAccessToken();
        GerUserInfoInput input = new GerUserInfoInput();
        input.setOpenid(openId);
        input.setLang("zh_CN");
        return userService.getUserInfo(token.getAccess_token(), input);
    }

    /**
     * 批量获取用户基本信息
     * @param openIds 用户openId数组
     * @return JSONObject
     */
    @RequestMapping("/batchGetUserInfo")
    public JSONObject batchGetUserInfo(String[] openIds){
        AccessToken token = baseService.getAccessToken();
        List<GerUserInfoInput> inputs = new ArrayList<>();
        for (int i=0; i<openIds.length; i++){
            GerUserInfoInput input = new GerUserInfoInput();
            input.setOpenid(openIds[i]);
            input.setLang("zh_CN");
            inputs.add(input);
        }
        return userService.batchGetUserInfo(token.getAccess_token(), inputs);
    }

    /**
     * 获取公众号的关注者列表
     * @param nextOpenid 从此openid开始，若为空，默认从开头拉取
     * @return JSONObject
     */
    @RequestMapping("/getUserList")
    public JSONObject getUserList(String nextOpenid){
        AccessToken token = baseService.getAccessToken();
        return userService.getUserList(token.getAccess_token(), nextOpenid);
    }

    /**
     * 获取公众号的黑名单列表
     * @param beginOpenId 从此openid开始，若为空，默认从开头拉取
     * @return JSONObject
     */
    @RequestMapping("/getBlacklist")
    public JSONObject getBlacklist(String beginOpenId){
        AccessToken token = baseService.getAccessToken();
        return userService.getBlacklist(token.getAccess_token(), beginOpenId);
    }

    /**
     * 拉黑用户
     * @param openIdList 要拉黑的用户list
     * @return JSONObject
     */
    @RequestMapping("/batchBlacklist")
    public JSONObject batchBlacklist( String[] openIdList){
        AccessToken token = baseService.getAccessToken();
        return userService.batchBlacklist(token.getAccess_token(), openIdList);
    }

    /**
     * 取消拉黑用户
     * @param openIdList 要拉黑的用户list
     * @return JSONObject
     */
    @RequestMapping("/batchUnBlacklist")
    public JSONObject batchUnBlacklist(String[] openIdList){
        AccessToken token = baseService.getAccessToken();
        return userService.batchUnBlacklist(token.getAccess_token(), openIdList);
    }

}
