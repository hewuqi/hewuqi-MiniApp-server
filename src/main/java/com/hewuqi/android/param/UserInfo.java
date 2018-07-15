package com.hewuqi.android.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/10 16:55
 */
@Data
public class UserInfo {
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;

    private String email;
}
