package com.dhcc.wechatdemo.constant;

/**
 * @description: 用户管理相关url常量
 * @author: Liu Denghui
 * @time: 2019/11/25 11:33
 */
public class UserConstants {

    /**
     * 用户标签管理
     */
    /**
     * 创建用户标签
     * POST
     */
    public static final String CREATE_TAG="https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";
    /**
     * 获取公众号已创建的标签
     * GET
     */
    public static final String GET_TAG="https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";
    /**
     * 编辑标签
     * POST
     */
    public static final String UPDATE_TAG="https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN";
    /**
     * 删除标签
     * POST
     */
    public static final String DELETE_TAG="https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN";
    /**
     * 获取标签下的粉丝列表
     * POST（微信官方提示为GET，但需填入标签数据信息）
     */
    public static final String GET_USER_BY_TAG="https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN";
    /**
     * 批量为用户打标签
     * POST
     */
    public static final String BATCH_TAGGING="https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";
    /**
     * 批量为用户取消标签
     * POST
     */
    public static final String BATCH_UN_TAGGING="https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN";
    /**
     * 获取用户身上的标签列表
     * POST
     */
    public static final String GET_ID_LIST="https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN";


    /**
     * 获取用户信息
     */
    /**
     * 获取用户基本信息（UnionID机制）
     * GET
     */
    public static final String GET_USER_INFO="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    /**
     * 批量获取用户基本信息
     * 开发者可通过该接口来批量获取用户基本信息。最多支持一次拉取100条
     * POST
     */
    public static final String BATCH_GET_USER_INFO="https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";


    /**
     * 获取用户列表
     * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过填写next_openid多次拉取的方式来满足需求。
     */
    public static final String GET_USER_LIST="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";


    /**
     * 黑名单管理
     */
    /**
     * 获取公众号列表黑名单
     * POST
     */
    public static final String GET_BLACKLIST="https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN";
    /**
     * 拉黑用户
     * POST
     */
    public static final String BATCH_BLACKLIST="https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN";
    /**
     * 取消拉黑用户
     * POST
     */
    public static final String BATCH_UN_BLACKLIST="https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN";


    }
