package com.mars.mars_zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.mars.mars_zuul.constant.FilterTypeEnum;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Map;

/**
 * Created by wuketao on 2018/5/18.
 */
@Slf4j
@Component
public class LogFilter extends ZuulFilter {
    /**
     * 过滤器优先级
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 过滤器类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterTypeEnum.PRE.getValue();
    }

    /**
     * 过滤器的执行方法
     *
     * @return
     */
    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            StringBuilder builder = new StringBuilder();
            HttpServletRequest request = ctx.getRequest();
            //记录请求客户端地址
            builder.append("remoteaddr:" + request.getRemoteAddr());
            // 记录访问地址
            builder.append(" uri:" + request.getRequestURI());
            // 获取访问参数
            if (request.getMethod().toUpperCase().equals("GET")) {
                //get请求
                Map<String, String[]> parameterMap = request.getParameterMap();
                builder.append(" " + JSONObject.toJSONString(parameterMap));
            } else if (request.getMethod().toUpperCase().equals("POST")) {
                //post请求
                String line = null;
                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null)
                    builder.append(" " + line);
            }
            log.info(builder.toString());
        } catch (Exception e) {
            log.error("{}", e);
        }
//        String token = request.getParameter("token");
//        if (token == null || token.isEmpty()) {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            ctx.setResponseBody("token is empty");
//        }
        return null;
    }
}
