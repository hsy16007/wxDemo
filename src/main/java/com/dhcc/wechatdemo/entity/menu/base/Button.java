package com.dhcc.wechatdemo.entity.menu.base;

/**
 * @description: 按钮基类
 * @author: Liu Denghui
 * @time: 2019/11/26 13:51
 */
public class Button {
    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    private String name;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
}  