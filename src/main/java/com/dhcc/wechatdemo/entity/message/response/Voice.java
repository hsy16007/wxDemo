package com.dhcc.wechatdemo.entity.message.response;

/**
 * @description: 语音消息
 * @author: Liu Denghui
 * @time: 2019/11/27 14:54
 */
public class Voice{
    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}