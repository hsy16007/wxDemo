package com.dhcc.wechatdemo.entity.message.template;

/**
 * @description: 模板内容单个数据
 * @author: Liu Denghui
 * @time: 2019/12/2 11:21
 */
public class BaseData {
    /**
     * 模板内容
     */
    private String value;
    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
