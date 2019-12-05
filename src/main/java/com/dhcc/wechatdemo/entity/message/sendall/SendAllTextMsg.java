package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 群发文本消息
 * @author: Liu Denghui
 * @time: 2019/11/29 9:47
 */
public class SendAllTextMsg extends BaseSendAllMsg{
    /**
     * 设定文本信息
     */
    private CommonText text;

    public CommonText getText() {
        return text;
    }

    public void setText(CommonText text) {
        this.text = text;
    }
}
