package com.dhcc.wechatdemo.entity;

/**
 * @description: 创建二维码实体类
 * @author: Liu Denghui
 * @time: 2019/12/3 10:32
 */
public class CreateQRCode {

    /**
     * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     */
    private String expire_seconds;
    /**
     * 二维码类型，
     * QR_SCENE为临时的整型参数值，
     * QR_STR_SCENE为临时的字符串参数值，
     * QR_LIMIT_SCENE为永久的整型参数值，
     * QR_LIMIT_STR_SCENE为永久的字符串参数值
     */
    private String action_name;
    /**
     * 二维码详细信息
     */
    private QRCodeInfo action_info;

    public String getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(String expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public QRCodeInfo getAction_info() {
        return action_info;
    }

    public void setAction_info(QRCodeInfo action_info) {
        this.action_info = action_info;
    }

    /**
     * 二维码详细信息
     */
    public static class QRCodeInfo{
        /**
         * 二维码信息
         */
        private QRCodeScence scene;

        public QRCodeScence getScene() {
            return scene;
        }

        public void setScene(QRCodeScence scene) {
            this.scene = scene;
        }
    }

    /**
     * 二维码信息
     */
    public static class QRCodeScence{
        /**
         * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
         */
        private String scene_id;
        /**
         * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
         */
        private String scene_str;

        public String getScene_id() {
            return scene_id;
        }

        public void setScene_id(String scene_id) {
            this.scene_id = scene_id;
        }

        public String getScene_str() {
            return scene_str;
        }

        public void setScene_str(String scene_str) {
            this.scene_str = scene_str;
        }
    }
}
