package com.dhcc.wechatdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.constant.MaterialConstants;
import com.dhcc.wechatdemo.entity.material.ArticlesUpload;
import com.dhcc.wechatdemo.entity.material.BatchgetMaterialInput;
import com.dhcc.wechatdemo.entity.material.VideoUpload;
import com.dhcc.wechatdemo.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @description: 素材管理
 * @author: Liu Denghui
 * @time: 2019/11/26 14:16
 */
@Service
public class MaterialService {

    private Logger logger= LoggerFactory.getLogger(MaterialService.class);

    /**
     * 新增永久图文素材
     * @param accessToken accessToken
     * @param upload 素材上传信息
     * @return json
     */
    public JSONObject addNews(String accessToken, ArticlesUpload upload){
        // 设置url
        String url = MaterialConstants.ADD_NEWS.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始上传图文素材了");
            jsonObject = HttpHelper.doPost(url,upload);
            logger.info("上传图文素材成功");
        } catch (Exception e) {
            logger.error("上传图文素材失败");
            e.printStackTrace();
        }
        return jsonObject;
    }
    /**
     * 新增永久素材（图片/语音/视频）
     * 不上传时，videoUploadEntity可为null
     * @param filePath 文件路径
     * @param accessToken accessToken
     * @param type 文件类型
     * @param videoUpload 视频介绍信息
     * @return JSONObject
     * @throws IOException 文件不存在异常
     */
    public JSONObject upload(String filePath, String accessToken, String type, VideoUpload videoUpload) throws IOException{
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()){
            throw new IOException("文件不存在");
        }
        // 设置url
        String url = MaterialConstants.ADD_MATERIAL.replace("ACCESS_TOKEN", accessToken).replace("TYPE",type);

        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始上传素材了");
            logger.info("上传类型为：" + type);
            jsonObject = HttpHelper.uploadMedia(url, file, videoUpload);
            logger.info("上传素材成功");
            String typeName = "media_id";
            // 上传缩略图时，会返回thumb_media_id
            if("thumb".equals(type)){
                typeName = type + "_media_id";
            }
            String mediaId = jsonObject.getString(typeName);
            logger.info(typeName + "：" + mediaId);
            // 仅当上传图片时才会返回url
            if ("image".equals(type)){
                String imageUrl = jsonObject.getString("url");
                logger.info("imageUrl:" + imageUrl);
            }
        } catch (Exception e) {
            logger.error("上传素材失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 根据media_id获取永久素材
     * 素材类型为视频时，返回json字符串；为音乐、图片时，进行下载文件
     * @param accessToken accessToken
     * @param map 包含media_id：素材id
     * @param type 素材类型
     * @param filePath 文件地址，为语音、图片时，使用
     * @return json
     */
    public JSONObject getMaterial(String accessToken, Map<String, String> map, String type, String filePath){
        String url = MaterialConstants.GET_MATERIAL.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取素材了，获取的素材类型是：" + type);
            if (!"video".equals(type)){
                //不是视频类型时，下载文件
                File file = HttpHelper.downloadMedia(url, map, filePath, null);
            }else {
                //视频类型时，返回视频信息
                jsonObject = HttpHelper.doPost(url, map);
            }
            logger.info("获取素材成功");
        } catch (Exception e) {
            logger.error("获取素材失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 根据media_id删除永久素材
     * @param accessToken accessToken
     * @param map 包含media_id：素材id
     * @return json
     */
    public JSONObject delMaterial(String accessToken, Map<String, String> map){
        String url = MaterialConstants.DEL_MATERIAL.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始删除素材，素材id：" + map.get("media_id"));
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("删除素材成功");
        } catch (Exception e) {
            logger.error("删除素材失败");
            e.printStackTrace();
        }
        return jsonObject;
    }
    /**
     * 获取素材总数
     * @param accessToken accessToken
     * @return JSONObject
     */
    public JSONObject getMaterialCount(String accessToken){
        // 设置url
        String url = MaterialConstants.GET_MATERIAL_COUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取素材总数");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取素材总数成功");
            logger.info("语音数量:" + jsonObject.getString("voice_count"));
            logger.info("视频数量:" + jsonObject.getString("video_count"));
            logger.info("图片数量:" + jsonObject.getString("image_count"));
            logger.info("图文数量:" + jsonObject.getString("news_count"));
        } catch (Exception e) {
            logger.error("获取素材总数失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取素材列表
     * @param accessToken accessToken
     * @param input 获取素材列表信息
     * @return JSONObject
     */
    public JSONObject getBatchgetMaterial(String accessToken, BatchgetMaterialInput input){
        String url = MaterialConstants.BATCHGET_MATERIAL.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取素材列表");
            jsonObject = HttpHelper.doPost(url, input);
            logger.info("获取素材列表成功");
        } catch (Exception e) {
            logger.error("获取素材列表失败");
            e.printStackTrace();
        }
        return jsonObject;
    }


}
