package com.dhcc.wechatdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.constant.MenuConstants;
import com.dhcc.wechatdemo.entity.menu.base.Menu;
import com.dhcc.wechatdemo.utils.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: 菜单service
 * @author: Liu Denghui
 * @time: 2019/11/28 14:03
 */
@Service
public class MenuService {

    private Logger logger= LoggerFactory.getLogger(MenuService.class);


    /**
     * 创建菜单
     * @param accessToken accessToken
     * @param menu 菜单类型
     * @return JSONObject
     */
    public JSONObject createMenu(String accessToken, Menu menu){
        // 设置url
        String url = MenuConstants.CREATE_MENU.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始创建菜单了");
            jsonObject = HttpHelper.doPost(url,menu);
            logger.info("创建菜单成功");
        } catch (Exception e) {
            logger.error("创建菜单失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取菜单
     * @param accessToken accessToken
     * @return JSONObject
     */
    public JSONObject getMenu(String accessToken){
        // 设置url
        String url = MenuConstants.GET_MENU.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始获取菜单了");
            jsonObject = HttpHelper.doGet(url);
            logger.info("获取菜单成功");
        } catch (Exception e) {
            logger.error("获取菜单失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 删除菜单
     * @param accessToken accessToken
     * @return JSONObject
     */
    public JSONObject delMenu(String accessToken){
        // 设置url
        String url = MenuConstants.DELETE_MENU.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("开始删除菜单了");
            jsonObject = HttpHelper.doGet(url);
            logger.info("删除菜单成功");
        } catch (Exception e) {
            logger.error("删除菜单失败");
            e.printStackTrace();
        }
        return jsonObject;
    }
}
