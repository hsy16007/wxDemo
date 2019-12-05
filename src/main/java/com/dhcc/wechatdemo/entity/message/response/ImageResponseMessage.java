package com.dhcc.wechatdemo.entity.message.response;


/**
 * @description: 图片消息类（公众帐号 -> 普通用户）
 * @author: Liu Denghui
 * @time: 2019/11/26 13:42
 */
public class ImageResponseMessage extends BaseResponseMessage {

    private com.dhcc.wechatdemo.entity.message.response.Image Image;
    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        this.Image = image;
    }
}
