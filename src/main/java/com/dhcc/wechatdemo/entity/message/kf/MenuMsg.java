package com.dhcc.wechatdemo.entity.message.kf;

import java.util.List;

/**
 * @description: 菜单选择消息
 * @author: Liu Denghui
 * @time: 2019/12/2 17:22
 */
public class MenuMsg {

    /**
     * 头部信息
     */
    private String head_content;
    /**
     * 选择菜单list
     */
    private List<BaseMenuMsg> list;
    /**
     * 底部信息
     */
    private String tail_content;

    public String getHead_content() {
        return head_content;
    }

    public void setHead_content(String head_content) {
        this.head_content = head_content;
    }

    public List<BaseMenuMsg> getList() {
        return list;
    }

    public void setList(List<BaseMenuMsg> list) {
        this.list = list;
    }

    public String getTail_content() {
        return tail_content;
    }

    public void setTail_content(String tail_content) {
        this.tail_content = tail_content;
    }
}
