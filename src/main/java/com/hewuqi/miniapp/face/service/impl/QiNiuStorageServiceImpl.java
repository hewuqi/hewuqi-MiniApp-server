package com.hewuqi.miniapp.face.service.impl;

import com.hewuqi.miniapp.face.service.QiNiuStorageService;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/5/14 21:03
 */
@Service
public class QiNiuStorageServiceImpl implements QiNiuStorageService{

    @Value("${qiniu.accessKey}")
    private String accessKey;
    @Value("${qiniu.secretKey}")
    private String secretKey;
    @Value("${qiniu.bucket}")
    private String bucket;

    @Override
    public String genUpToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }


}
