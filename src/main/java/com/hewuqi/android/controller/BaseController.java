package com.hewuqi.android.controller;

import com.hewuqi.android.param.UserInfo;
import com.hewuqi.android.service.BaseService;
import com.hewuqi.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/10 16:16
 */
@RestController
@RequestMapping("/android")
public class BaseController {
    @Autowired
    private BaseService baseService;

    @RequestMapping("/login")
    public BaseResponse login(@RequestBody UserInfo userInfo) {
        boolean resp = baseService.login(userInfo);
        return new BaseResponse(resp);
    }

    @RequestMapping("/regist")
    public BaseResponse regist(@RequestBody UserInfo userInfo) {
        boolean resp = baseService.regist(userInfo);
        return new BaseResponse(resp);
    }

}
