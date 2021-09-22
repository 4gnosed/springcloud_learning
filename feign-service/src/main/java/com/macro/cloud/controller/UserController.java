package com.macro.cloud.controller;

import com.macro.cloud.pojo.CommonResult;
import com.macro.cloud.pojo.User;
import com.macro.cloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * @Package: com.macro.cloud.controller
 * @Description:
 * @Author: LuDeSong
 * @Date: 2021-9-17 9:56
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}