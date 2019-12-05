package com.dhcc.wechatdemo.entity;

/**
 * @description:
 * @author: Liu Denghui
 * @time: 2019/11/25 11:23
 */
public class AccessToken {
    /**
     * 获取到的凭证
     */
    private String access_token;
    /**
     * 凭证有效时间
     */
    private long expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }
}
