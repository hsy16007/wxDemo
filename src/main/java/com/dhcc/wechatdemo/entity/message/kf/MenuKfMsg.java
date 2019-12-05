package com.dhcc.wechatdemo.entity.message.kf;

/**
 * @description: 客服选择菜单消息
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class MenuKfMsg extends BaseKfMsg{

    /**
     * 菜单选择信息
     */
    private MenuMsg msgmenu;

    public MenuMsg getMsgmenu() {
        return msgmenu;
    }

    public void setMsgmenu(MenuMsg msgmenu) {
        this.msgmenu = msgmenu;
    }
}
