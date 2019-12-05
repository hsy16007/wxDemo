package com.dhcc.wechatdemo.entity.message.response;

/**
 * @description: 图片消息
 * @author: Liu Denghui
 * @time: 2019/11/27 14:54
 */
public class Image{
    /**
     * 通过素材管理中的接口上传图片ImageResponseMessage文件，得到的id。
     */
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
