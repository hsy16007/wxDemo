package com.dhcc.wechatdemo.entity.message.request;

/**
 * @description: 视频/小视频消息类（普通用户 -> 公众帐号）
 * @author: Liu Denghui
 * @time: 2019/11/25 13:55
 */
public class VideoRequestMessage extends BaseRequestMessage {

    /**
     * 视频消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String MediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
