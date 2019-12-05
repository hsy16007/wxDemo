package com.dhcc.wechatdemo.entity.message.response;

import com.dhcc.wechatdemo.entity.message.request.BaseRequestMessage;

/**
 * @description: 文本消息类（公众帐号 -> 普通用户）
 * @author: Liu Denghui
 * @time: 2019/11/25 13:55
 */
public class TextResponseMessage extends BaseRequestMessage {

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
