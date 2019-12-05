package com.dhcc.wechatdemo.constant;

/**
 * @description: 消息管理常量
 * @author: Liu Denghui
 * @time: 2019/11/27 15:11
 */
public class MessageConstants {

    /**
     * 根据标签进行群发【订阅号与服务号认证后均可用】
     * POST
     */
    public static String SEND_MASS_BY_TAG = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
    /**
     * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
     * POST
     */
    public static String SEND_MASS_BY_OPEN_ID = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
    /**
     * 删除群发【订阅号与服务号认证后均可用】
     * POST
     */
    public static String DELETE_MASS = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
    /**
     * 预览接口【订阅号与服务号认证后均可用】
     * POST
     */
    public static String PREVIEW_MASS = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
    /**
     * 查询群发消息发送状态【订阅号与服务号认证后均可用】
     * POST
     */
    public static String GET_MASS_STATE = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";
    /**
     * 获取群发速度
     * GET
     */
    public static String GET_MASS_SPEED = "https://api.weixin.qq.com/cgi-bin/message/mass/speed/get?access_token=ACCESS_TOKEN";
    /**
     * 设置群发速度
     * POST
     */
    public static String SET_MASS_SPEED = "https://api.weixin.qq.com/cgi-bin/message/mass/speed/set?access_token=ACCESS_TOKEN";


    /**
     * 模板消息接口
     */
    /**
     * 设置所属行业
     * POST
     */
    public static String API_SET_INDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
    /**
     * 获取设置的行业信息
     * GET
     */
    public static String GET_INDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
    /**
     * 获得模板ID
     * POST
     */
    public static String API_ADD_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
    /**
     * 获取模板列表
     * GET
     */
    public static String GET_ALL_PRIVATE_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
    /**
     * 删除模板
     * POST
     */
    public static String DEL_PRIVATE_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";
    /**
     * 发送模板消息
     * POST
     */
    public static String SEND_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
}
