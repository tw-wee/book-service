package com.wee.filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static java.lang.String.format;

public class RequestLoggingFilter implements Filter {

    private final Logger logger = Logger.getLogger(RequestLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Do nothing
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getQueryString() == null) {
            logger.info(format("%s,%s", request.getMethod(), request.getRequestURL()));
        } else {
            logger.info(format("%s,%s?%s", request.getMethod(), request.getRequestURL(), request.getQueryString()));
        }
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // Do nothing because
    }
}
