package com.dhcc.wechatdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.entity.AccessToken;
import com.dhcc.wechatdemo.entity.CreateQRCode;
import com.dhcc.wechatdemo.service.BaseService;
import com.dhcc.wechatdemo.service.ToolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 二维码、短链接控制层
 * @author: Liu Denghui
 * @time: 2019/12/3 9:43
 */
@RestController
@RequestMapping("/tool")
public class ToolController {

    private Logger logger= LoggerFactory.getLogger(ToolController.class);

    @Autowired
    BaseService baseService;
    @Autowired
    ToolService toolService;

    /**
     * 创建二维码（临时/永久）
     * @return JSONObject
     */
    @RequestMapping("/createQRCode")
    public JSONObject createQRCode(){
        AccessToken token = baseService.getAccessToken();
        CreateQRCode qrCode = new CreateQRCode();
        qrCode.setAction_name("QR_LIMIT_STR_SCENE");
        CreateQRCode.QRCodeInfo info = new CreateQRCode.QRCodeInfo();
        CreateQRCode.QRCodeScence scence = new CreateQRCode.QRCodeScence();
        scence.setScene_str("视频");
        info.setScene(scence);
        qrCode.setAction_info(info);
        System.out.println(JSON.toJSONString(qrCode));
        return toolService.createQRCode(token.getAccess_token(), qrCode);
    }

    /**
     * 通过ticket换取二维码
     * @param ticket 获取二维码的ticket
     * @param fileName 用户指定的文件名
     * @return JSONObject
     */
    @RequestMapping("/showQRCode")
    public JSONObject showQRCode(String ticket, String fileName){
        return toolService.showQRCode(ticket, fileName);
    }

    /**
     * 将一条长链接转成短链接
     * @param longUrl 长链接
     * @return JSONObject
     */
    @RequestMapping("/shortUrl")
    public JSONObject shortUrl(String longUrl){
        AccessToken token = baseService.getAccessToken();
        return toolService.shortUrl(token.getAccess_token(), longUrl);
    }
}
