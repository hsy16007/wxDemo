package com.dhcc.wechatdemo.entity.message.sendall;

/**
 * @description: 群发消息接收者配置
 * @author: Liu Denghui
 * @time: 2019/11/29 9:42
 */
public class Filter {
    /**
     * 用于设定是否向全部用户发送，值为true或false，
     * 选择true该消息群发给所有用户，
     * 选择false可根据tag_id发送给指定群组的用户
     */
    private boolean is_to_all;
    /**
     * 群发到的标签的tag_id，参见用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
     */
    private int tag_id;

    public boolean isIs_to_all() {
        return is_to_all;
    }

    public void setIs_to_all(boolean is_to_all) {
        this.is_to_all = is_to_all;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }
}
