package com.hewuqi.miniapp.free.dto;

import lombok.Data;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/5 12:37
 */
@Data
public class WhoisDto {
    private String updateTime;
    private String address;
    private String num;
    private String type;
    private String comName;
    private String domain;
    private String sysName;
}

//"showapi_res_body":{"obj":{"update_time":"2015-08-19","address":"","num":"滇ICP备14007554号-1","type":"企业","com_name":"昆明秀派科技有限公司","domain":"showapi.com","sys_name":"易源接口总线"}}