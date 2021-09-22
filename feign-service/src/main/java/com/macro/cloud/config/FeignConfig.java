package com.macro.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: com.macro.cloud.config
 * @Description: Feign打印最详细的Http请求日志信息
 * @Author: LuDeSong
 * @Date: 2021-9-22 18:28
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
