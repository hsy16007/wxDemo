package com.dhcc.wechatdemo.entity.menu.base;

/**
 * @description: view类型的按钮
 * @author: Liu Denghui
 * @time: 2019/11/26 13:51
 */
public class ViewButton extends Button {
    /**
     * view表示网页类型
     */
    private String type;
    /**
     * 网页 链接，用户点击菜单可打开链接，不超过1024字节。
     */
    private String url;  
  
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
}  