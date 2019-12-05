package com.dhcc.wechatdemo.entity.message.kf;

/**
 * @description: 基础菜单选择消息
 * @author: Liu Denghui
 * @time: 2019/12/2 17:22
 */
public class BaseMenuMsg {

    /**
     * id
     */
    private String id;
    /**
     * 信息
     */
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
