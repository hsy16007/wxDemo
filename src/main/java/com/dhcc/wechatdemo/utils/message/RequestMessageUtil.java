package com.dhcc.wechatdemo.utils.message;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 消息处理工具，将xml转换为map格式，根据不同需求，获取map中信息
 * @author: Liu Denghui
 * @time: 2019/11/25 14:09
 */
public class RequestMessageUtil {

    /**
     * 将xml转换成Map格式
     * 接收的数据结构为：
     * <xml>
     *  <ToUserName><![CDATA[toUser]]></ToUserName>
     *  <FromUserName><![CDATA[fromUser]]></FromUserName>
     *  <CreateTime>1348831860</CreateTime>
     *  <MsgType><![CDATA[text]]></MsgType>
     *  <Content><![CDATA[this is a test]]></Content>
     *  <MsgId>1234567890123456</MsgId>
     * </xml>
     *
     * @param request request中包含的xml信息
     * @return 返回的map
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request){
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        InputStream in = null;
        try {
            in = request.getInputStream();
            Document document = reader.read(in);
            Element rootElement = document.getRootElement();
            List<Element> list = rootElement.elements();
            for (Element element : list){
                map.put(element.getName(), element.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
