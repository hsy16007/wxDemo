package com.dhcc.wechatdemo.entity.message.template;

/**
 * @description: 模板消息基类
 * @author: Liu Denghui
 * @time: 2019/12/2 11:33
 */
public class BaseTemplateMsg {
    /**
     * 接收者openid
     */
    private String touser;
    /**
     * 模板ID
     */
    private String template_id;
    /**
     * 模板跳转链接（海外帐号没有跳转能力）
     */
    private String url;
    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    private MiniProgramMsg miniprogram;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MiniProgramMsg getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(MiniProgramMsg miniprogram) {
        this.miniprogram = miniprogram;
    }
}
