package com.dhcc.wechatdemo.constant;

/**
 * @description: 客服管理相关url
 * @author: Liu Denghui
 * @time: 2019/12/2 15:44
 */
public class KfConstants {

    /**
     * 客服账号信息
     */
    /**
     * 添加客服帐号
     * POST请求
     */
    public static final String ADD_KF_ACCOUNT = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
    /**
     * 修改客服帐号
     * POST请求
     */
    public static final String UPDATE_KF_ACCOUNT = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
    /**
     * 删除客服帐号
     * POST请求
     */
    public static final String DEL_KF_ACCOUNT = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
    /**
     * 设置客服帐号的头像
     * 头像图片文件必须是jpg格式，推荐使用640*640大小的图片以达到最佳效果
     * POST请求
     */
    public static final String UPLOAD_KF_HEAD_IMG = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
    /**
     * 获取所有客服账号
     * GET请求
     */
    public static final String GET_KF_LIST = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";


    /**
     * 发送客服消息
     * POST请求
     */
    public static final String SEND_KF_MSG = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    /**
     * 客服输入状态
     * POST请求
     */
    public static final String TYPING_KF_MSG = "https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token=ACCESS_TOKEN";

}
