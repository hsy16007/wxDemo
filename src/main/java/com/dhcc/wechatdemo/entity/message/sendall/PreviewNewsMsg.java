package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 预览图文消息
 * @author: Liu Denghui
 * @time: 2019/12/2 14:47
 */
public class PreviewNewsMsg extends BasePreviewMsg{
    /**
     * 图文消息信息，包含素材id
     */
    private Common mpnews;

    public Common getMpnews() {
        return mpnews;
    }

    public void setMpnews(Common mpnews) {
        this.mpnews = mpnews;
    }
}
