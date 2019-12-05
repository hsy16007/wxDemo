package com.dhcc.wechatdemo.utils.message.response;

/**
 * @description: 消息封装工具类的基类，采用泛型，方便后期功能拓展
 * @author: Liu Denghui
 * @time: 2019/11/25 14:22
 */
public interface BaseMessageUtil <T> {

    /**
     * 将回复的信息对象转换成XML格式给微信
     * @param message 信息
     * @return
     */
    public abstract String messageToXml(T message);

    /**
     * 回复的信息封装
     * @param fromUserName 消息发送者
     * @param toUserName 消息接收者
     * @param message 回复消息类型
     * @return
     */
    public abstract String initMessage(String fromUserName,String toUserName, T message);
}
