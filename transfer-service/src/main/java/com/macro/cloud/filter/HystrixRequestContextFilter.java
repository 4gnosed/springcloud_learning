package com.macro.cloud.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Package: com.macro.cloud.filter
 * @Description:在每个请求前后初始化和关闭HystrixRequestContext，解决Request caching不可用问题
 * @Author: LuDeSong
 * @Date: 2021-9-18 17:50
 */
@WebFilter(urlPatterns = "/*",asyncSupported = true)
@Component
public class HystrixRequestContextFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            context.close();
        }
    }
}
