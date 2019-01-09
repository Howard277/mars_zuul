package com.mars.mars_zuul.filter;

import com.mars.mars_zuul.constant.FilterTypeEnum;
import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * Created by wuketao on 2018/5/18.
 */
@Component
public class AuthenticationFilter extends ZuulFilter {
    /**
     * 过滤器优先级
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
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
     * 授权过滤器方法
     *
     * @return
     */
    @Override
    public Object run() {
        // 1、读取URI控制信息，判断是否在权限控制内
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        String requestUri = request.getRequestURI();
        // 2、判断是否有session，session中的user是否有目标uri的访问权限。
//        HttpSession session = request.getSession();
//        if ((null == session)
//                || (null == session.getAttribute(AllConstant.USERKEY))) {
//            // 三种情况：1、没有session  2、session中没有user信息  3、访问的资源在受控资源列表中但不在授权列表中
//            // 返回401，未授权。
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            ctx.setResponseBody("没有访问权限！");
//        }
        return null;
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
}
