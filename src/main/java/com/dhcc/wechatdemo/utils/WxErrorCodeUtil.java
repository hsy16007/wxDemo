package com.dhcc.wechatdemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 微信错误码工具类
 * @author: Liu Denghui
 * @time: 2019/11/26 17:31
 */
public class WxErrorCodeUtil {
    private static Logger logger= LoggerFactory.getLogger(WxErrorCodeUtil.class);

    public static String getErrorCode( String errcode){
        String errMsg = "";
        switch (errcode){
            case "-1" :{
                logger.error("-----errcode：" + errcode + "系统繁忙，此时请开发者稍候再试-----");
                errMsg = "系统繁忙，此时请开发者稍候再试";
                break;
            }
            case "40001" :{
                logger.error("-----errcode：" + errcode + "获取 access_token 时 AppSecret 错误，或者 access_token 无效。请开发者认真比对 AppSecret 的正确性，或查看是否正在为恰当的公众号调用接口-----");
                errMsg = "获取 access_token 时 AppSecret 错误，或者 access_token 无效。请开发者认真比对 AppSecret 的正确性，或查看是否正在为恰当的公众号调用接口";
                break;
            }
            case "40002" :{
                logger.error("-----errcode：" + errcode + "不合法的凭证类型-----");
                errMsg = "不合法的凭证类型";
                break;
            }
            case "40003" :{
                logger.error("-----errcode：" + errcode + "不合法的 OpenID ，请开发者确认 OpenID （该用户）是否已关注公众号，或是否是其他公众号的 OpenID-----");
                errMsg = "不合法的 OpenID ，请开发者确认 OpenID （该用户）是否已关注公众号，或是否是其他公众号的 OpenID";
                break;
            }
            case "40004" :{
                logger.error("-----errcode：" + errcode + "不合法的媒体文件类型-----");
                errMsg = "不合法的媒体文件类型";
                break;
            }
            case "40005" :{
                logger.error("-----errcode：" + errcode + "不合法的文件类型-----");
                errMsg = "不合法的文件类型";
                break;
            }
            case "40006" :{
                logger.error("-----errcode：" + errcode + "不合法的文件大小-----");
                errMsg = "不合法的文件大小";
                break;
            }
            case "40007" :{
                logger.error("-----errcode：" + errcode + "不合法的媒体文件 id-----");
                errMsg = "不合法的媒体文件 id";
                break;
            }
            case "40008" :{
                logger.error("-----errcode：" + errcode + "不合法的消息类型-----");
                errMsg = "不合法的消息类型";
                break;
            }
            case "40009" :{
                logger.error("-----errcode：" + errcode + "不合法的图片大小-----");
                errMsg = "不合法的图片大小";
                break;
            }
            case "40010" :{
                logger.error("-----errcode：" + errcode + "不合法的语音大小-----");
                errMsg = "不合法的语音大小";
                break;
            }
            case "40011" :{
                logger.error("-----errcode：" + errcode + "不合法的视频大小-----");
                errMsg = "不合法的视频大小";
                break;
            }
            case "40012" :{
                logger.error("-----errcode：" + errcode + "不合法的缩略图大小-----");
                errMsg = "不合法的缩略图大小";
                break;
            }
            case "40013" :{
                logger.error("-----errcode：" + errcode + "不合法的 AppID，请开发者检查 AppID 的正确性，避免异常字符，注意大小写-----");
                errMsg = "不合法的 AppID，请开发者检查 AppID 的正确性，避免异常字符，注意大小写";
                break;
            }
            case "40014" :{
                logger.error("-----errcode：" + errcode + "不合法的 access_token ，请开发者认真比对 access_token 的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口-----");
                errMsg = "access_token ，请开发者认真比对 access_token 的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口";
                break;
            }
            case "40015" :{
                logger.error("-----errcode：" + errcode + "不合法的菜单类型-----");
                errMsg = "不合法的菜单类型";
                break;
            }
            case "40016" :{
                logger.error("-----errcode：" + errcode + "不合法的菜单按钮个数-----");
                errMsg = "不合法的菜单按钮个数";
                break;
            }
            case "40017" :{
                logger.error("-----errcode：" + errcode + "不合法的按钮类型-----");
                errMsg = "不合法的按钮类型";
                break;
            }
            case "40018" :{
                logger.error("-----errcode：" + errcode + "不合法的按钮名称长度-----");
                errMsg = "不合法的按钮名称长度";
                break;
            }
            case "40019" :{
                logger.error("-----errcode：" + errcode + "不合法的按钮 KEY 长度-----");
                errMsg = "不合法的按钮 KEY 长度";
                break;
            }
            case "40020" :{
                logger.error("-----errcode：" + errcode + "不合法的 url 长度-----");
                errMsg = "不合法的 url 长度";
                break;
            }
            case "40021" :{
                logger.error("-----errcode：" + errcode + "不合法的菜单版本号-----");
                errMsg = "不合法的菜单版本号";
                break;
            }
            case "40022" :{
                logger.error("-----errcode：" + errcode + "不合法的子菜单级数-----");
                errMsg = "不合法的子菜单级数";
                break;
            }
            case "40023" :{
                logger.error("-----errcode：" + errcode + "不合法的子菜单按钮个数-----");
                errMsg = "不合法的子菜单按钮个数";
                break;
            }
            case "40024" :{
                logger.error("-----errcode：" + errcode + "不合法的子菜单类型-----");
                errMsg = "不合法的子菜单类型";
                break;
            }
            case "40025" :{
                logger.error("-----errcode：" + errcode + "不合法的子菜单按钮名称长度-----");
                errMsg = "不合法的子菜单按钮名称长度";
                break;
            }
            case "40026" :{
                logger.error("-----errcode：" + errcode + "不合法的子菜单按钮 KEY 长度-----");
                errMsg = "不合法的子菜单按钮 KEY 长度";
                break;
            }
            case "40027" :{
                logger.error("-----errcode：" + errcode + "不合法的子菜单按钮 url 长度-----");
                errMsg = "不合法的子菜单按钮 url 长度";
                break;
            }
            case "40028" :{
                logger.error("-----errcode：" + errcode + "不合法的自定义菜单使用用户-----");
                errMsg = "不合法的自定义菜单使用用户";
                break;
            }
            case "40029" :{
                logger.error("-----errcode：" + errcode + "不合法或已过期的 oauth_code-----");
                errMsg = "不合法或已过期的 oauth_code";
                break;
            }
            case "40030" :{
                logger.error("-----errcode：" + errcode + "不合法的 refresh_token-----");
                errMsg = "不合法的 refresh_token";
                break;
            }
            case "40031" :{
                logger.error("-----errcode：" + errcode + "不合法的 openid 列表-----");
                errMsg = "不合法的 openid 列表";
                break;
            }
            case "40032" :{
                logger.error("-----errcode：" + errcode + "不合法的 openid 列表长度-----");
                errMsg = "不合法的 openid 列表长度";
                break;
            }
            case "40033" :{
                logger.error("-----errcode：" + errcode + "不合法的请求字符，不能包含 \\uxxxx 格式的字符-----");
                errMsg = "不合法的请求字符，不能包含 \\uxxxx 格式的字符";
                break;
            }
            case "40035" :{
                logger.error("-----errcode：" + errcode + "不合法的参数-----");
                errMsg = "不合法的参数";
                break;
            }
            case "40036" :{
                logger.error("-----errcode：" + errcode + "不合法的 template_id 长度-----");
                errMsg = "不合法的 template_id 长度";
                break;
            }
            case "40037" :{
                logger.error("-----errcode：" + errcode + "不合法的 template_id-----");
                errMsg = "不合法的 template_id";
                break;
            }
            case "40038" :{
                logger.error("-----errcode：" + errcode + "不合法的请求格式-----");
                errMsg = "不合法的请求格式";
                break;
            }
            case "40039" :{
                logger.error("-----errcode：" + errcode + "不合法的 url 长度-----");
                errMsg = "不合法的 url 长度";
                break;
            }
            case "40048" :{
                logger.error("-----errcode：" + errcode + "不合法的 url 域名,无效的url-----");
                errMsg = "不合法的 url 域名,无效的url";
                break;
            }
            case "40050" :{
                logger.error("-----errcode：" + errcode + "不合法的分组 id-----");
                errMsg = "不合法的分组 id";
                break;
            }
            case "40051" :{
                logger.error("-----errcode：" + errcode + "分组名字不合法-----");
                errMsg = "分组名字不合法";
                break;
            }
            case "40054" :{
                logger.error("-----errcode：" + errcode + "不合法的子菜单按钮 url 域名-----");
                errMsg = "不合法的子菜单按钮 url 域名";
                break;
            }
            case "40055" :{
                logger.error("-----errcode：" + errcode + "不合法的菜单按钮 url 域名-----");
                errMsg = "不合法的菜单按钮 url 域名";
                break;
            }
            case "40059" :{
                logger.error("-----errcode：" + errcode + "无效的消息id-----");
                errMsg = "无效的消息id";
                break;
            }
            case "40060" :{
                logger.error("-----errcode：" + errcode + "删除单篇图文时，指定的 article_idx 不合法-----");
                errMsg = "删除单篇图文时，指定的 article_idx 不合法";
                break;
            }
            case "40066" :{
                logger.error("-----errcode：" + errcode + "不合法的 url-----");
                errMsg = "不合法的 url";
                break;
            }
            case "40117" :{
                logger.error("-----errcode：" + errcode + "分组名字不合法-----");
                errMsg = "分组名字不合法";
                break;
            }
            case "40118" :{
                logger.error("-----errcode：" + errcode + "media_id 大小不合法-----");
                errMsg = "media_id 大小不合法";
                break;
            }
            case "40119" :{
                logger.error("-----errcode：" + errcode + "button 类型错误-----");
                errMsg = "button 类型错误";
                break;
            }
            case "40120" :{
                logger.error("-----errcode：" + errcode + "子 button 类型错误-----");
                errMsg = "子 button 类型错误";
                break;
            }
            case "40121" :{
                logger.error("-----errcode：" + errcode + "不合法的 media_id 类型-----");
                errMsg = "不合法的 media_id 类型";
                break;
            }
            case "40125" :{
                logger.error("-----errcode：" + errcode + "无效的appsecret-----");
                errMsg = "无效的appsecret";
                break;
            }
            case "40132" :{
                logger.error("-----errcode：" + errcode + "微信号不合法-----");
                errMsg = "微信号不合法";
                break;
            }
            case "40137" :{
                logger.error("-----errcode：" + errcode + "不支持的图片格式-----");
                errMsg = "不支持的图片格式";
                break;
            }
            case "40155" :{
                logger.error("-----errcode：" + errcode + "请勿添加其他公众号的主页链接-----");
                errMsg = "请勿添加其他公众号的主页链接";
                break;
            }
            case "40163" :{
                logger.error("-----errcode：" + errcode + "oauth_code已使用-----");
                errMsg = "oauth_code已使用";
                break;
            }
            case "41001" :{
                logger.error("-----errcode：" + errcode + "缺失 access_token 参数-----");
                errMsg = "缺失 access_token 参数";
                break;
            }
            case "41002" :{
                logger.error("-----errcode：" + errcode + "缺失 appid 参数-----");
                errMsg = "缺失 appid 参数";
                break;
            }
            case "41003" :{
                logger.error("-----errcode：" + errcode + "缺失 refresh_token 参数-----");
                errMsg = "缺失 refresh_token 参数";
                break;
            }
            case "41004" :{
                logger.error("-----errcode：" + errcode + "缺失 secret 参数-----");
                errMsg = "缺失 secret 参数";
                break;
            }
            case "41005" :{
                logger.error("-----errcode：" + errcode + "缺失二进制媒体文件-----");
                errMsg = "缺失二进制媒体文件";
                break;
            }
            case "41006" :{
                logger.error("-----errcode：" + errcode + "缺失 media_id 参数-----");
                errMsg = "缺失 media_id 参数";
                break;
            }
            case "41007" :{
                logger.error("-----errcode：" + errcode + "缺失子菜单数据-----");
                errMsg = "缺失子菜单数据";
                break;
            }
            case "41008" :{
                logger.error("-----errcode：" + errcode + "缺失 code 参数-----");
                errMsg = "缺失 code 参数";
                break;
            }
            case "41009" :{
                logger.error("-----errcode：" + errcode + "缺失 openid 参数-----");
                errMsg = "缺失 openid 参数";
                break;
            }
            case "41010" :{
                logger.error("-----errcode：" + errcode + "缺失 url 参数-----");
                errMsg = "缺失 url 参数";
                break;
            }
            case "42001" :{
                logger.error("-----errcode：" + errcode + "access_token 超时，请检查 access_token 的有效期，请参考基础支持 - 获取 access_token 中，对 access_token 的详细机制说明-----");
                errMsg = "access_token 超时，请检查 access_token 的有效期，请参考基础支持 - 获取 access_token 中，对 access_token 的详细机制说明";
                break;
            }
            case "42002" :{
                logger.error("-----errcode：" + errcode + "refresh_token 超时-----");
                errMsg = "refresh_token 超时";
                break;
            }
            case "42003" :{
                logger.error("-----errcode：" + errcode + "oauth_code 超时-----");
                errMsg = "oauth_code 超时";
                break;
            }
            case "42007" :{
                logger.error("-----errcode：" + errcode + "用户修改微信密码， accesstoken 和 refreshtoken 失效，需要重新授权-----");
                errMsg = "用户修改微信密码， accesstoken 和 refreshtoken 失效，需要重新授权";
                break;
            }
            case "43001" :{
                logger.error("-----errcode：" + errcode + "需要使用 GET 方法请求-----");
                errMsg = "需要使用 GET 方法请求";
                break;
            }
            case "43002" :{
                logger.error("-----errcode：" + errcode + "需要使用 POST 方法请求-----");
                errMsg = "需要使用 POST 方法请求";
                break;
            }
            case "43003" :{
                logger.error("-----errcode：" + errcode + "需要使用 HTTPS-----");
                errMsg = "需要使用 HTTPS";
                break;
            }
            case "43004" :{
                logger.error("-----errcode：" + errcode + "需要订阅/关注者关系-----");
                errMsg = "需要订阅关系";
                break;
            }
            case "43005" :{
                logger.error("-----errcode：" + errcode + "需要好友关系-----");
                errMsg = "需要好友关系";
                break;
            }
            case "43019" :{
                logger.error("-----errcode：" + errcode + "需要将接收者从黑名单中移除-----");
                errMsg = "需要将接收者从黑名单中移除";
                break;
            }
            case "44001" :{
                logger.error("-----errcode：" + errcode + "空白的多媒体文件-----");
                errMsg = "空白的多媒体文件";
                break;
            }
            case "44002" :{
                logger.error("-----errcode：" + errcode + "空白的 POST 数据-----");
                errMsg = "空白的 POST 数据";
                break;
            }
            case "44003" :{
                logger.error("-----errcode：" + errcode + "图文消息内容为空-----");
                errMsg = "图文消息内容为空";
                break;
            }
            case "44004" :{
                logger.error("-----errcode：" + errcode + "文本消息内容为空-----");
                errMsg = "文本消息内容为空";
                break;
            }
            case "44005" :{
                logger.error("-----errcode：" + errcode + "空白的列表-----");
                errMsg = "空白的列表";
                break;
            }
            case "45001" :{
                logger.error("-----errcode：" + errcode + "二进制/多媒体文件大小超过限制-----");
                errMsg = "二进制/多媒体文件大小超过限制";
                break;
            }
            case "45002" :{
                logger.error("-----errcode：" + errcode + "消息内容超过限制-----");
                errMsg = "消息内容超过限制";
                break;
            }
            case "45003" :{
                logger.error("-----errcode：" + errcode + "标题文字超过限制-----");
                errMsg = "标题文字超过限制";
                break;
            }
            case "45004" :{
                logger.error("-----errcode：" + errcode + "描述文字超过限制-----");
                errMsg = "描述文字超过限制";
                break;
            }
            case "45005" :{
                logger.error("-----errcode：" + errcode + "url 链接字段超过限制-----");
                errMsg = "url 链接字段超过限制";
                break;
            }
            case "45006" :{
                logger.error("-----errcode：" + errcode + "picurl 图片链接字段超过限制-----");
                errMsg = "picurl 图片链接字段超过限制";
                break;
            }
            case "45007" :{
                logger.error("-----errcode：" + errcode + "语音播放时间超过限制（语音为 60s 最大）-----");
                errMsg = "语音播放时间超过限制（语音为 60s 最大）";
                break;
            }
            case "45008" :{
                logger.error("-----errcode：" + errcode + "article 图文消息超过限制-----");
                errMsg = "article 图文消息超过限制";
                break;
            }
            case "45009" :{
                logger.error("-----errcode：" + errcode + "接口调动频率超过限制-----");
                errMsg = "接口调动频率超过限制";
                break;
            }
            case "45010" :{
                logger.error("-----errcode：" + errcode + "建立菜单个数超过限制-----");
                errMsg = "建立菜单个数超过限制";
                break;
            }
            case "45011" :{
                logger.error("-----errcode：" + errcode + "API调用太频繁，请稍后再试-----");
                errMsg = "API调用太频繁，请稍后再试";
                break;
            }
            case "45012" :{
                logger.error("-----errcode：" + errcode + "模板大小超过限制-----");
                errMsg = "模板大小超过限制";
                break;
            }
            case "45015" :{
                logger.error("-----errcode：" + errcode + "回复时间超过限制-----");
                errMsg = "回复时间超过限制";
                break;
            }
            case "45016" :{
                logger.error("-----errcode：" + errcode + "系统分组，不允许修改-----");
                errMsg = "系统分组，不允许修改";
                break;
            }
            case "45017" :{
                logger.error("-----errcode：" + errcode + "分组名字过长-----");
                errMsg = "分组名字过长";
                break;
            }
            case "45018" :{
                logger.error("-----errcode：" + errcode + "分组数量过多-----");
                errMsg = "分组数量过多";
                break;
            }
            case "45047" :{
                logger.error("-----errcode：" + errcode + "客服接口下行条数超过上限-----");
                errMsg = "客服接口下行条数超过上限";
                break;
            }
            case "45064" :{
                logger.error("-----errcode：" + errcode + "创建菜单包含未关联的小程序-----");
                errMsg = "创建菜单包含未关联的小程序";
                break;
            }
            case "45065" :{
                logger.error("-----errcode：" + errcode + "相同 clientmsgid 已存在群发记录，返回数据中带有已存在的群发任务的 msgid-----");
                errMsg = "相同 clientmsgid 已存在群发记录，返回数据中带有已存在的群发任务的 msgid";
                break;
            }
            case "45066" :{
                logger.error("-----errcode：" + errcode + "相同 clientmsgid 重试速度过快，请间隔1分钟重试-----");
                errMsg = "相同 clientmsgid 重试速度过快，请间隔1分钟重试";
                break;
            }
            case "45067" :{
                logger.error("-----errcode：" + errcode + "clientmsgid 长度超过限制-----");
                errMsg = "clientmsgid 长度超过限制";
                break;
            }
            case "46001" :{
                logger.error("-----errcode：" + errcode + "不存在媒体数据-----");
                errMsg = "不存在媒体数据";
                break;
            }
            case "46002" :{
                logger.error("-----errcode：" + errcode + "不存在的菜单版本-----");
                errMsg = "";
                break;
            }
            case "46003" :{
                logger.error("-----errcode：" + errcode + "不存在的菜单数据-----");
                errMsg = "";
                break;
            }
            case "46004" :{
                logger.error("-----errcode：" + errcode + "不存在的用户-----");
                errMsg = "不存在的用户";
                break;
            }
            case "47001" :{
                logger.error("-----errcode：" + errcode + "解析 JSON/XML 内容错误-----");
                errMsg = "解析 JSON/XML 内容错误";
                break;
            }
            case "48001" :{
                logger.error("-----errcode：" + errcode + "API未经授权，请确认公众号已获得该接口，可以在公众平台官网 - 开发者中心页中查看接口权限-----");
                errMsg = "API未经授权，请确认公众号已获得该接口，可以在公众平台官网 - 开发者中心页中查看接口权限";
                break;
            }
            case "48002" :{
                logger.error("-----errcode：" + errcode + "粉丝拒收消息（粉丝在公众号选项中，关闭了 “ 接收消息 ” ）-----");
                errMsg = "粉丝拒收消息（粉丝在公众号选项中，关闭了 “ 接收消息 ” ）";
                break;
            }
            case "48004" :{
                logger.error("-----errcode：" + errcode + "api 接口被封禁，请登录 mp.weixin.qq.com 查看详情-----");
                errMsg = "api 接口被封禁，请登录 mp.weixin.qq.com 查看详情";
                break;
            }
            case "48005" :{
                logger.error("-----errcode：" + errcode + "api 禁止删除被自动回复和自定义菜单引用的素材-----");
                errMsg = "api 禁止删除被自动回复和自定义菜单引用的素材";
                break;
            }
            case "48006" :{
                logger.error("-----errcode：" + errcode + "api 禁止清零调用次数，因为清零次数达到上限-----");
                errMsg = "api 禁止清零调用次数，因为清零次数达到上限";
                break;
            }
            case "48008" :{
                logger.error("-----errcode：" + errcode + "没有该类型消息的发送权限-----");
                errMsg = "没有该类型消息的发送权限";
                break;
            }
            case "50001" :{
                logger.error("-----errcode：" + errcode + "用户未授权该API-----");
                errMsg = "用户未授权该API";
                break;
            }
            case "50002" :{
                logger.error("-----errcode：" + errcode + "用户受限，可能是违规后接口被封禁-----");
                errMsg = "用户受限，可能是违规后接口被封禁";
                break;
            }
            case "50005" :{
                logger.error("-----errcode：" + errcode + "用户未关注公众号-----");
                errMsg = "用户未关注公众号";
                break;
            }
            case "61451" :{
                logger.error("-----errcode：" + errcode + "参数错误 (invalid parameter)-----");
                errMsg = "参数错误 (invalid parameter)";
                break;
            }
            case "61452" :{
                logger.error("-----errcode：" + errcode + "无效客服账号 (invalid kf_account)-----");
                errMsg = "无效客服账号 (invalid kf_account)";
                break;
            }
            case "61453" :{
                logger.error("-----errcode：" + errcode + "客服帐号已存在 (kf_account exsited)-----");
                errMsg = "客服帐号已存在 (kf_account exsited)";
                break;
            }
            case "61454" :{
                logger.error("-----errcode：" + errcode + "客服帐号名长度超过限制 ( 仅允许 10 个英文字符，不包括 @ 及 @ 后的公众号的微信号 )(invalid   kf_acount length)-----");
                errMsg = "客服帐号名长度超过限制 ( 仅允许 10 个英文字符，不包括 @ 及 @ 后的公众号的微信号 )(invalid   kf_acount length)";
                break;
            }
            case "61455" :{
                logger.error("-----errcode：" + errcode + "客服帐号名包含非法字符 ( 仅允许英文 + 数字 )(illegal character in     kf_account)-----");
                errMsg = "客服帐号名包含非法字符 ( 仅允许英文 + 数字 )(illegal character in     kf_account)";
                break;
            }
            case "61456" :{
                logger.error("-----errcode：" + errcode + "客服帐号个数超过限制 (10 个客服账号 )(kf_account count exceeded)-----");
                errMsg = "客服帐号个数超过限制 (10 个客服账号 )(kf_account count exceeded)";
                break;
            }
            case "61457" :{
                logger.error("-----errcode：" + errcode + "无效头像文件类型 (invalid   file type)-----");
                errMsg = "无效头像文件类型 (invalid   file type)";
                break;
            }
            case "61450" :{
                logger.error("-----errcode：" + errcode + "系统错误 (system error)-----");
                errMsg = "系统错误 (system error)";
                break;
            }
            case "61500" :{
                logger.error("-----errcode：" + errcode + "日期格式错误-----");
                errMsg = "日期格式错误";
                break;
            }
            case "63001" :{
                logger.error("-----errcode：" + errcode + "部分参数为空-----");
                errMsg = "部分参数为空";
                break;
            }
            case "63002" :{
                logger.error("-----errcode：" + errcode + "-----");
                errMsg = "无效的签名无效的签名";
                break;
            }
            case "65301" :{
                logger.error("-----errcode：" + errcode + "不存在此 menuid 对应的个性化菜单-----");
                errMsg = "不存在此 menuid 对应的个性化菜单";
                break;
            }
            case "65302" :{
                logger.error("-----errcode：" + errcode + "没有相应的用户-----");
                errMsg = "没有相应的用户";
                break;
            }
            case "65303" :{
                logger.error("-----errcode：" + errcode + "没有默认菜单，不能创建个性化菜单-----");
                errMsg = "没有默认菜单，不能创建个性化菜单";
                break;
            }
            case "65304" :{
                logger.error("-----errcode：" + errcode + "MatchRule 信息为空-----");
                errMsg = "MatchRule 信息为空";
                break;
            }
            case "65305" :{
                logger.error("-----errcode：" + errcode + "个性化菜单数量受限-----");
                errMsg = "个性化菜单数量受限";
                break;
            }
            case "65306" :{
                logger.error("-----errcode：" + errcode + "不支持个性化菜单的帐号-----");
                errMsg = "不支持个性化菜单的帐号";
                break;
            }
            case "65307" :{
                logger.error("-----errcode：" + errcode + "个性化菜单信息为空-----");
                errMsg = "个性化菜单信息为空";
                break;
            }
            case "65308" :{
                logger.error("-----errcode：" + errcode + "包含没有响应类型的 button-----");
                errMsg = "包含没有响应类型的 button";
                break;
            }
            case "65309" :{
                logger.error("-----errcode：" + errcode + "个性化菜单开关处于关闭状态-----");
                errMsg = "个性化菜单开关处于关闭状态";
                break;
            }
            case "65310" :{
                logger.error("-----errcode：" + errcode + "填写了省份或城市信息，国家信息不能为空-----");
                errMsg = "填写了省份或城市信息，国家信息不能为空";
                break;
            }
            case "65311" :{
                logger.error("-----errcode：" + errcode + "填写了城市信息，省份信息不能为空-----");
                errMsg = "填写了城市信息，省份信息不能为空";
                break;
            }
            case "65312" :{
                logger.error("-----errcode：" + errcode + "不合法的国家信息-----");
                errMsg = "不合法的国家信息";
                break;
            }
            case "65313" :{
                logger.error("-----errcode：" + errcode + "不合法的省份信息-----");
                errMsg = "不合法的省份信息";
                break;
            }
            case "65314" :{
                logger.error("-----errcode：" + errcode + "不合法的城市信息-----");
                errMsg = "不合法的城市信息";
                break;
            }
            case "65316" :{
                logger.error("-----errcode：" + errcode + "该公众号的菜单设置了过多的域名外跳（最多跳转到 3 个域名的链接）-----");
                errMsg = "该公众号的菜单设置了过多的域名外跳（最多跳转到 3 个域名的链接）";
                break;
            }
            case "65317" :{
                logger.error("-----errcode：" + errcode + "不合法的 URL-----");
                errMsg = "不合法的 URL";
                break;
            }
            case "87009" :{
                logger.error("-----errcode：" + errcode + "无效的签名-----");
                errMsg = "无效的签名";
                break;
            }
            case "9001001" :{
                logger.error("-----errcode：" + errcode + "POST 数据参数不合法-----");
                errMsg = "POST 数据参数不合法";
                break;
            }
            case "9001002" :{
                logger.error("-----errcode：" + errcode + "远端服务不可用-----");
                errMsg = "远端服务不可用";
                break;
            }
            case "9001003" :{
                logger.error("-----errcode：" + errcode + "Ticket 不合法-----");
                errMsg = "Ticket 不合法";
                break;
            }
            case "9001004" :{
                logger.error("-----errcode：" + errcode + "获取摇周边用户信息失败-----");
                errMsg = "获取摇周边用户信息失败";
                break;
            }
            case "9001005" :{
                logger.error("-----errcode：" + errcode + "获取商户信息失败-----");
                errMsg = "获取商户信息失败";
                break;
            }
            case "9001006" :{
                logger.error("-----errcode：" + errcode + "获取 OpenID 失败-----");
                errMsg = "获取 OpenID 失败";
                break;
            }
            case "9001007" :{
                logger.error("-----errcode：" + errcode + "上传文件缺失-----");
                errMsg = "上传文件缺失";
                break;
            }
            case "9001008" :{
                logger.error("-----errcode：" + errcode + "上传素材的文件类型不合法-----");
                errMsg = "上传素材的文件类型不合法";
                break;
            }
            case "9001009" :{
                logger.error("-----errcode：" + errcode + "上传素材的文件尺寸不合法-----");
                errMsg = "上传素材的文件尺寸不合法";
                break;
            }
            case "9001010" :{
                logger.error("-----errcode：" + errcode + "上传失败-----");
                errMsg = "上传失败";
                break;
            }
            case "9001020" :{
                logger.error("-----errcode：" + errcode + "帐号不合法-----");
                errMsg = "帐号不合法";
                break;
            }
            case "9001021" :{
                logger.error("-----errcode：" + errcode + "已有设备激活率低于 50% ，不能新增设备-----");
                errMsg = "已有设备激活率低于 50% ，不能新增设备";
                break;
            }
            case "9001022" :{
                logger.error("-----errcode：" + errcode + "设备申请数不合法，必须为大于 0 的数字-----");
                errMsg = "设备申请数不合法，必须为大于 0 的数字";
                break;
            }
            case "9001023" :{
                logger.error("-----errcode：" + errcode + "已存在审核中的设备 ID 申请-----");
                errMsg = "已存在审核中的设备 ID 申请";
                break;
            }
            case "9001024" :{
                logger.error("-----errcode：" + errcode + "一次查询设备 ID 数量不能超过 50-----");
                errMsg = "一次查询设备 ID 数量不能超过 50";
                break;
            }
            case "9001025" :{
                logger.error("-----errcode：" + errcode + "设备 ID 不合法-----");
                errMsg = "设备 ID 不合法";
                break;
            }
            case "9001026" :{
                logger.error("-----errcode：" + errcode + "页面 ID 不合法-----");
                errMsg = "页面 ID 不合法";
                break;
            }
            case "9001027" :{
                logger.error("-----errcode：" + errcode + "页面参数不合法-----");
                errMsg = "页面参数不合法";
                break;
            }
            case "9001028" :{
                logger.error("-----errcode：" + errcode + "一次删除页面 ID 数量不能超过 10-----");
                errMsg = "一次删除页面 ID 数量不能超过 10";
                break;
            }
            case "9001029" :{
                logger.error("-----errcode：" + errcode + "页面已应用在设备中，请先解除应用关系再删除-----");
                errMsg = "页面已应用在设备中，请先解除应用关系再删除";
                break;
            }
            case "9001030" :{
                logger.error("-----errcode：" + errcode + "一次查询页面 ID 数量不能超过 50-----");
                errMsg = "一次查询页面 ID 数量不能超过 50";
                break;
            }
            case "9001031" :{
                logger.error("-----errcode：" + errcode + "时间区间不合法-----");
                errMsg = "时间区间不合法";
                break;
            }
            case "9001032" :{
                logger.error("-----errcode：" + errcode + "保存设备与页面的绑定关系参数错误-----");
                errMsg = "保存设备与页面的绑定关系参数错误";
                break;
            }
            case "9001033" :{
                logger.error("-----errcode：" + errcode + "门店 ID 不合法-----");
                errMsg = "门店 ID 不合法";
                break;
            }
            case "9001034" :{
                logger.error("-----errcode：" + errcode + "设备备注信息过长-----");
                errMsg = "设备备注信息过长";
                break;
            }
            case "9001035" :{
                logger.error("-----errcode：" + errcode + "设备申请参数不合法-----");
                errMsg = "设备申请参数不合法";
                break;
            }
            case "9001036" :{
                logger.error("-----errcode：" + errcode + "查询起始值 begin 不合法-----");
                errMsg = "查询起始值 begin 不合法";
                break;
            }
            default:{
                logger.error("-----errcode：" + errcode + "未知错误码-----");
                errMsg = "未知错误码";
                break;
            }
        }
        return errMsg;
    }

}
