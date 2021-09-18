package com.macro.cloud.service;

import com.macro.cloud.pojo.CommonResult;
import com.macro.cloud.pojo.User;

import java.util.List;

/**
 * @Package: com.macro.cloud.service
 * @Description:
 * @Author: LuDeSong
 * @Date: 2021-9-17 10:05
 */

public interface UserService {
    CommonResult create(User user);

    CommonResult getUser(Long id);

    CommonResult update(User user);

    CommonResult delete(Long id);

    CommonResult getByUsername(String username);

}
