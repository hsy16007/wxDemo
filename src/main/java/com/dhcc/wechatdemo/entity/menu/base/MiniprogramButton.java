package com.dhcc.wechatdemo.entity.menu.base;

/**
 * @description: 小程序类型的按钮
 * @author: Liu Denghui
 * @time: 2019/11/26 13:51
 */
public class MiniprogramButton extends Button {
    /**
     * miniprogram表示小程序类型
     */
    private String type;
    /**
     * type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     */
    private String url;
    /**
     * 小程序的appid（仅认证公众号可配置）
     */
    private String appid;
    /**
     * 小程序的页面路径
     */
    private String pagepath;

    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
  
    public String getUrl() {  
        return url;  
    }  
  
    public void setUrl(String url) {  
        this.url = url;  
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
}