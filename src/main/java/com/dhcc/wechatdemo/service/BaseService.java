package com.dhcc.wechatdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.constant.BaseConstants;
import com.dhcc.wechatdemo.entity.AccessToken;
import com.dhcc.wechatdemo.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 基础信息获取
 * @author: Liu Denghui
 * @time: 2019/11/26 13:51
 */
@Service
public class BaseService {

    private Logger logger= LoggerFactory.getLogger(BaseService.class);

    @Autowired
    RedisService redisService;

    /**
     * 获取AccessToken
     * @return AccessToken
     */
    public AccessToken getAccessToken(){
        // 公众号类型：my我的、test测试公众号
        String type = "test";
        AccessToken token = new AccessToken();
        String tokenName = type + "_access_token";
        if (redisService.exists(tokenName)){
            logger.info("-----从redis中获取AccessToken-----");
            token.setAccess_token((String) redisService.get(tokenName));
            token.setExpires_in(redisService.getExpireTime(tokenName));
        } else {
            logger.info("-----向微信发送请求获取AccessToken-----");
            JSONObject jsonObject = new JSONObject();
            try {
                String url = "";
                if ("my".equals(type)){
                    url = BaseConstants.ACCESS_TOKEN_URL.replace("APP_ID", BaseConstants.APP_ID)
                            .replace("APP_SECRET", BaseConstants.APP_SECRET);
                }else if ("test".equals(type)){
                    url = BaseConstants.ACCESS_TOKEN_URL.replace("APP_ID", BaseConstants.TEST_APP_ID)
                            .replace("APP_SECRET", BaseConstants.TEST_APP_SECRET);
                }
                jsonObject = HttpHelper.doGet(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(jsonObject!=null){
                token.setAccess_token(jsonObject.getString("access_token"));
                token.setExpires_in(jsonObject.getIntValue("expires_in"));
            }
            redisService.set(tokenName, token.getAccess_token(), token.getExpires_in());
        }

        logger.info(type + "AccessToken:" + token.getAccess_token());
        logger.info("ExpiresIn:" + token.getExpires_in());

        return token;
    }

    /**
     * 获取微信callback IP地址
     * @param accessToken AccessToken
     * @return json
     */
    public JSONObject getCallbackIp(String accessToken){
        // 设置url
        String url = BaseConstants.GET_CALLBACK_IP.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取微信callback IP地址");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取微信callback IP地址成功");
        } catch (Exception e) {
            logger.error("获取微信callback IP地址失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取微信API接口 IP地址
     * @param accessToken AccessToken
     * @return json
     */
    public JSONObject getApiDomainIp(String accessToken){
        // 设置url
        String url = BaseConstants.GET_API_DOMAIN_IP.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取微信API接口 IP地址");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取获取微信API接口 IP地址成功");
        } catch (Exception e) {
            logger.error("获取获取微信API接口 IP地址失败");
            e.printStackTrace();
        }
        return jsonObject;
    }
}
