package com.icec.controller;

import com.icec.service.impl.CoreService;
import com.icec.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信个人公众号接口
 * Created by jqChu on 2017/6/21.
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    @Value("${token}")
    private String TOKEN;

    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatController.class);

    @Resource
    private CoreService coreService;

    /**
     * 接收微信信息
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    @ResponseBody
    public String connectWeChat(HttpServletRequest request, HttpServletResponse response) {
        String respMessage = "异常消息！";
        try {
            respMessage = coreService.handleMessage(request);
            LOGGER.info("请求成功");
            LOGGER.info("回复信息：\n" + respMessage);
        } catch (Exception e) {
            LOGGER.error("解析微信信息失败");
        }
        return respMessage;
    }


    /**
     * 微信签名验证
     * @param request
     * @return
     */
    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    @ResponseBody
    public String connectWeChat(HttpServletRequest request) {
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");// 随机数
        String echostr = request.getParameter("echostr");//随机字符串
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(TOKEN, signature, timestamp, nonce)) {
            LOGGER.info("成功连接到微信服务器");
            return echostr;
        }
        LOGGER.error("签名验证失败！");
        return null;
    }


}
