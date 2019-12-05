package com.dhcc.wechatdemo.entity.message.kf;

/**
 * @description: 音乐消息
 * @author: Liu Denghui
 * @time: 2019/11/27 14:54
 */
public class Music {

    /**
     * 音乐标题
     */
    private String title;
    /**
     * 音乐介绍
     */
    private String description;
    /**
     * 音乐链接
     */
    private String musicurl;
    /**
     * 高品质音乐链接，wifi环境优先使用该链接播放音乐
     */
    private String hqmusicurl;
    /**
     * 缩略图素材id
     */
    private String thumb_media_id;

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

    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    public String getHqmusicurl() {
        return hqmusicurl;
    }

    public void setHqmusicurl(String hqmusicurl) {
        this.hqmusicurl = hqmusicurl;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }
}
