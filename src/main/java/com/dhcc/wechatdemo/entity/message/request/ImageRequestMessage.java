package com.dhcc.wechatdemo.entity.message.request;

/**
 * @description: 图片消息类（普通用户 -> 公众帐号）
 * @author: Liu Denghui
 * @time: 2019/11/25 13:55
 */
public class ImageRequestMessage extends BaseRequestMessage {

    /**
     * 图片链接（由系统生成）
     */
    private String PicUrl;
    /**
     * 图片消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
