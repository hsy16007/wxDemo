package com.dhcc.wechatdemo.entity.message.response;


/**
 * @description: 视频消息类（公众帐号 -> 普通用户）
 * @author: Liu Denghui
 * @time: 2019/11/26 13:42
 */
public class VideoResponseMessage extends BaseResponseMessage {

    private com.dhcc.wechatdemo.entity.message.response.Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
