package com.dhcc.wechatdemo.entity.message.template;

/**
 * @description: 模板消息1
 * url和miniprogram都是非必填字段，若都不传则模板无跳转；若都传，会优先跳转至小程序。
 * @author: Liu Denghui
 * @time: 2019/12/2 11:14
 */
public class TemplateMsg1 extends BaseTemplateMsg{

    /**
     * 模板数据
     */
    private TemplateMsg1Data data;

    public TemplateMsg1Data getData() {
        return data;
    }

    public void setData(TemplateMsg1Data data) {
        this.data = data;
    }
}
