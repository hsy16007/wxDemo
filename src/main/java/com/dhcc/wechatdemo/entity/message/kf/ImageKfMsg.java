package com.dhcc.wechatdemo.entity.message.kf;

import com.dhcc.wechatdemo.entity.message.sendall.Common;

/**
 * @description: 客服图片消息
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class ImageKfMsg extends BaseKfMsg{

    /**
     * 图片信息
     */
    private Common image;

    public Common getImage() {
        return image;
    }

    public void setImage(Common image) {
        this.image = image;
    }
}
