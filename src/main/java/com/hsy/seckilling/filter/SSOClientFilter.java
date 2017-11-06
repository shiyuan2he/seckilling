package com.hsy.seckilling.filter;

import com.hsy.bean.dto.ResponseBodyBean;
import com.hsy.bean.vo.SessionBean;
import com.hsy.java.base.string.StringHelper;
import com.hsy.java.enums.BusinessEnum;
import com.hsy.java.enums.SsoEnum;
import com.hsy.java.exception.service.BusinessException;
import com.hsy.java.httpclient.utils.HttpClientUtils;
import com.hsy.java.util.json.JsonHelper;
import com.hsy.java.util.json.JsonToBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path sso/com.hsy.sso.blog.filter
 * @date 19/10/2017 9:39 AM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@WebFilter("/*")
public class SSOClientFilter implements Filter {
    private static final Logger _logger = LoggerFactory.getLogger(SSOClientFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    /**
     * @description <p>
     *     1、静态资源文件放行
     *     2、从本服务session中获取用户信息
     *     3、从cookie中获取通票
     *     4、用验证通票跟此人匹配关系
     * </p>
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         _logger.info("【秒杀系统检票处】进入到秒杀系统拦截器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1、静态资源文件放行
        if(request.getRequestURL().toString().contains("resources")||request.getRequestURL().toString().contains("view")){
            filterChain.doFilter(request, response);
        }else{
            // 2、从本服务session中获取用户信息==单票
            SessionBean sessionBean = (SessionBean) request.getSession().getAttribute(SsoEnum.SSO_KEY_USER_SESSION.getCode()) ;
            if(sessionBean==null||(null!=sessionBean&&null==sessionBean.getTicket())){
                // 3、从cookie中获取通票
                String ticket = "";
                Cookie[] cookies = request.getCookies();
                if(null==cookies||cookies.length<=0){
                    filterChain.doFilter(request, response);
                    return ;
                }
                for (Cookie cookie : cookies) {
                    _logger.info("【秒杀系统检票处】cookie信息：name={},value={}", cookie.getName(), cookie.getValue());
                    if (SsoEnum.SSO_KEY_TICKET_COOKIE.getCode().equals(cookie.getName())) {
                        ticket = cookie.getValue();
                    }
                }
                // 4、用验证通票跟此人匹配关系
                if(StringHelper.isNotNullOrEmpty(ticket)) {
                    _logger.info("【秒杀系统检票处】此人有通票{}",ticket);
                    // 用通票获取用户信息
                    _logger.info("【秒杀系统检票处】将用户:{}手中通票:{}去sso服务中获取用户信息。",ticket);
                    String url = "http://localhost:8080/sso/ticket/"+ticket ;
                    _logger.info("【秒杀系统检票处】http url={}",url);
                    try{
                        String sessionInfoJson = HttpClientUtils.sendHttpGet(url);
                        SessionBean ssoSession = JsonToBeanUtil.responseJsonToBean(sessionInfoJson,SessionBean.class) ;
                        if(null!=ssoSession&&null!=ssoSession.getTicket()) {
                            _logger.info("【秒杀系统检票处】用户:{}手中通票{}跟sso服务验票大厅中的票匹配，允许通过",ssoSession.getMobile(), ticket);
                            request.getSession().setAttribute(SsoEnum.SSO_KEY_USER_SESSION.getCode(),ssoSession);
                            filterChain.doFilter(request, response);
                            return ;
                        }
                    }catch (Exception e){
                        _logger.error(e.getMessage(),e);
                    }
                }
            }else{
                _logger.info("【秒杀系统检票处】用户:{}拥有单票，已登陆，允许通过");
                filterChain.doFilter(request, response);
                return ;
            }
            _logger.info("【秒杀系统检票处】单票，通票均无效，请重新登陆，进行购票");
            // 没有sessionInfo也没有ticket，重新登录
            request.getRequestDispatcher("/WEB-INF/jsp/sso/login.jsp").forward(request,response);
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
