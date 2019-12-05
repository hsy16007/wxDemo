package com.dhcc.wechatdemo.entity.message.response;


import java.util.List;

/**
 * @description: 图文消息类（公众帐号 -> 普通用户）
 * @author: Liu Denghui
 * @time: 2019/11/26 13:42
 */
public class NewsResponseMessage extends BaseResponseMessage {

    /**
     * 图文消息个数，限制为10条以内
      */
    private int ArticleCount;
    /**
     * 多条图文消息信息，默认第一个item为大图
     */
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
