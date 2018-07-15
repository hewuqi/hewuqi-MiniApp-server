package com.hewuqi.miniapp.face.controller;

import com.hewuqi.miniapp.face.service.CompareService;
import com.hewuqi.miniapp.face.service.QiNiuStorageService;
import com.hewuqi.miniapp.face.service.SignService;
import com.hewuqi.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/5/30 21:18
 */
@RestController
@RequestMapping("/compare")
public class CompareController {
    @Autowired
    private SignService signService;
    @Autowired
    private QiNiuStorageService qiNiuStorageService;
    @Autowired
    private CompareService compareService;

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

    @RequestMapping("/getCompareResult")
    public BaseResponse getCompareResult(@RequestBody Map<String,String> params) {
        String urlA = params.get("urlA");
        String urlB = params.get("urlB");
        String result = compareService.getCompareResult(urlA, urlB);
        Map<String, String> resp = new HashMap<>();
        if (result != null) {
            resp.put("similarity", result + "%");
        }else {
            resp.putIfAbsent("similarity", "比对失败");
        }
        return new BaseResponse(resp);
    }
}
