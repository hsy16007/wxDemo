package com.dhcc.wechatdemo.entity.message.template;

/**
 * @description: 模板信息1 的模板数据
 * @author: Liu Denghui
 * @time: 2019/12/2 11:20
 */
public class TemplateMsg1Data {

    /**
     * 模板数据头部信息
     */
    private BaseData first;
    /**
     * 关键词1
     */
    private BaseData keyword1;
    /**
     * 关键词2
     */
    private BaseData keyword2;
    /**
     * 关键词3
     */
    private BaseData keyword3;
    /**
     * 模板数据结尾u信息
     */
    private BaseData remark;

    public BaseData getFirst() {
        return first;
    }

    public void setFirst(BaseData first) {
        this.first = first;
    }

    public BaseData getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(BaseData keyword1) {
        this.keyword1 = keyword1;
    }

    public BaseData getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(BaseData keyword2) {
        this.keyword2 = keyword2;
    }

    public BaseData getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(BaseData keyword3) {
        this.keyword3 = keyword3;
    }

    public BaseData getRemark() {
        return remark;
    }

    public void setRemark(BaseData remark) {
        this.remark = remark;
    }
}
