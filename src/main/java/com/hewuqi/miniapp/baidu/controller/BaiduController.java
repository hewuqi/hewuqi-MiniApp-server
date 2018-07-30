package com.hewuqi.miniapp.baidu.controller;

import com.hewuqi.miniapp.baidu.service.BaiduService;
import com.hewuqi.utils.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/7/15 13:38
 */
@Slf4j
@RestController
@RequestMapping("/baidu")
public class BaiduController {
    @Autowired
    private BaiduService baiduService;

    //@RequestMapping("/getOcrToken")
    public BaseResponse getOcrToken() {
        log.error("=====================百度登陆=============");
        return new BaseResponse(baiduService.getOcrToken());
    }

    @RequestMapping("/getOcrResult")
    public BaseResponse getOcrResult(@RequestBody Map<String,String> params) {
        String imgUrl = params.get("imgUrl");
        return new BaseResponse(baiduService.getWordResult(imgUrl));
    }
}
