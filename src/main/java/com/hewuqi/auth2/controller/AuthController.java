package com.hewuqi.auth2.controller;

import com.alibaba.fastjson.JSONObject;
import com.hewuqi.auth2.service.AuthService;
import com.hewuqi.utils.BaseResponse;
import com.hewuqi.utils.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/5 18:43
 */
@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/regist")
    public BaseResponse regist(@RequestBody JSONObject params) {
        int result = authService.regist(params);

        Map<String, String> resp = new HashMap<>();
        return new BaseResponse(ErrorCodeEnum.getEnumByErrorCode(result), resp);

    }
}
