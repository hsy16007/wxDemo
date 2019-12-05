package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 群发图文消息
 * @author: Liu Denghui
 * @time: 2019/11/29 9:47
 */
public class SendAllNewsMsg extends BaseSendAllMsg{
    /**
     * 用于设定即将发送的图文消息，携带素材id
     */
    private Common mpnews;
    /**
     * 图文消息被判定为转载时，是否继续群发。
     * 1为继续群发（转载），0为停止群发。 该参数默认为0。
     */
    private int send_ignore_reprint;

    public Common getMpnews() {
        return mpnews;
    }

    public void setMpnews(Common mpnews) {
        this.mpnews = mpnews;
    }

    public int getSend_ignore_reprint() {
        return send_ignore_reprint;
    }

    public void setSend_ignore_reprint(int send_ignore_reprint) {
        this.send_ignore_reprint = send_ignore_reprint;
    }
}
