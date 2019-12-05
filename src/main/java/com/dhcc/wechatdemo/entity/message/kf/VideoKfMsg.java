package com.dhcc.wechatdemo.entity.message.kf;

/**
 * @description: 客服视频消息
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class VideoKfMsg extends BaseKfMsg{

    /**
     * 视频信息
     */
    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
