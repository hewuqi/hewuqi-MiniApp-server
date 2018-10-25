package com.hewuqi.miniapp.baiduwenku.controller;


import com.hewuqi.miniapp.baiduwenku.service.WenkuDownloadService;
import com.hewuqi.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("wenku")
public class WenkuDownloadController {

    @Autowired
    private WenkuDownloadService wenkuDownloadService;

    @RequestMapping("src")
    public BaseResponse getResource(@RequestBody Map<String, String> params) {
        String src = params.get("src");
        wenkuDownloadService.downloadFile(src);

        return new BaseResponse("OK");
    }

}
