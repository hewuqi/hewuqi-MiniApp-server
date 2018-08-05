package com.hewuqi.miniapp.free.service;

import com.hewuqi.miniapp.free.dto.*;

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

    /**
     * 银行卡查询
     * @param cardNo
     * @return
     */
    BankCardDto getBankCardDto(String cardNo);

    /**
     * MAC地址查询
     * @param mac
     * @return
     */
    MacDto getMacDto(String mac);

    /**
     * 网站whois查询
     * @param address
     * @return
     */
    WhoisDto getWhoisDto(String address);
}
