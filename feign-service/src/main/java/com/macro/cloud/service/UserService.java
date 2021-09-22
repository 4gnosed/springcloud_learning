package com.macro.cloud.service;

import com.macro.cloud.constant.RemoteAppName;
import com.macro.cloud.pojo.CommonResult;
import com.macro.cloud.pojo.User;
import com.macro.cloud.service.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = RemoteAppName.USER_SERVICE, fallback = UserServiceFallback.class)
public interface UserService {
    @PostMapping("/user/create")
    public CommonResult create(@RequestBody User user);

    @GetMapping("/user/{id}")
    public CommonResult<User> getUser(@PathVariable Long id);

    @GetMapping("/user/getUserByIds")
    public CommonResult<List<User>> getUserByIds(@RequestParam List<Long> ids);

    @GetMapping("/user/getByUsername")
    public CommonResult<User> getByUsername(@RequestParam String username);

    @PostMapping("/user/update")
    public CommonResult update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    public CommonResult delete(@PathVariable Long id);
}
