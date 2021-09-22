package com.macro.cloud.service.fallback;

import com.macro.cloud.pojo.CommonResult;
import com.macro.cloud.pojo.User;
import com.macro.cloud.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Package: com.macro.cloud.service.impl
 * @Description:
 * @Author: LuDeSong
 * @Date: 2021-9-22 18:22
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public CommonResult create(User user) {
        return null;
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User user = User.builder().id(-11L).username("defaultname_").password("pwd").build();
        return new CommonResult<>(user);
    }

    @Override
    public CommonResult<List<User>> getUserByIds(List<Long> ids) {
        return null;
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        return null;
    }

    @Override
    public CommonResult update(User user) {
        return null;
    }

    @Override
    public CommonResult delete(Long id) {
        return null;
    }
}
