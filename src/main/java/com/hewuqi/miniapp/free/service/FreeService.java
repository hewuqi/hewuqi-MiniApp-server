package com.hewuqi.miniapp.free.service;

import com.hewuqi.miniapp.free.dto.BankCardDto;
import com.hewuqi.miniapp.free.dto.CellDto;
import com.hewuqi.miniapp.free.dto.IpDto;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/2 21:47
 */
public interface FreeService {
    /**
     * IP查询
     * @param ip
     * @return
     */
    IpDto getIpDto(String ip);

    /**
     * 基站查询
     */
    CellDto getCellDto(String mnc, String lac, String ci);

    BankCardDto getBankCardDto(String cardNo);
}
