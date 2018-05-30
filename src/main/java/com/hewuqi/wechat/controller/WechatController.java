package com.hewuqi.wechat.controller;

import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;
import com.hewuqi.wechat.util.IdentifyingCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/4/14 11:54
 */
@Slf4j
@RestController
@RequestMapping("/wechat")
public class WechatController extends WeixinControllerSupport {
    String token = "hewuqi";

    @Override
    protected String getToken() {
        return token;
    }

    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();
        if("验证码".equals(content)) {
            String identifyCode = IdentifyingCodeUtil.generateIdentifyingCode();
            return new TextMsg(identifyCode);
        }
        return new TextMsg("未能识别的指令，回复“验证码”获取最新验证码");
    }
}
