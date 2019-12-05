package com.dhcc.wechatdemo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.constant.MessageConstants;
import com.dhcc.wechatdemo.entity.message.response.Article;
import com.dhcc.wechatdemo.entity.message.response.Image;
import com.dhcc.wechatdemo.entity.message.response.Video;
import com.dhcc.wechatdemo.entity.message.response.Voice;
import com.dhcc.wechatdemo.entity.message.response.*;
import com.dhcc.wechatdemo.entity.message.sendall.BasePreviewMsg;
import com.dhcc.wechatdemo.entity.message.sendall.BaseSendAllMsg;
import com.dhcc.wechatdemo.entity.message.template.BaseTemplateMsg;
import com.dhcc.wechatdemo.utils.HttpHelper;
import com.dhcc.wechatdemo.utils.message.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 消息配置：群发/原创校验等
 * @author: Liu Denghui
 * @time: 2019/11/29 9:30
 */
@Service
public class MessageService {

    private Logger logger= LoggerFactory.getLogger(MessageService.class);

    /**
     * 返回文本信息
     * @param fromUserName 发送者（此为用户）
     * @param toUserName 接收者（此为公众号）
     * @param backContent 返回信息
     * @return 返回xml类型字符串
     */
    public String backTextMsg(String fromUserName, String toUserName, String backContent){
        logger.info("-----返回文本消息：" + backContent + "-----");
        MessageTextUtil messageTextUtil = new MessageTextUtil();
        TextResponseMessage message = new TextResponseMessage();
        message.setContent(backContent);
        return messageTextUtil.initMessage(fromUserName, toUserName, message);
    }

    /**
     * 返回图片信息
     * @param fromUserName 发送者（此为用户）
     * @param toUserName 接收者（此为公众号）
     * @param mediaId 图片素材id
     * @return 返回xml类型字符串
     */
    public String backImageMsg(String fromUserName, String toUserName, String mediaId){
        logger.info("-----返回图片-----");
        MessageImageUtil messageImageUtil = new MessageImageUtil();
        ImageResponseMessage message = new ImageResponseMessage();
        Image image = new Image();
        image.setMediaId(mediaId);
        message.setImage(image);
        return messageImageUtil.initMessage(fromUserName, toUserName, message);
    }

    /**
     * 返回语音信息
     * @param fromUserName 发送者（此为用户）
     * @param toUserName 接收者（此为公众号）
     * @param mediaId 语音素材id
     * @return 返回xml类型字符串
     */
    public String backVoiceMsg(String fromUserName, String toUserName, String mediaId){
        logger.info("-----返回语音-----");
        MessageVoiceUtil messageVoiceUtil = new MessageVoiceUtil();
        VoiceResponseMessage message = new VoiceResponseMessage();
        Voice voice = new Voice();
        voice.setMediaId(mediaId);
        message.setVoice(voice);
        return messageVoiceUtil.initMessage(fromUserName, toUserName, message);
    }

    /**
     * 返回视频信息
     * @param fromUserName 发送者（此为用户）
     * @param toUserName 接收者（此为公众号）
     * @param mediaId 视频素材id
     * @param videoTitle 视频素材标题信息
     * @param videoDescription 视频素材介绍信息
     * @return 返回xml类型字符串
     */
    public String backVideoMsg(String fromUserName, String toUserName, String mediaId, String videoTitle, String videoDescription){
        logger.info("-----返回视频-----");
        MessageVideoUtil messageVideoUtil = new MessageVideoUtil();
        VideoResponseMessage message = new VideoResponseMessage();
        Video video = new Video();
        video.setMediaId(mediaId);
        video.setTitle(videoTitle);
        video.setDescription(videoDescription);
        message.setVideo(video);
        return messageVideoUtil.initMessage(fromUserName, toUserName, message);
    }

    /**
     * 返回图文信息
     * @param fromUserName 发送者（此为用户）
     * @param toUserName 接收者（此为公众号）
     * @param article1Title 图文素材标题
     * @param article1Description 图文素材介绍
     * @param picUrl 图文标题图片url
     * @param url 图文信息对应url
     * @return 返回xml类型字符串
     */
    public String backArticleMsg(String fromUserName, String toUserName, String article1Title, String article1Description, String picUrl, String url){
        MessageNewsUtil messageNewsUtil = new MessageNewsUtil();
        Article article1 = new Article();
        article1.setTitle(article1Title);
        article1.setDescription(article1Description);
        article1.setPicUrl(picUrl);
        article1.setUrl(url);

        NewsResponseMessage message = new NewsResponseMessage();
        List<Article> item = new ArrayList<>();
        item.add(article1);
        message.setArticles(item);
        //开发者只能回复1条图文消息
        message.setArticleCount(1);

        // TODO 返回的string，格式出错，需手动转换
        return messageNewsUtil.initMessage(fromUserName, toUserName, message)
                .replace("com.dhcc.wechatdemo.entity.message.response.Article", "item");
    }

    /**
     * 群发消息，可根据标签群发
     * @param accessToken accessToken
     * @param message 群发消息：可为多种类型
     * @return JSONObject
     */
    public JSONObject sendMassByTag(String accessToken, BaseSendAllMsg message){
        System.out.println(JSON.toJSONString(message));
        // 设置url
        String url = MessageConstants.SEND_MASS_BY_TAG.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始群发消息了，群发的消息类型是：" + message.getMsgtype());
            if (message.getFilter().isIs_to_all()){
                logger.info("群发所有用户");
            }else {
                logger.info("群发指定标签用户，标签id：" + message.getFilter().getTag_id());
            }
            jsonObject = HttpHelper.doPost(url, message);
            logger.info("群发消息成功");
        } catch (Exception e) {
            logger.error("群发消息失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 删除群发
     * @param accessToken accessToken
     * @param msgId 发送出去的消息ID
     * @param articleIdx 要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
     * @return JSONObject
     */
    public JSONObject delMass(String accessToken, String msgId, String articleIdx){
        // 设置url
        String url = MessageConstants.DELETE_MASS.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("msg_id", msgId);
        map.put("article_idx", articleIdx);
        try {
            logger.info("开始删除群发消息了，删除的群发id是：" + msgId);
            if ("".equals(articleIdx) || "0".equals(articleIdx)){
                logger.info("删除此条群发消息的全部文章");
            }else {
                logger.info("删除此条群发消息的第 " + articleIdx + " 篇文章" );
            }
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("删除群发消息成功");
        } catch (Exception e) {
            logger.error("删除群发消息失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 群发预览
     * @param accessToken accessToken
     * @param message 预览消息信息
     * @return JSONObject
     */
    public JSONObject previewMass (String accessToken, BasePreviewMsg message){
        // 设置url
        String url = MessageConstants.PREVIEW_MASS.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始预览群发消息了，消息类型是：" + message.getMsgtype());
            logger.info("预览的用户是：" + message.getTouser());
            jsonObject = HttpHelper.doPost(url, message);
            logger.info("预览群发消息成功");
        } catch (Exception e) {
            logger.error("预览群发消息失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 查询群发的发送状态
     * @param accessToken accessToken
     * @param msgId 群发消息id
     * @return JSONObject
     */
    public JSONObject getMassState (String accessToken, String msgId){
        // 设置url
        String url = MessageConstants.GET_MASS_STATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("msg_id", msgId);
        try {
            logger.info("开始查询群发的发送状态了，消息id是：" + msgId);
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("查询群发的发送状态成功");
        } catch (Exception e) {
            logger.error("查询群发的发送状态失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取群发速度
     * @param accessToken accessToken
     * @return JSONObject
     */
    public JSONObject getMassSpeed (String accessToken){
        // 设置url
        String url = MessageConstants.GET_MASS_SPEED.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取群发速度了");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取群发速度成功");
            logger.info("群发速度的级别：" + jsonObject.getString("speed"));
            logger.info("群发速度：" + jsonObject.getString("realspeed") + " 万/分钟");
        } catch (Exception e) {
            logger.error("获取群发速度失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 设置群发速度
     * @param accessToken accessToken
     * @param speed 群发速度
     * @return JSONObject
     */
    public JSONObject setMassSpeed (String accessToken, int speed){
        // 设置url
        String url = MessageConstants.SET_MASS_SPEED.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, Integer> map = new HashMap<>();
        map.put("speed", speed);
        try {
            logger.info("开始设置群发速度了，设置的群发速度级别为：" + speed);
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("设置群发速度成功");
        } catch (Exception e) {
            logger.error("设置群发速度失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 设置公众号所属行业
     * 需要选择公众账号服务所处的2个行业，每月可更改1次所选行业
     * @param accessToken accessToken
     * @param industryId1 所属行业1
     * @param industryId2 所属行业2
     * @return JSONObject
     */
    public JSONObject setIndustry (String accessToken, int industryId1, int industryId2){
        // 设置url
        String url = MessageConstants.API_SET_INDUSTRY.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, Integer> map = new HashMap<>();
        map.put("industry_id1", industryId1);
        map.put("industry_id2", industryId2);
        try {
            logger.info("开始设置公众号所属行业了");
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("设置公众号所属行业成功");
        } catch (Exception e) {
            logger.error("设置公众号所属行业失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取公众号所属行业
     * @param accessToken accessToken
     * @return JSONObject
     */
    public JSONObject getIndustry (String accessToken){
        // 设置url
        String url = MessageConstants.GET_INDUSTRY.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取公众号所属行业了");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取公众号所属行业成功");
        } catch (Exception e) {
            logger.error("获取公众号所属行业失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获得模板ID
     * @param accessToken accessToken
     * @param templateIdShort 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * @return JSONObject
     */
    public JSONObject addTemplate (String accessToken, String templateIdShort){
        // 设置url
        String url = MessageConstants.API_ADD_TEMPLATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("template_id_short", templateIdShort);
        try {
            logger.info("开始获得模板ID了");
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("获得模板ID成功");
        } catch (Exception e) {
            logger.error("获得模板ID失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取模板列表
     * @param accessToken accessToken
     * @return JSONObject
     */
    public JSONObject getAllPrivateTemplate (String accessToken){
        // 设置url
        String url = MessageConstants.GET_ALL_PRIVATE_TEMPLATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取模板列表了");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取模板列表成功");
        } catch (Exception e) {
            logger.error("获取模板列表失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 删除模板
     * @param accessToken accessToken
     * @param templateId 模板id
     * @return JSONObject
     */
    public JSONObject delPrivateTemplate (String accessToken, String templateId){
        // 设置url
        String url = MessageConstants.DEL_PRIVATE_TEMPLATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("template_id", templateId);
        try {
            logger.info("开始删除模板了");
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("删除模板成功");
        } catch (Exception e) {
            logger.error("删除模板失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 发送模板消息
     * @param accessToken accessToken
     * @param templateMsg 模板消息内容
     * @return JSONObject
     */
    public JSONObject sendTemplate (String accessToken, BaseTemplateMsg templateMsg){
        // 设置url
        String url = MessageConstants.SEND_TEMPLATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始发送模板消息了");
            jsonObject = HttpHelper.doPost(url, templateMsg);
            logger.info("发送模板消息成功");
        } catch (Exception e) {
            logger.error("发送模板消息失败");
            e.printStackTrace();
        }
        return jsonObject;
    }
}
