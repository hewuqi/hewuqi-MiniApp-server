package com.hewuqi.miniapp.free.controller;

import com.hewuqi.miniapp.free.dto.*;
import com.hewuqi.miniapp.free.service.FreeService;
import com.hewuqi.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/2 23:15
 */
@RestController
@RequestMapping("/freeController")
public class FreeController {
    @Autowired
    private FreeService freeService;

    @RequestMapping("/ipSearch")
    private BaseResponse ipSearch(String ip) {
        IpDto resp = freeService.getIpDto(ip);
        return new BaseResponse(resp);
    }

    @RequestMapping("/cellSearch")
    private BaseResponse cellSearch(String mnc, String lac, String ci) {
        CellDto resp = freeService.getCellDto(mnc, lac, ci);
        return new BaseResponse(resp);
    }

    @RequestMapping("/bankCardSearch")
    private BaseResponse bankCardSearch(String cardNo) {
        BankCardDto cardDto = freeService.getBankCardDto(cardNo);
        return new BaseResponse(cardDto);
    }

    @RequestMapping("/macSearch")
    private BaseResponse macSearch(String mac) {
        MacDto macDto = freeService.getMacDto(mac);
        return new BaseResponse(macDto);
    }

    @RequestMapping("/whoisSearch")
    private BaseResponse whoisSearch(String address) {
        WhoisDto whoisDto = freeService.getWhoisDto(address);
        return new BaseResponse(whoisDto);
    }
}
