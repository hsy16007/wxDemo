package com.dhcc.wechatdemo.entity.message.kf;

/**
 * @description: 客服音乐消息
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class MusicKfMsg extends BaseKfMsg{

    /**
     * 音乐信息
     */
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
