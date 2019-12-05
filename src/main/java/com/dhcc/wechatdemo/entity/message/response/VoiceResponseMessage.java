package com.dhcc.wechatdemo.entity.message.response;


/**
 * @description: 语音消息类（公众帐号 -> 普通用户）
 * @author: Liu Denghui
 * @time: 2019/11/26 13:42
 */
public class VoiceResponseMessage extends BaseResponseMessage {

    private com.dhcc.wechatdemo.entity.message.response.Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
