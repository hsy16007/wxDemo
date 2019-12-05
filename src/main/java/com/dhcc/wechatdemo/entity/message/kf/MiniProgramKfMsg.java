package com.dhcc.wechatdemo.entity.message.kf;

/**
 * @description: 客服小程序消息
 * @author: Liu Denghui
 * @time: 2019/12/2 16:49
 */
public class MiniProgramKfMsg extends BaseKfMsg{

    /**
     * 小程序信息
     */
    private MiniProgramPage miniprogrampage;

    public MiniProgramPage getMiniprogrampage() {
        return miniprogrampage;
    }

    public void setMiniprogrampage(MiniProgramPage miniprogrampage) {
        this.miniprogrampage = miniprogrampage;
    }
}
