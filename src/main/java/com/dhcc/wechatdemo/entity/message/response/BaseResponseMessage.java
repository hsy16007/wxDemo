package com.dhcc.wechatdemo.entity.message.response;

/**
 * @description: 消息基类（公众帐号 -> 普通用户）
 * @author: Liu Denghui
 * @time: 2019/11/25 13:53
 */
public class BaseResponseMessage {

    /**
     * 消息接收者，开发者微信号
     */
    protected String ToUserName;
    /**
     * 消息发送者，发送方帐号（一个OpenID）
     */
    protected String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    protected long CreateTime;
    /**
     * 消息类型（text/image/voice/video/shortvideo/location/link）
     */
    protected String MsgType;
    /**
     * 消息id，64位整型
      */
    private long MsgId;

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
