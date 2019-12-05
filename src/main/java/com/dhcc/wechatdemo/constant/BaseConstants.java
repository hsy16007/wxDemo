package com.dhcc.wechatdemo.constant;

/**
 * @description: 基础常量
 * @author: Liu Denghui
 * @time: 2019/11/25 11:33
 */
public class BaseConstants {

    /**
     * 这里写公众号的appid
     */
    public static final String APP_ID="wxd22aef1985469061";
    /**
     * 这里写公众号的appsecret
     */
    public static final String APP_SECRET="e38ed5e1a7cae5a968283babe7428594";
    /**
     * 这里写公众号的appid
     */
    public static final String TEST_APP_ID="wxd08531f108282379";
    /**
     * 这里写公众号的appsecret
     */
    public static final String TEST_APP_SECRET="6fa0c4a0a0530c0f8a76428995ab0aba";
    /**
     * 这里写你自己定义的token
     */
    public static final String TOKEN="liudenghui";

    /**
     * EncodingAESKey消息加解密密钥
     */
    public static final String ENCODING_AES_KEY="vCZrqWT9E1jtNpQEqyvW5Tbrd167uuMkMJJypN6AMCr";

    /**
     * AccessToken
     */
    public static final String ACCESS_TOKEN = "";

    /**
     * 获取AccessToken的url地址
     * GET请求
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?"
            + "grant_type=client_credential&appid=APP_ID&secret=APP_SECRET";


    /**
     * 获取微信callback IP地址
     * GET请求
     */
    public static final String GET_CALLBACK_IP = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";

    /**
     * 获取微信API接口 IP地址
     * GET请求
     */
    public static final String GET_API_DOMAIN_IP = "https://api.weixin.qq.com/cgi-bin/get_api_domain_ip?access_token=ACCESS_TOKEN";
}
