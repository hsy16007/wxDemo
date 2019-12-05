package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 群发音频/语音消息
 * @author: Liu Denghui
 * @time: 2019/11/29 9:47
 */
public class SendAllVoiceMsg extends BaseSendAllMsg{
    /**
     * 设定音频/语音信息
     */
    private Common voice;

    public Common getVoice() {
        return voice;
    }

    public void setVoice(Common voice) {
        this.voice = voice;
    }
}
