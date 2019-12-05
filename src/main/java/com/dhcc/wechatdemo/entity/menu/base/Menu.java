package com.dhcc.wechatdemo.entity.menu.base;

/**
 * @description: 菜单
 * @author: Liu Denghui
 * @time: 2019/11/26 13:51
 */
public class Menu {
    /**
     * 一级菜单数组（1-3个）
     */
    private Button[] button;
  
    public Button[] getButton() {  
        return button;  
    }  
  
    public void setButton(Button[] button) {  
        this.button = button;  
    }  
}  