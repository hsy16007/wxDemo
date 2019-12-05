package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 群发视频消息
 * @author: Liu Denghui
 * @time: 2019/11/29 9:47
 */
public class SendAllVideoMsg extends BaseSendAllMsg{
    /**
     * 设定视频信息
     */
    private Common mpvideo;

    public Common getMpvideo() {
        return mpvideo;
    }

    public void setMpvideo(Common mpvideo) {
        this.mpvideo = mpvideo;
    }
}
