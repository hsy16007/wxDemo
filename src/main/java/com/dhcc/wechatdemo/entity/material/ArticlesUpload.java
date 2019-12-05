package com.dhcc.wechatdemo.entity.material;

import java.util.List;

/**
 * @description: 新增图文素材-上传时使用
 * @author: Liu Denghui
 * @time: 2019/11/28 9:45
 */
public class ArticlesUpload {

    /**
     * 多个图文消息
     */
    private List<ArticleMaterial> articles;

    public List<ArticleMaterial> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleMaterial> articles) {
        this.articles = articles;
    }
}
