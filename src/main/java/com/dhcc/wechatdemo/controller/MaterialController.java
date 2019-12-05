package com.dhcc.wechatdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.entity.AccessToken;
import com.dhcc.wechatdemo.entity.material.ArticleMaterial;
import com.dhcc.wechatdemo.entity.material.ArticlesUpload;
import com.dhcc.wechatdemo.entity.material.BatchgetMaterialInput;
import com.dhcc.wechatdemo.entity.material.VideoUpload;
import com.dhcc.wechatdemo.service.BaseService;
import com.dhcc.wechatdemo.service.MaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 素材相关控制层
 * @author: Liu Denghui
 * @time: 2019/11/26 14:37
 */
@RestController
@RequestMapping("/material")
public class MaterialController {

    private Logger logger= LoggerFactory.getLogger(MaterialController.class);

    @Autowired
    BaseService baseService;
    @Autowired
    MaterialService materialService;

    /**
     * 上传永久图文素材
     * @return string
     */
    @RequestMapping("/addNews")
    public JSONObject addNews(){
        AccessToken token = baseService.getAccessToken();

        ArticleMaterial articleMaterial1 = new ArticleMaterial();
        articleMaterial1.setTitle("测试标题了");
        // 测试公众号
        articleMaterial1.setThumb_media_id("0gJtGI8J6ZGeCeFMFAYU9QSsEd5qCIlxJLagfwG7v4E");
        // 我的公众号
        //articleMaterial1.setThumb_media_id("MpFQFD6QjLRbUIh8nT_e_hMjFh8ERDFf_XIjeUL6-uo");
        articleMaterial1.setAuthor("测试-ldh123");
        articleMaterial1.setDigest(null);
        articleMaterial1.setShow_cover_pic(1);
        articleMaterial1.setContent("测测测312312测测测正文");
        articleMaterial1.setContent_source_url("https://blog.csdn.net/a1786223749/article/details/80787379#1_714");
        // 若加评价，会提示无评价权限，新增图文失败
        //articleMaterial1.setNeed_open_comment(1);
        //articleMaterial1.setOnly_fans_can_comment(0);

        ArticleMaterial articleMaterial2 = new ArticleMaterial();
        articleMaterial2.setTitle("测试2");
        // 测试公众号
        articleMaterial2.setThumb_media_id("0gJtGI8J6ZGeCeFMFAYU9b2cUltUJZN2PFaAu5d77NI");
        // 我的公众号
        //articleMaterial1.setThumb_media_id("MpFQFD6QjLRbUIh8nT_e_hMjFh8ERDFf_XIjeUL6-uo");
        articleMaterial2.setAuthor("测试-ld32312312");
        articleMaterial2.setDigest(null);
        articleMaterial2.setShow_cover_pic(1);
        articleMaterial2.setContent("测测4241213123123123123121212测312312测测测正文");
        articleMaterial2.setContent_source_url("https://blog.csdn.net/a1786223749/article/details/80787379#1_714");
        // 若加评价，会提示无评价权限，新增图文失败
        articleMaterial2.setNeed_open_comment(1);
        articleMaterial2.setOnly_fans_can_comment(0);

        ArticleMaterial articleMaterial3 = new ArticleMaterial();
        articleMaterial3.setTitle("测试3");
        // 测试公众号
        articleMaterial3.setThumb_media_id("0gJtGI8J6ZGeCeFMFAYU9QSsEd5qCIlxJLagfwG7v4E");
        // 我的公众号
        //articleMaterial1.setThumb_media_id("MpFQFD6QjLRbUIh8nT_e_hMjFh8ERDFf_XIjeUL6-uo");
        articleMaterial3.setAuthor("测试-ld32312312");
        articleMaterial3.setDigest(null);
        articleMaterial3.setShow_cover_pic(1);
        articleMaterial3.setContent("测测3");
        articleMaterial3.setContent_source_url("https://blog.csdn.net/a1786223749/article/details/80787379#1_714");
        // 若加评价，会提示无评价权限，新增图文失败
        articleMaterial3.setNeed_open_comment(1);
        articleMaterial3.setOnly_fans_can_comment(1);

        List<ArticleMaterial> list = new ArrayList<>();
        list.add(articleMaterial1);
        list.add(articleMaterial2);
        list.add(articleMaterial3);
        ArticlesUpload upload = new ArticlesUpload();
        upload.setArticles(list);

        return materialService.addNews(token.getAccess_token(), upload);
    }
    /**
     * 新增永久素材（图片、语音、缩略图、视频）
     */
    @RequestMapping("/uploadMaterial")
    public JSONObject uploadFile(String type){
        AccessToken token = baseService.getAccessToken();
        VideoUpload videoUpload = null;
        String filePath = "";
        if ("image".equals(type)){
            filePath = "C:/Users/15564/Desktop/小程序前台/小程序使用图片/菜品图片/蛋挞.jpg";
        }else if ("voice".equals(type)){
            filePath = "D:/MusicDownload/录音.mp3";
        }else if ("thumb".equals(type)){
            filePath = "C:/Users/15564/Desktop/小程序前台/小程序使用图片/储值卡/生日主题.jpg";
        }else if ("video".equals(type)){
            filePath = "D:/MusicDownload/IMG_0192.mp4";
            videoUpload = new VideoUpload();
            videoUpload.setTitle("测试上传视频");
            videoUpload.setIntroduction("这是我上传的第er个视频");
        }else {
            logger.error("输入类型错误");
            return null;
        }
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj = materialService.upload(filePath, token.getAccess_token(), type, videoUpload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

    /**
     * 获取永久素材信息
     * @param mediaId 素材id
     * @param type 素材类型（当为image/voice时，会下载文件，video时会返回信息）
     * @return String
     */
    // TODO: 2019/11/27 image/voice类型会下载文件，且文件名乱码，video类型无介绍信息
    @RequestMapping("/getMaterial")
    public JSONObject getMaterial(String mediaId, String type){
        AccessToken token = baseService.getAccessToken();
        Map<String, String> map = new HashMap<String,String>();
        map.put("media_id",mediaId );
        JSONObject jsonObject = new JSONObject();
        if ("image".equals(type) || "voice".equals(type)){
            String filePath = "C:/Users/15564/Desktop/";
            jsonObject = materialService.getMaterial(token.getAccess_token(), map, type, filePath);
        }else {
            jsonObject = materialService.getMaterial(token.getAccess_token(), map, type, null);
        }
        return jsonObject;
    }

    /**
     * 删除永久素材
     * @param mediaId 素材id
     * @return string
     */
    @RequestMapping("/delMaterial")
    public JSONObject delMaterial(String mediaId){
        AccessToken token = baseService.getAccessToken();
        Map<String, String> map = new HashMap<String,String>();
        map.put("media_id",mediaId );
        return materialService.delMaterial(token.getAccess_token(), map);

    }

    /**
     * 获取素材总数
     * voiceCount：声音数量
     * videoCount：视频数量
     * imageCount：图片数量
     * newsCount：图文数量
     * @return string
     */
    @RequestMapping("/getMaterialCount")
    public JSONObject getMaterialCount(){
        AccessToken token = baseService.getAccessToken();
        return materialService.getMaterialCount(token.getAccess_token());

    }

    /**
     * 获取素材列表
     * @param type 素材类型
     * @return string
     */
    @RequestMapping("/getBatchgetMaterial")
    public JSONObject getBatchgetMaterial(String type){
        BatchgetMaterialInput input = new BatchgetMaterialInput();
        input.setType(type);
        input.setOffset(0);
        input.setCount(5);
        AccessToken token = baseService.getAccessToken();
        return materialService.getBatchgetMaterial(token.getAccess_token(), input);
    }


}
