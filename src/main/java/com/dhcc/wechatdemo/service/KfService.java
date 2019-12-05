package com.dhcc.wechatdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.constant.KfConstants;
import com.dhcc.wechatdemo.entity.KfAccount;
import com.dhcc.wechatdemo.entity.message.kf.BaseKfMsg;
import com.dhcc.wechatdemo.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 客服管理相关
 * @author: Liu Denghui
 * @time: 2019/12/2 15:46
 */
@Service
public class KfService {

    private Logger logger= LoggerFactory.getLogger(KfService.class);

    /**
     * 添加客服账号
     * @param accessToken accessToken
     * @param kfAccount 新增的客服信息
     * @return JSONObject
     */
    public JSONObject addKfAccount(String accessToken, KfAccount kfAccount){
        // 设置url
        String url = KfConstants.ADD_KF_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始添加客服账号了");
            logger.info("客服账号：" + kfAccount.getKf_account());
            logger.info("客服昵称：" + kfAccount.getNickname());
            logger.info("客服密码：" + kfAccount.getPassword());
            jsonObject = HttpHelper.doPost(url, kfAccount);
            logger.info("添加客服账号成功");
        } catch (Exception e) {
            logger.error("添加客服账号失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 修改客服帐号
     * @param accessToken accessToken
     * @param kfAccount 修改的客服信息
     * @return JSONObject
     */
    public JSONObject updateKfAccount(String accessToken, KfAccount kfAccount){
        // 设置url
        String url = KfConstants.UPDATE_KF_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始修改客服账号了");
            logger.info("客服账号：" + kfAccount.getKf_account());
            logger.info("客服昵称：" + kfAccount.getNickname());
            logger.info("客服密码：" + kfAccount.getPassword());
            jsonObject = HttpHelper.doPost(url, kfAccount);
            logger.info("修改客服账号成功");
        } catch (Exception e) {
            logger.error("修改客服账号失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 删除客服账号
     * @param accessToken accessToken
     * @param kfAccount 删除的客服信息
     * @return JSONObject
     */
    public JSONObject delKfAccount(String accessToken, KfAccount kfAccount){
        // 设置url
        String url = KfConstants.DEL_KF_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始删除客服账号了");
            logger.info("客服账号：" + kfAccount.getKf_account());
            logger.info("客服昵称：" + kfAccount.getNickname());
            logger.info("客服密码：" + kfAccount.getPassword());
            jsonObject = HttpHelper.doPost(url, kfAccount);
            logger.info("删除客服账号成功");
        } catch (Exception e) {
            logger.error("删除客服账号失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 设置客服帐号的头像
     * @param accessToken accessToken
     * @param kfAccount 要设置头像的客服信息，包含Kf_account
     * @return JSONObject
     */
    public JSONObject updateKfHeadImg(String accessToken, KfAccount kfAccount) throws IOException{
        // 设置url
        String url = KfConstants.UPLOAD_KF_HEAD_IMG.replace("ACCESS_TOKEN", accessToken)
                .replace("KFACCOUNT", kfAccount.getKf_account());
        String filePath = "C:/Users/15564/Desktop/小程序前台/小程序使用图片/菜品图片/蛋挞.jpg";
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()){
            throw new IOException("文件不存在");
        }
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始设置客服帐号的头像了");
            logger.info("客服账号：" + kfAccount.getKf_account());
            logger.info("图片路径：" + filePath);
            jsonObject = HttpHelper.uploadMedia(url, file, null);
            logger.info("设置客服帐号的头像成功");
        } catch (Exception e) {
            logger.error("设置客服帐号的头像失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取所有客服账号
     * @param accessToken accessToken
     * @return JSONObject
     */
    public JSONObject getKfList(String accessToken){
        // 设置url
        String url = KfConstants.GET_KF_LIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取所有客服账号了");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取所有客服账号成功");
        } catch (Exception e) {
            logger.error("获取所有客服账号失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 发送客服消息
     * @param accessToken accessToken
     * @param message 返回的客服信息
     * @return JSONObject
     */
    public JSONObject sendKfMsg(String accessToken, BaseKfMsg message){
        // 设置url
        String url = KfConstants.SEND_KF_MSG.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始发送客服信息了");
            if (message.getCustomservice() != null){
                logger.info("发送信息的客服账号为：" + message.getCustomservice().getKf_account());
            }
            logger.info("发送的信息类型为：" + message.getMsgtype());
            jsonObject = HttpHelper.doPost(url, message);
            logger.info("发送客服信息成功");
        } catch (Exception e) {
            logger.error("发送客服信息失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 设置客服输入状态
     * @param accessToken accessToken
     * @param toUser 普通用户（openid）
     * @param command 输入状态："Typing"：对用户下发“正在输入"状态 "CancelTyping"：取消对用户的”正在输入"状态
     * @return JSONObject
     */
    public JSONObject typingKfMsg(String accessToken, String toUser, String command){
        // 设置url
        String url = KfConstants.TYPING_KF_MSG.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("touser", toUser);
        map.put("command", command);
        try {
            logger.info("开始设置客服输入状态了");
            logger.info("输入状态为：" + command);
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("设置客服输入状态成功");
        } catch (Exception e) {
            logger.error("设置客服输入状态失败");
            e.printStackTrace();
        }
        return jsonObject;
    }
}
