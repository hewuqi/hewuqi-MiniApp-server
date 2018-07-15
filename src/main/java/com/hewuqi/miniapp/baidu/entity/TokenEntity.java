package com.hewuqi.miniapp.baidu.entity;

import lombok.Data;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/7/15 13:41
 */
@Data
public class TokenEntity {
    private String access_token;
    private String session_key;
    private String scope;
    private String refresh_token;
    private String session_secret;
    private String expires_in;
}
