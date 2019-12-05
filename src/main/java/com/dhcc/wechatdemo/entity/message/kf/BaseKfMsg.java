package com.dhcc.wechatdemo.entity.message.kf;

import com.dhcc.wechatdemo.entity.KfAccount;

/**
 * @description: 客服消息基类
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class BaseKfMsg {

    /**
     * 普通用户openid
     */
    private String touser;
    /**
     * 消息类型
     * 文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，
     * 图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard，小程序为miniprogrampage
     */
    private String msgtype;

    /**
     * 如果需要以某个客服帐号来发消息（在微信6.0.2及以上版本中显示自定义头像）
     * 则需在JSON数据包的后半部分加入customservice参数
     */
    private KfAccount customservice;

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

    public KfAccount getCustomservice() {
        return customservice;
    }

    public void setCustomservice(KfAccount customservice) {
        this.customservice = customservice;
    }
}
