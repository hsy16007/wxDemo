package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 群发图片消息
 * @author: Liu Denghui
 * @time: 2019/11/29 9:47
 */
public class SendAllImageMsg extends BaseSendAllMsg{
    /**
     * 设定图片信息
     */
    private Common image;

    public Common getImage() {
        return image;
    }

    public void setImage(Common image) {
        this.image = image;
    }
}
