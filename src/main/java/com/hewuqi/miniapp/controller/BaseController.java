package com.hewuqi.miniapp.controller;

import com.hewuqi.miniapp.service.QiNiuStorageService;
import com.hewuqi.miniapp.service.SignService;
import com.hewuqi.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/5/13 17:00
 */
@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private SignService signService;
    @Autowired
    private QiNiuStorageService qiNiuStorageService;

    @RequestMapping("/getSign")
    public BaseResponse getSign () {
        return new BaseResponse(signService.generateSign());
    }

    @RequestMapping("/getUpToken")
    public Map<String, String> getUpToken() {
        String upToken = qiNiuStorageService.genUpToken();
        Map<String, String> map = new HashMap<>();
        map.put("uptoken", upToken);

        return map;
    }
}
