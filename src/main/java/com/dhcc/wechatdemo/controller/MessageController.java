package com.dhcc.wechatdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.wechatdemo.constant.BaseConstants;
import com.dhcc.wechatdemo.entity.AccessToken;
import com.dhcc.wechatdemo.entity.message.sendall.*;
import com.dhcc.wechatdemo.entity.message.template.BaseData;
import com.dhcc.wechatdemo.entity.message.template.TemplateMsg1;
import com.dhcc.wechatdemo.entity.message.template.TemplateMsg1Data;
import com.dhcc.wechatdemo.service.BaseService;
import com.dhcc.wechatdemo.service.MessageService;
import com.dhcc.wechatdemo.utils.EncryptionUtil;
import com.dhcc.wechatdemo.utils.message.RequestMessageUtil;
import com.dhcc.wechatdemo.utils.message.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * @description: 微信信息控制层
 *
 * @author: Liu Denghui
 * @time: 2019/11/25 10:43
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    BaseService baseService;
    @Autowired
    MessageService messageService;

    private Logger logger= LoggerFactory.getLogger(MessageController.class);

    /**
     * 验证微信接口配置信息
     * GET请求
     * @param request request
     * @return 返回配置成功/失败
     */
    @RequestMapping(value = "/getAndSendMsg", method = RequestMethod.GET)
    public String checkWxMsg(HttpServletRequest request) {
        logger.info("-----开始校验-----");
        /**
         * 微信加密签名
         */
        String signature = request.getParameter("signature");
        /**
         * 随机字符串
         */
        String echostr = request.getParameter("echostr");
        /**
         * 时间戳
         */
        String timestamp = request.getParameter("timestamp");
        /**
         * 随机数
         */
        String nonce = request.getParameter("nonce");

        //将token、timestamp、nonce三个参数进行字典序排序
        String[] str={BaseConstants.TOKEN,timestamp,nonce};
        Arrays.sort(str);
        StringBuilder sb = new StringBuilder();
        //将三个参数字符串拼接成一个字符串
        for (String param:str) {
            sb.append(param);
        }
        //字符串进行shal加密
        String mySignature = EncryptionUtil.encrypt("SHA1",sb.toString());
        //判断加密后的字符串是否与微信的签名一致
        if(signature.equalsIgnoreCase(mySignature)){
            logger.info("-----校验成功-----");
            return echostr;
        }
        logger.error("这不是微信发来的消息！！");
        logger.info("-----校验失败-----");
        return null;
    }

    /**
     * 根据用户发出的消息并返回信息
     * POST请求
     * @param request request
     * @return 返回给发送者（用户）消息
     */
    @RequestMapping(value = "/getAndSendMsg", method = RequestMethod.POST)
    public String getAndSendMsg(HttpServletRequest request){
        logger.info("-----接受到信息-----");
        String messageStr = null;
        // 将微信请求的xml转为map格式，并获取所需的参数
        Map<String, String> map = RequestMessageUtil.xmlToMap(request);
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String msgType = map.get("MsgType");
        logger.info("toUserName:"+toUserName);
        logger.info("fromUserName:"+fromUserName);
        logger.info("msgType:"+msgType);

        MessageTextUtil messageTextUtil = new MessageTextUtil();
        MessageImageUtil messageImageUtil = new MessageImageUtil();
        MessageVoiceUtil messageVoiceUtil = new MessageVoiceUtil();
        MessageVideoUtil messageVideoUtil = new MessageVideoUtil();
        MessageNewsUtil messageNewsUtil = new MessageNewsUtil();

        if ("text".equals(msgType)){
            // 用户发送文本信息
            //content：文本内容
            String content = map.get("Content");
            logger.info("content:"+content);

            if ("图片".equals(content)){
                messageStr = messageService.backImageMsg(fromUserName, toUserName,"0gJtGI8J6ZGeCeFMFAYU9QSsEd5qCIlxJLagfwG7v4E" );
            }else if ("语音".equals(content)){
                messageStr = messageService.backVoiceMsg(fromUserName, toUserName,"0gJtGI8J6ZGeCeFMFAYU9ZR1WPbi5Z5EzvwaNtDBr78");
            } else if ("视频".equals(content)){
                messageStr = messageService.backVideoMsg(fromUserName, toUserName,"0gJtGI8J6ZGeCeFMFAYU9W0RbmhYX37cHya3QAnVPVk",
                        "测试上传视频","这是我上传的第一个视频" );
            }else if ("图文".equals(content)){
                messageStr = messageService.backArticleMsg(fromUserName, toUserName, "测试标题", "测测测测测测正文",
                        "http://mmbiz.qpic.cn/mmbiz_jpg/ZGIlDYnS0hKibncgUr5IcY5kyxcsxUBqTicvEichoD9oOxbbbegR1MuFhhzB0Jiabtj46An1WIgramppRv7FhHCe6Q/0?wx_fmt=jpeg",
                        "http://mp.weixin.qq.com/s?__biz=MzIyNzg4MjY0MA==&mid=100000008&idx=1&sn=56e2cfac50ff94cc3385a1b75d34d82d&chksm=685b22f75f2cabe173fbe1e28b5ddd2a803af86be61fa0fde428c850ca0fd390ad01ed15bfae#rd");
            }else {
                String backContent = "您输入的内容是：" + content;
                messageStr = messageService.backTextMsg(fromUserName, toUserName,backContent);
            }
        } else if ("event".equals(msgType)){
            //用户点击自定义菜单
            String eventKey= map.get("EventKey");
            logger.info("eventKey:"+eventKey);
            if ("图片".equals(eventKey)){
                messageStr = messageService.backImageMsg(fromUserName, toUserName,"0gJtGI8J6ZGeCeFMFAYU9QSsEd5qCIlxJLagfwG7v4E" );
            }
        }
        return messageStr;
    }

    /**
     * 根据标签进行群发
     * @param tagId 标签id，若为空，即全部发送
     * @return string
     */
    @RequestMapping("/sendMassByTag")
    public JSONObject sendMassByTag(String tagId){
        AccessToken token = baseService.getAccessToken();
        /*SendAllNewsMsg msg = new SendAllNewsMsg();
        //设置接收者
        Filter filter = new Filter();
        if ("".equals(tagId)){
            //设置发送全部粉丝
            filter.setIs_to_all(true);
        }else {
            filter.setIs_to_all(false);
            filter.setTag_id(Integer.parseInt(tagId));
        }
        //设置素材信息
        Common common = new Common();
        common.setMedia_id("0gJtGI8J6ZGeCeFMFAYU9dCTJtdxLrb1eDUW0mGFNC8");
        msg.setFilter(filter);
        msg.setMsgtype("mpnews");
        msg.setMpnews(common);
        msg.setSend_ignore_reprint(0);*/
        SendAllTextMsg msg = new SendAllTextMsg();
        //设置接收者
        Filter filter = new Filter();
        if ("".equals(tagId)){
            //设置发送全部粉丝
            filter.setIs_to_all(true);
        }else {
            filter.setIs_to_all(false);
            filter.setTag_id(Integer.parseInt(tagId));
        }
        msg.setFilter(filter);
        msg.setMsgtype("text");
        CommonText text = new CommonText();
        text.setContent("测试群发");
        msg.setText(text);
        return messageService.sendMassByTag(token.getAccess_token(), msg);
    }

    /**
     * 根据OpenId进行群发(暂未设置)
     * @param openIds 用户openId数组
     * @return string
     */
    @RequestMapping("/sendMassByOpenId")
    public JSONObject sendMassByOpenId(String[] openIds){
        return null;
    }

    /**
     * 删除群发
     * @param msgId 发送出去的消息ID
     * @param articleIdx 要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
     * @return JSONObject
     */
    @RequestMapping("/delMass")
    public JSONObject delMass(String msgId, String articleIdx){
        AccessToken token = baseService.getAccessToken();
        return messageService.delMass(token.getAccess_token(), msgId, articleIdx);
    }

    /**
     * 群发预览(暂时测试预览图文信息)
     * @return JSONObject
     */
    @RequestMapping("/previewMass")
    public JSONObject previewMass (){
        AccessToken token = baseService.getAccessToken();
        PreviewNewsMsg message = new PreviewNewsMsg();
        //设置素材信息
        Common common = new Common();
        common.setMedia_id("0gJtGI8J6ZGeCeFMFAYU9dCTJtdxLrb1eDUW0mGFNC8");
        message.setTouser("okJRlwFIpi8olrpKWXbTC_SIokkE");
        message.setMsgtype("mpnews");
        message.setMpnews(common);
        return messageService.previewMass(token.getAccess_token(), message);
    }

    /**
     * 查询群发的发送状态
     * @param msgId 群发消息id
     * @return JSONObject
     */
    @RequestMapping("/getMassState")
    public JSONObject getMassState (String msgId){
        AccessToken token = baseService.getAccessToken();
        return messageService.getMassState(token.getAccess_token(), msgId);
    }

    /**
     * 获取群发速度
     * @return JSONObject
     */
    @RequestMapping("/getMassSpeed")
    public JSONObject getMassSpeed (){
        AccessToken token = baseService.getAccessToken();
        return messageService.getMassSpeed(token.getAccess_token());
    }

    /**
     * 设置群发速度
     * @param speed 群发速度
     * @return JSONObject
     */
    @RequestMapping("/setMassSpeed")
    public JSONObject setMassSpeed (int speed){
        AccessToken token = baseService.getAccessToken();
        return messageService.setMassSpeed(token.getAccess_token(), speed);
    }

    /**
     * 设置公众号所属行业
     * 需要选择公众账号服务所处的2个行业，每月可更改1次所选行业
     * @param industryId1 所属行业1
     * @param industryId2 所属行业2
     * @return string
     */
    @RequestMapping("/setIndustry")
    public JSONObject setIndustry(int industryId1, int industryId2){
        AccessToken token = baseService.getAccessToken();
        return messageService.setIndustry(token.getAccess_token(), industryId1, industryId2);
    }

    /**
     * 获取公众号所属行业
     * 需要选择公众账号服务所处的2个行业，每月可更改1次所选行业
     * @return string
     */
    @RequestMapping("/getIndustry")
    public JSONObject getIndustry(){
        AccessToken token = baseService.getAccessToken();
        return messageService.getIndustry(token.getAccess_token());
    }

    /**
     * 获得模板ID
     * @param templateIdShort 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * @return string
     */
    @RequestMapping("/addTemplate")
    public JSONObject addTemplate(String templateIdShort){
        AccessToken token = baseService.getAccessToken();
        return messageService.addTemplate(token.getAccess_token(), templateIdShort);
    }

    /**
     * 获取模板列表
     * @return string
     */
    @RequestMapping("/getAllPrivateTemplate")
    public JSONObject getAllPrivateTemplate(){
        AccessToken token = baseService.getAccessToken();
        return messageService.getAllPrivateTemplate(token.getAccess_token());
    }

    /**
     * 删除模板
     * @param templateId 模板id
     * @return string
     */
    @RequestMapping("/delPrivateTemplate")
    public JSONObject delPrivateTemplate(String templateId){
        AccessToken token = baseService.getAccessToken();
        return messageService.delPrivateTemplate(token.getAccess_token(), templateId);
    }

    /**
     * 发送模板消息
     * @param userOpenId 接收用户的openId
     * @return String
     */
    @RequestMapping("/sendTemplate")
    public JSONObject sendTemplate(String userOpenId){
        AccessToken token = baseService.getAccessToken();
        TemplateMsg1 templateMsg = new TemplateMsg1();
        TemplateMsg1Data data = new TemplateMsg1Data();
        BaseData first = new BaseData();
        first.setValue("购买成功");
        data.setFirst(first);
        BaseData keyword1 = new BaseData();
        keyword1.setValue("生日套餐");
        keyword1.setColor("#173177");
        data.setKeyword1(keyword1);
        BaseData keyword2 = new BaseData();
        keyword2.setValue("￥99.98");
        keyword2.setColor("#173177");
        data.setKeyword2(keyword2);
        BaseData keyword3 = new BaseData();
        keyword3.setValue("2019年12月2日");
        data.setKeyword3(keyword3);
        BaseData remark = new BaseData();
        remark.setValue("欢迎再次购买");
        remark.setColor("#173177");
        data.setRemark(remark);
        templateMsg.setData(data);

        templateMsg.setTouser(userOpenId);
        templateMsg.setTemplate_id("4D2PkNYliv0xkjOq8dOgHtIe-m_71ZftYMU9pt-ehuA");
        templateMsg.setUrl("www.baidu.com");
        return messageService.sendTemplate(token.getAccess_token(), templateMsg);
    }
}
