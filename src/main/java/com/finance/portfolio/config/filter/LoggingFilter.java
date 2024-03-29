package com.finance.portfolio.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UUID uniqueId = UUID.randomUUID();
        MDC.put("activityId", uniqueId.toString());
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(
                (HttpServletResponse) servletResponse
        );
        try {
            filterChain.doFilter(servletRequest, responseWrapper);
            responseWrapper.copyBodyToResponse();
        } finally {
            MDC.clear();
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
