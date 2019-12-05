package com.dhcc.wechatdemo.entity.user;

/**
 * @description: 标签信息
 * @author: Liu Denghui
 * @time: 2019/11/29 11:32
 */
public class Tag {
    /**
     * 标签id
     */
    private int id;
    /**
     * 标签名称
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
