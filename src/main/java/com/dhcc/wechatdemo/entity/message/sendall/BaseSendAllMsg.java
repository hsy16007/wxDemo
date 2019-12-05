package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 群发消息基础类
 * @author: Liu Denghui
 * @time: 2019/11/29 9:41
 */
public class BaseSendAllMsg {
    /**
     * 用于设定图文消息的接收者
     */
    private Filter filter;
    /**
     * 群发的消息类型，
     * 图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     */
    private String msgtype;

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
