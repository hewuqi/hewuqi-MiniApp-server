package com.hewuqi.miniapp.service.impl;

import com.hewuqi.miniapp.service.SignService;
import com.hewuqi.miniapp.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/5/13 16:54
 */
@Slf4j
@Service
public class SignServiceImpl implements SignService{

    @Value("${wechat.miniapp.appId}")
    private long appId;
    @Value("${wechat.miniapp.secretId}")
    private String secretId;
    @Value("${wechat.miniapp.secretKey}")
    private String secretKey;
    @Value("${wechat.miniapp.bucketName}")
    private String bucketName;

    @Override
    public String generateSign() {
        long expired = 1000L;
        try{
            return SignUtil.appSign(appId, secretId, secretKey, bucketName, expired);
        } catch (Exception e) {
            log.error("生成签名错误");
        }
        return "";
    }
}
