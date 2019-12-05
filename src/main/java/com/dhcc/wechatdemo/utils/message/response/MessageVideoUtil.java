package com.dhcc.wechatdemo.utils.message.response;

import com.dhcc.wechatdemo.entity.message.response.VideoResponseMessage;
import com.thoughtworks.xstream.XStream;

/**
 * @description: 视频消息处理工具类
 * @author: Liu Denghui
 * @time: 2019/11/25 14:34
 */
public class MessageVideoUtil implements BaseMessageUtil<VideoResponseMessage> {

    /**
     * 将发送消息封装成对应的xml格式
     * @param message
     * @return
     */
    @Override
    public String messageToXml(VideoResponseMessage message){
        XStream xStream = new XStream();
        xStream.alias("xml", message.getClass());
        return xStream.toXML(message);
    }


    /**
     * 封装信息
     * @param fromUserName 消息发送者
     * @param toUserName    消息接收者
     * @param message   消息内容
     * @return
     */
    @Override
    public String initMessage(String fromUserName, String toUserName, VideoResponseMessage message){
        // 设置消息接收者（为原先消息发送者）
        message.setToUserName(fromUserName);
        // 设置消息发送者（为原先消息接收者）
        message.setFromUserName(toUserName);
        // 设置消息创建时间
        // System.currentTimeMillis()   获取当前毫秒数
        message.setCreateTime(System.currentTimeMillis());
        // 设置消息类型：video
        message.setMsgType("video");
        return this.messageToXml(message);
    }
}
