package com.hewuqi.miniapp.baidu.service;

import com.hewuqi.miniapp.baidu.model.OcrToken;

import java.util.List;
import java.util.Map;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/7/15 13:39
 */
public interface BaiduService {
    OcrToken generateOcrToken();
    OcrToken getOcrToken();
    List<Map> getWordResult(String imgUrl);
}
