package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 预览群发消息的基类
 * @author: Liu Denghui
 * @time: 2019/12/2 14:45
 */
public class BasePreviewMsg {
    /**
     * 接收消息用户对应该公众号的openid，该字段也可以改为towxname，以实现对微信号的预览
     */
    private String touser;
    /**
     * 群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     */
    private String msgtype;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
