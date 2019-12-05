package com.dhcc.wechatdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.constant.ToolConstants;
import com.dhcc.wechatdemo.entity.CreateQRCode;
import com.dhcc.wechatdemo.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 二维码、短链接管理
 * @author: Liu Denghui
 * @time: 2019/11/29 11:30
 */
@Service
public class ToolService {

    private Logger logger= LoggerFactory.getLogger(ToolService.class);

    /**
     * 创建二维码（临时/永久）
     * @param accessToken accessToken
     * @param qrCode 二维码信息
     * @return JSONObject
     */
    public JSONObject createQRCode(String accessToken, CreateQRCode qrCode){
        // 设置url
        String url = ToolConstants.CREATE_QRCODE.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始创建二维码了，二维码类型：" + qrCode.getAction_name());
            jsonObject = HttpHelper.doPost(url,qrCode);
            logger.info("创建二维码成功");
        } catch (Exception e) {
            logger.error("创建二维码失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 通过ticket换取二维码
     * @param ticket 获取二维码的ticket
     * @param fileName 用户指定的文件名
     * @return JSONObject
     */
    public JSONObject showQRCode(String ticket, String fileName){
        // 设置url
        String url = ToolConstants.SHOW_QRCODE.replace("TICKET", ticket);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始通过ticket换取二维码了，ticket：" + ticket);
            //jsonObject = HttpHelper.doGet(url);
            String filePath = "C:/Users/15564/Desktop/";
            HttpHelper.downloadMedia(url, filePath, fileName);
            logger.info("通过ticket换取二维码成功");
        } catch (Exception e) {
            logger.error("通过ticket换取二维码失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 将一条长链接转成短链接
     * @param accessToken accessToken
     * @param longUrl 长链接
     * @return JSONObject
     */
    public JSONObject shortUrl(String accessToken, String longUrl){
        // 设置url
        String url = ToolConstants.SHORT_URL.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, String> map = new HashMap<String, String>();
        map.put("action", "long2short");
        map.put("long_url", longUrl);
        try {
            logger.info("开始长链接转短链接了，长链接为：" + longUrl);
            jsonObject = HttpHelper.doPost(url,map);
            logger.info("长链接转短链接成功");
            logger.info("短链接为：" + jsonObject.getString("short_url"));
        } catch (Exception e) {
            logger.error("长链接转短链接失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

}
