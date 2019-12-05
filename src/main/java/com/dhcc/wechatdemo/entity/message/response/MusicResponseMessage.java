package com.dhcc.wechatdemo.entity.message.response;


/**
 * @description: 音乐消息类（公众帐号 -> 普通用户）
 * @author: Liu Denghui
 * @time: 2019/11/26 13:42
 */
public class MusicResponseMessage extends BaseResponseMessage {

    private com.dhcc.wechatdemo.entity.message.response.Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
