package com.dhcc.wechatdemo.entity.menu.base;

/**
 * @description: 复杂按钮（父按钮）
 * @author: Liu Denghui
 * @time: 2019/11/26 13:51
 */
public class ComplexButton extends Button {
    /**
     * 二级三菜单数组（1-5个）
     */
    private Button[] sub_button;  
  
    public Button[] getSub_button() {  
        return sub_button;  
    }  
  
    public void setSub_button(Button[] sub_button) {  
        this.sub_button = sub_button;  
    }  
}  