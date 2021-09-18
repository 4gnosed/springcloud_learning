package com.macro.cloud.service.impl;

import com.macro.cloud.pojo.CommonResult;
import com.macro.cloud.pojo.User;
import com.macro.cloud.service.UserService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Package: com.macro.cloud.service.impl
 * @Description: 远程调用user-service服务，演示Hystrix服务降级
 * @Author: LuDeSong
 * @Date: 2021-9-17 10:06
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Value("${remote-url.user-service}")
    private String userServiceUrl;
    
    @Autowired
    RestTemplate restTemplate;

    @Override
    public CommonResult create(User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/create", user, CommonResult.class);
    }

    /**
     * 为缓存生成key的方法
     */
    private String getCacheKey(Long id) {
        return String.valueOf(id);
    }

    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "getDefaultUser",
            ignoreExceptions = NullPointerException.class,
            commandKey = "getUser",
            groupKey = "getUserGroup",
            threadPoolKey = "getUserThreadPool")
    @Override
    public CommonResult getUser(Long id) {
        log.info("getUser by id："+id);
        if(11==id){
            throw new NullPointerException();
        }else if(12==id){
            throw new IndexOutOfBoundsException();
        }
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    public CommonResult getDefaultUser(Long id) {
        User defaultUser = User.builder().id(-1L).username("defaultname").password("123456").build();
        return new CommonResult(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", user, CommonResult.class);
    }

    @CacheRemove(commandKey = "getUser", cacheKeyMethod = "getCacheKey")
    @HystrixCommand
    @Override
    public CommonResult delete(Long id) {
        log.info("delete by id："+id);
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, CommonResult.class, id);
    }

    @Override
    public CommonResult getByUsername(String username) {
        return restTemplate.getForObject(userServiceUrl + "/user/getByUsername?username={1}", CommonResult.class, username);
    }


}
