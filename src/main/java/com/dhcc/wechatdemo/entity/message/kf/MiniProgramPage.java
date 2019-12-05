package com.dhcc.wechatdemo.entity.message.kf;

/**
 * @description: 小程序消息
 * @author: Liu Denghui
 * @time: 2019/11/27 14:54
 */
public class MiniProgramPage {

    /**
     * 标题
     */
    private String title;
    /**
     * 小程序appid
     */
    private String appid;
    /**
     * 小程序页面
     */
    private String pagepath;
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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }
}
