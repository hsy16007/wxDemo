package com.dhcc.wechatdemo.entity.message.kf;

import com.dhcc.wechatdemo.entity.message.sendall.Common;

/**
 * @description: 客服图文消息（跳转图文页面）
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class NewsKfMsg extends BaseKfMsg{

    /**
     * 图文信息
     */
    private Common mpnews;

    public Common getMpnews() {
        return mpnews;
    }

    public void setMpnews(Common mpnews) {
        this.mpnews = mpnews;
    }
}
