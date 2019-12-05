package com.dhcc.wechatdemo.entity.message.request;

/**
 * @description: 语音为自动识别消息类（普通用户 -> 公众帐号）
 * @author: Liu Denghui
 * @time: 2019/11/25 13:55
 */
public class VoiceRequestMessage extends BaseRequestMessage {

    /**
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String MediaId;
    /**
     * 语音格式，如amr，speex等
     */
    private String Format;

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
}
