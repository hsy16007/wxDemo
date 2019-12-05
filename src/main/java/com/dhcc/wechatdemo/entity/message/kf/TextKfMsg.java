package com.dhcc.wechatdemo.entity.message.kf;

import com.dhcc.wechatdemo.entity.message.sendall.CommonText;

/**
 * @description: 客服文本消息
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class TextKfMsg extends BaseKfMsg{

    /**
     * 文本信息
     */
    private CommonText text;

    public CommonText getText() {
        return text;
    }

    public void setText(CommonText text) {
        this.text = text;
    }
}
