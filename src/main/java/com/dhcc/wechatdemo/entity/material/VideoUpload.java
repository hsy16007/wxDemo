package com.dhcc.wechatdemo.entity.material;

/**
 * @description: 视频文件上传所需
 * @author: Liu Denghui
 * @time: 2019/11/27 9:58
 */
public class VideoUpload {

    /**
     * 标题
     */
    private String title;
    /**
     * 介绍
     */
    private String introduction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
