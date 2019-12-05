package com.dhcc.wechatdemo.entity.message.request;

/**
 * @description: 文本消息类（普通用户 -> 公众帐号）
 * @author: Liu Denghui
 * @time: 2019/11/25 13:55
 */
public class TextRequestMessage extends BaseRequestMessage {

    /**
     * 文本消息内容
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
