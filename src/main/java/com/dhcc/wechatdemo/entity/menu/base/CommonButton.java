package com.dhcc.wechatdemo.entity.menu.base;

/**
 * @description: 普通按钮（子按钮）
 * @author: Liu Denghui
 * @time: 2019/11/26 13:51
 */
public class CommonButton extends Button {
    /**
     * 类型：
     * click：点击；对应key：自定义
     * 扫码
     * scancode_waitmsg：扫码带提示；对应key：rselfmenu_0_0
     * scancode_push：扫码推事件；对应key：rselfmenu_0_1
     * 发图
     * pic_sysphoto：系统拍照发图；对应key：rselfmenu_1_0
     * pic_photo_or_album：拍照或者相册发图；对应key：rselfmenu_1_1
     * pic_weixin：微信相册发图；对应key：rselfmenu_1_2
     * 其他
     * location_select：发送位置；对应key：rselfmenu_2_0
     */
    private String type;
    /**
     * click等点击类型必须	菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;  
  
    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
  
    public String getKey() {  
        return key;  
    }  
  
    public void setKey(String key) {  
        this.key = key;  
    }  
}  