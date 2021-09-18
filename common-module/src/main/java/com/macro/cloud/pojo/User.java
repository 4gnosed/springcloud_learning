package com.macro.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: com.macro.cloud.pojo
 * @Description:
 * @Author: LuDeSong
 * @Date: 2021-9-17 9:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String username;
    private String password;
}
