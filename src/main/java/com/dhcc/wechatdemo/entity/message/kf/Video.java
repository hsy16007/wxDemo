package com.dhcc.wechatdemo.entity.message.kf;

/**
 * @description: 视频消息
 * @author: Liu Denghui
 * @time: 2019/11/27 14:54
 */
public class Video {
    /**
     * 视频素材id
     */
    private String media_id;
    /**
     * 缩略图素材id
     */
    private String thumb_media_id;
    /**
     * 视频标题
     */
    private String title;
    /**
     * 视频介绍
     */
    private String description;


    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
