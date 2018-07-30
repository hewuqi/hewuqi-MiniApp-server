package com.hewuqi.miniapp.face.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.hewuqi.miniapp.face.service.CompareService;
import com.hewuqi.miniapp.face.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/5/30 21:06
 */
@Slf4j
@Service
public class CompareServiceImpl implements CompareService{

    String url = "http://recognition.image.myqcloud.com/face/compare";

    @Autowired
    private SignService signService;

    @Override
    public String getCompareResult(String urlA, String urlB) {
        String result = null;
        String url = "http://recognition.image.myqcloud.com/face/compare";
        Header[] headers = HttpHeader.custom()
                .authorization("Bearer " + signService.generateSign())
                .contentType("application/json").build();
        try{
            Map<String, Object> params = new HashMap<>();
            params.put("appid", "1251925447");
            params.put("urlA", "http://" + urlA);
            params.put("urlB", "http://" + urlB);
            String json = JSON.toJSONString(params);
            String resp = HttpClientUtil.post(HttpConfig.custom().headers(headers).url(url).json(json));
            JSONObject respObj = JSONObject.parseObject(resp);
            result = respObj.getJSONObject("data").getString("similarity");
        }catch (Exception e) {
            log.error(String.format("人脸比对失败:urlA %s urlB %s", urlA, urlB));
        }
        return result;
    }
}
