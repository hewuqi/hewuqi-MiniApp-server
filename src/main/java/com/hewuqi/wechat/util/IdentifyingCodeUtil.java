package com.hewuqi.wechat.util;

import com.hewuqi.wechat.constant.CommonConstant;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/4/14 19:03
 */
public class IdentifyingCodeUtil {
    static String salt = CommonConstant.salt;

    public static String generateIdentifyingCode() {
        String result = "";

        //验证码生成原则：获取天数，加盐值，MD5加密
        long timestamp = new Date().getTime();
        long day = timestamp / 24 / 60 / 60 / 1000; //从1970年1月1日到当前时间的总天数
        System.out.println(timestamp);
        String originalString = day + salt; // 原始字符串 = day + 盐值
        String md5String = DigestUtils.md5DigestAsHex(originalString.getBytes());
        result = md5String.substring(8, 12); //验证码取8到11位共四位

        //System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        generateIdentifyingCode();
    }
}
