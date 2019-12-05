package com.dhcc.wechatdemo.entity.menu.conditional;

import com.dhcc.wechatdemo.entity.menu.base.Button;

/**
 * @description: 个性化菜单（父类）
 * @author: Liu Denghui
 * @time: 2019/11/26 13:51
 */
public class ConditionalMenu {
    /**
     * 一级菜单数组（1-3个）
     */
    private Button[] button;

    /**
     * 菜单匹配规则
     */
    private Matchrule matchrule;
  
    public Button[] getButton() {  
        return button;  
    }  
  
    public void setButton(Button[] button) {  
        this.button = button;  
    }

    public Matchrule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(Matchrule matchrule) {
        this.matchrule = matchrule;
    }
}