package com.hewuqi.miniapp.baidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.hewuqi.miniapp.baidu.model.OcrToken;
import com.hewuqi.miniapp.baidu.service.BaiduService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/7/15 13:40
 */
@Slf4j
@Service
public class BaiduServiceImpl implements BaiduService {

    @Value("${baidu.ocr.url}")
    private String ocrUrl;
    @Value("${baidu.ocr.ak}")
    private String ak;
    @Value("${baidu.ocr.sk}")
    private String sk;

    HCB hcb = null;

    @PostConstruct
    private void afterConstruct() throws Exception{
        hcb = HCB.custom().pool(10, 10).timeout(10000);
    }

    @Override
    public OcrToken generateOcrToken() {
        String url = String.format(ocrUrl, ak, sk);
        OcrToken ocrToken = new OcrToken();
        try {
            HttpConfig config = HttpConfig.custom().url(url);
            String resp = HttpClientUtil.get(config);
            JSONObject json = JSONObject.parseObject(resp);
            ocrToken = this.convertToOcrToken(json);
        }catch (Exception e) {
            log.error("generateOcrToken", e);
        }
        return ocrToken;
    }

    @Override
    public OcrToken getOcrToken() {
        return this.generateOcrToken();
    }

    @Override
    public List<Map> getWordResult(String imgUrl) {
        List<Map> result = new ArrayList<>();
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        OcrToken ocrToken = this.getOcrToken();
        String accessToken = ocrToken.getAccessToken();
        try{
            Map<String, Object> params = new HashMap<>();
            params.put("access_token", accessToken);
            params.put("url", "http://" + imgUrl);
            String json = JSON.toJSONString(params);
            String resp = HttpClientUtil.post(HttpConfig.custom().url(url).map(params).encoding("UTF-8"));
            JSONObject respObj = JSONObject.parseObject(resp);
            //result = JSONArray.parseArray(respObj.getJSONArray("words_result").toString().replace("\"", ""), String.class);
            result = JSONArray.parseArray(respObj.getJSONArray("words_result").toString(), Map.class);
        }catch (Exception e) {
            log.error(String.format("=====文字识别失败, imgUrl: %s=====", imgUrl));
        }
        return result;
    }

    //{"access_token":"24.c54ebd28a78c1421b4d8e2fccc8ce987.2592000.1535348826.282335-11537841",
    // "session_key":"9mzdWEUrIpyQ6D1tt5nr3IHkJcLNs+VLLEY1hKOvMmjUqS4f1sTqn4odfxo43u4mgEC+hoGAm\/K5qV5uTYh+ZjjwgLpF\/Q==",
    // "scope":"public vis-ocr_ocr brain_ocr_scope brain_ocr_general brain_ocr_general_basic brain_ocr_general_enhanced vis-ocr_business_license brain_ocr_webimage brain_all_scope brain_ocr_idcard brain_ocr_driving_license brain_ocr_vehicle_license vis-ocr_plate_number brain_solution brain_ocr_plate_number brain_ocr_accurate brain_ocr_accurate_basic brain_ocr_receipt brain_ocr_business_license brain_solution_iocr wise_adapt lebo_resource_base lightservice_public hetu_basic lightcms_map_poi kaidian_kaidian ApsMisTest_Test\u6743\u9650 vis-classify_flower lpq_\u5f00\u653e cop_helloScope ApsMis_fangdi_permission smartapp_snsapi_base iop_autocar",
    // "refresh_token":"25.2bd9a8d9608b98fe4d2effd457a82d07.315360000.1848116826.282335-11537841",
    // "session_secret":"becf13d0839cc7085be3d088ba7b572e",
    // "expires_in":2592000}

    private OcrToken convertToOcrToken(JSONObject json) {
        OcrToken ocrToken = new OcrToken();
        ocrToken.setAccessToken(json.getString("access_token"));
        ocrToken.setSessionKey(json.getString("session_key"));
        ocrToken.setScope(json.getString("scope"));
        ocrToken.setRefreshToken(json.getString("refresh_token"));
        ocrToken.setSessionSecret(json.getString("session_secret"));
        ocrToken.setExpiresIn(json.getString("expires_in"));

        return ocrToken;
    }
}
