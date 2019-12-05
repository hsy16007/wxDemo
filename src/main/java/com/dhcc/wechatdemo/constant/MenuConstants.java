package com.dhcc.wechatdemo.constant;

/**
 * @description: 菜单管理常量
 * @author: Liu Denghui
 * @time: 2019/11/27 15:11
 */
public class MenuConstants {

    /**
     * 创建菜单
     * POST
     */
    public static String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     * 公众号当前使用的自定义菜单的配置，
     * 如果公众号是通过API调用设置的菜单，则返回菜单的开发配置，
     * 而如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回运营者设置的菜单配置。
     * GET
     */
    public static String GET_CURRENT_SELF_MENU_INFO = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";
    /**
     * 查询菜单（包含个性化菜单）
     * GET
     */
    public static String GET_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    /**
     * 删除菜单
     * GET
     */
    public static String DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";


    /**
     * 个性化菜单：让公众号的不同用户群体看到不一样的自定义菜单。
     */
    /**
     * 创建个性化菜单
     * POST
     */
    public static String CREATE_CONDITIONAL_MENU = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
    /**
     * 删除个性化菜单
     * POST
     */
    public static String DEL_CONDITIONAL_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
    /**
     * 测试个性化菜单匹配结果
     * POST
     */
    public static String TRY_MATCH_CONDITIONAL_MENU = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";

}
