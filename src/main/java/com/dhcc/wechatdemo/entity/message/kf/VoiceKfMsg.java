package com.dhcc.wechatdemo.entity.message.kf;

import com.dhcc.wechatdemo.entity.message.sendall.Common;

/**
 * @description: 客服语音消息
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class VoiceKfMsg extends BaseKfMsg{

    /**
     * 语音信息
     */
    private Common voice;

    public Common getVoice() {
        return voice;
    }

    public void setVoice(Common voice) {
        this.voice = voice;
    }
}
