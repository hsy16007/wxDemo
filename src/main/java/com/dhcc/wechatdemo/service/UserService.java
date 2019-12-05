package com.dhcc.wechatdemo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.constant.UserConstants;
import com.dhcc.wechatdemo.entity.user.GerUserInfoInput;
import com.dhcc.wechatdemo.entity.user.Tag;
import com.dhcc.wechatdemo.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 用户管理
 * @author: Liu Denghui
 * @time: 2019/11/29 11:30
 */
@Service
public class UserService {

    private Logger logger= LoggerFactory.getLogger(UserService.class);

    /**
     * 创建标签
     * @param accessToken accessToken
     * @param tag 标签信息（标签名）
     * @return JSONObject
     */
    public JSONObject createTag(String accessToken, Tag tag){
        // 设置url
        String url = UserConstants.CREATE_TAG.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tag", tag);
        try {
            logger.info("开始创建标签了，标签名称：" + tag.getName());
            jsonObject = HttpHelper.doPost(url,map);
            logger.info("创建标签成功");
        } catch (Exception e) {
            logger.error("创建标签失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取已创建标签
     * @param accessToken accessToken
     * @return JSONObject
     */
    public JSONObject getTag(String accessToken){
        // 设置url
        String url = UserConstants.GET_TAG.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取已创建标签了");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取已创建标签成功");
        } catch (Exception e) {
            logger.error("获取已创建标签失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 更新标签
     * @param accessToken accessToken
     * @param tag 标签信息（标签id，标签名）
     * @return JSONObject
     */
    public JSONObject updateTag(String accessToken, Tag tag){
        // 设置url
        String url = UserConstants.UPDATE_TAG.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tag", tag);
        try {
            logger.info("开始更新标签了，标签id：" + tag.getId() + "；标签新名称：" + tag.getName());
            jsonObject = HttpHelper.doPost(url,map);
            logger.info("更新标签成功");
        } catch (Exception e) {
            logger.error("更新标签失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 删除标签
     * @param accessToken accessToken
     * @param tag 标签信息（标签id）
     * @return JSONObject
     */
    public JSONObject deleteTag(String accessToken, Tag tag){
        // 设置url
        String url = UserConstants.DELETE_TAG.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tag", tag);
        try {
            logger.info("开始删除标签了，标签id：" + tag.getId());
            jsonObject = HttpHelper.doPost(url,map);
            logger.info("删除标签成功");
        } catch (Exception e) {
            logger.error("删除标签失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取标签下粉丝列表
     * @param accessToken accessToken
     * @param tag 标签信息（标签id）
     * @param nextOpenid 第一个拉取的open_id，不填默认从头拉去
     * @return JSONObject
     */
    public JSONObject getUserByTag(String accessToken, Tag tag, String nextOpenid){
        // 设置url
        String url = UserConstants.GET_USER_BY_TAG.replace("ACCESS_TOKEN", accessToken);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tagid", tag.getId());
        map.put("next_openid", nextOpenid);
        System.out.println(JSON.toJSONString(map));
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取标签id: " + tag.getId() + " 下的粉丝列表了");
            if (nextOpenid != null){
                if (!"".equals(nextOpenid)){
                    logger.info("从用户 " + nextOpenid + " 开始拉取");
                }else {
                    logger.info("从第一个用户开始拉取");
                }
            }else {
                logger.info("从第一个用户开始拉取");
            }
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("获取标签下粉丝列表成功");
        } catch (Exception e) {
            logger.error("获取标签下粉丝列表失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 批量为用户打标签
     * @param accessToken accessToken
     * @param openidList 用户openIdList
     * @param tagId 打标签的标签ID
     * @return JSONObject
     */
    public JSONObject batchTagging(String accessToken,String[] openidList, int tagId){
        // 设置url
        String url = UserConstants.BATCH_TAGGING.replace("ACCESS_TOKEN", accessToken);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid_list", openidList);
        map.put("tagid", tagId);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始批量为用户打标签了");
            logger.info("批量打标签的用户有：" + JSON.toJSONString(openidList));
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("批量为用户打标签成功");
        } catch (Exception e) {
            logger.error("批量为用户打标签失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 批量为用户取消标签
     * @param accessToken accessToken
     * @param openidList 用户openIdList
     * @param tagId 打标签的标签ID
     * @return JSONObject
     */
    public JSONObject batchUnTagging(String accessToken, String[] openidList, int tagId){
        // 设置url
        String url = UserConstants.BATCH_UN_TAGGING.replace("ACCESS_TOKEN", accessToken);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid_list", openidList);
        map.put("tagid", tagId);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始批量为用户取消标签了");
            logger.info("批量取消标签的用户有：" + JSON.toJSONString(openidList));
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("批量为用户取消标签成功");
        } catch (Exception e) {
            logger.error("批量为用户取消标签失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取用户身上的标签列表
     * @param accessToken accessToken
     * @param openId 用户openId
     * @return JSONObject
     */
    public JSONObject getIdList(String accessToken, String openId){
        // 设置url
        String url = UserConstants.GET_ID_LIST.replace("ACCESS_TOKEN", accessToken);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid", openId);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取用户：" + openId + " 身上的标签列表了");
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("获取用户身上的标签列表成功");
        } catch (Exception e) {
            logger.error("获取用户身上的标签列表失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取用户基本信息
     * @param accessToken accessToken 调用接口凭证
     * @param input 需查询的用户信息（openid：用户id，lang：语言）
     * @return JSONObject
     */
    public JSONObject getUserInfo(String accessToken, GerUserInfoInput input){
        // 设置url
        String url = UserConstants.GET_USER_INFO.replace("ACCESS_TOKEN", accessToken)
                .replace("OPENID", input.getOpenid()).replace("zh_CN", input.getLang());
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取用户：" + input.getOpenid() + "的基本信息了");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取用户基本信息成功");
        } catch (Exception e) {
            logger.error("获取用户基本信息失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 批量获取用户基本信息
     * @param accessToken accessToken 调用接口凭证
     * @param inputs 用户信息数组
     * @return JSONObject
     */
    public JSONObject batchGetUserInfo(String accessToken, List<GerUserInfoInput> inputs){
        // 设置url
        String url = UserConstants.BATCH_GET_USER_INFO.replace("ACCESS_TOKEN", accessToken);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_list", inputs);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始批量获取用户基本信息了");
            logger.info("获取用户信息的有：" + inputs);
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("批量获取用户基本信息成功");
        } catch (Exception e) {
            logger.error("批量获取用户基本信息失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取公众号的关注者列表
     * @param accessToken accessToken 调用接口凭证
     * @param nextOpenid 从此openid开始，若为空，默认从开头拉取
     * @return JSONObject
     */
    public JSONObject getUserList(String accessToken, String nextOpenid){
        // 设置url
        String url = UserConstants.GET_USER_LIST.replace("ACCESS_TOKEN", accessToken).replace("NEXT_OPENID", "");
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取公众号的关注者列表了");
            if (nextOpenid != null){
                if (!"".equals(nextOpenid)){
                    url = url + nextOpenid;
                    logger.info("从用户" + nextOpenid + "开始拉取");
                }else {
                    logger.info("从第一个用户开始拉取");
                }
            }else {
                logger.info("从第一个用户开始拉取");
            }
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取公众号的关注者列表成功");
        } catch (Exception e) {
            logger.error("获取公众号的关注者列表失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取公众号的黑名单列表
     * @param accessToken accessToken 调用接口凭证
     * @param beginOpenId 从此openid开始，若为空，默认从开头拉取
     * @return JSONObject
     */
    public JSONObject getBlacklist(String accessToken, String beginOpenId){
        // 设置url
        String url = UserConstants.GET_BLACKLIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("begin_openid", beginOpenId);
        try {
            logger.info("开始获取公众号的黑名单列表了");
            if (beginOpenId != null){
                if (!"".equals(beginOpenId)){
                    logger.info("从用户" + beginOpenId + "开始拉取");
                }else {
                    logger.info("从第一个用户开始拉取");
                }
            }else {
                logger.info("从第一个用户开始拉取");
            }
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("获取公众号的黑名单列表成功");
        } catch (Exception e) {
            logger.error("获取公众号的黑名单列表失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 拉黑用户
     * @param accessToken accessToken 调用接口凭证
     * @param openIdList 要拉黑的用户list
     * @return JSONObject
     */
    public JSONObject batchBlacklist(String accessToken, String[] openIdList){
        // 设置url
        String url = UserConstants.BATCH_BLACKLIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid_list", openIdList);
        try {
            logger.info("开始拉黑用户了");
            logger.info("拉黑用户有:" + openIdList);
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("拉黑用户成功");
        } catch (Exception e) {
            logger.error("拉黑用户失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 取消拉黑用户
     * @param accessToken accessToken 调用接口凭证
     * @param openIdList 要拉黑的用户list
     * @return JSONObject
     */
    public JSONObject batchUnBlacklist(String accessToken, String[] openIdList){
        // 设置url
        String url = UserConstants.BATCH_UN_BLACKLIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid_list", openIdList);
        try {
            logger.info("开始取消拉黑用户了");
            logger.info("取消拉黑用户有:" + openIdList);
            jsonObject = HttpHelper.doPost(url, map);
            logger.info("取消拉黑用户成功");
        } catch (Exception e) {
            logger.error("取消拉黑用户失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

}
