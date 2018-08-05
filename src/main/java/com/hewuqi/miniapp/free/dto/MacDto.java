package com.hewuqi.miniapp.free.dto;

import lombok.Data;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/5 12:21
 */
@Data
public class MacDto {
    private String errcode;
    private String lat;
    private String lon;
    private String radius;
    private String address;
}