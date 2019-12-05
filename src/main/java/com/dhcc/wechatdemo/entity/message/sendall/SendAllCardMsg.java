package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 群发卡券消息
 * @author: Liu Denghui
 * @time: 2019/11/29 9:47
 */
public class SendAllCardMsg extends BaseSendAllMsg{
    /**
     * 设定卡券信息
     */
    private CommonCard wxcard;

    public CommonCard getWxcard() {
        return wxcard;
    }

    public void setWxcard(CommonCard wxcard) {
        this.wxcard = wxcard;
    }
}
