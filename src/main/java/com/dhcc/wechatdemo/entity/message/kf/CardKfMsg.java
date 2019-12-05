package com.dhcc.wechatdemo.entity.message.kf;

import com.dhcc.wechatdemo.entity.message.sendall.CommonCard;

/**
 * @description: 客服卡券消息
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class CardKfMsg extends BaseKfMsg{

    /**
     * 卡券信息
     */
    private CommonCard wxcard;

    public CommonCard getWxcard() {
        return wxcard;
    }

    public void setWxcard(CommonCard wxcard) {
        this.wxcard = wxcard;
    }
}
