package com.dhcc.wechatdemo.constant;

/**
 * @description: 素材管理常量
 * @author: Liu Denghui
 * @time: 2019/11/27 15:11
 */
public class MaterialConstants {

    /**
     * 新增永久图文素材的url地址
     * POST请求
     */
    public static final String ADD_NEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";

    /**
     * 上传图文消息内的图片获取URL
     * POST请求
     */
    public static final String UPLOAD_IMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

    /**
     * 新增其他类型永久素材的url地址
     * POST请求
     * type:图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     */
    public static final String ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";

    /**
     * 获取永久素材
     * POST请求
     */
    public static final String GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";

    /**
     * 删除永久素材
     * POST请求
     */
    public static final String DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";

    /**
     * 修改永久图文素材
     * POST请求
     */
    public static final String UPDATE_NEWS = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";

    /**
     * 获取素材总数
     * GET请求
     */
    public static final String GET_MATERIAL_COUNT = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";

    /**
     * 获取素材列表
     * POST请求
     */
    public static final String BATCHGET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
}
