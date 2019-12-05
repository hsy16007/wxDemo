package com.dhcc.wechatdemo.constant;

/**
 * @description: 二维码、短链接相关
 * @author: Liu Denghui
 * @time: 2019/12/3 9:37
 */
public class ToolConstants {

    /**
     * 创建二维码
     * POST请求
     */
    public static final String CREATE_QRCODE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";

    /**
     * 通过ticket换取二维码
     * GET请求
     */
    public static final String SHOW_QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

    /**
     * 将一条长链接转成短链接
     * POST请求
     */
    public static final String SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
}
