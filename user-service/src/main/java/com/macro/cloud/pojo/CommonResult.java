package com.macro.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: com.macro.cloud.pojo
 * @Description:
 * @Author: LuDeSong
 * @Date: 2021-9-17 10:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private T data;
    private String message;
    private Integer code;

    public CommonResult(String message, Integer code) {
        this(null, message, code);
    }
    public CommonResult(T data) {
        this(data, "操作成功", 200);
    }
}
