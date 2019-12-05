package com.dhcc.wechatdemo.entity.message.request;

/**
 * @description: 语音识别消息类（普通用户 -> 公众帐号）
 * @author: Liu Denghui
 * @time: 2019/11/25 13:55
 */
public class VoiceRecognitionRequestMessage extends BaseRequestMessage {

    /**
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String MediaId;
    /**
     * 语音格式amr
     */
    private String Format;
    /**
     * 语音识别结果，UTF8编码
     */
    private String Recognition;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }
}
