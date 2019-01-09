package com.mars.mars_zuul.constant;

/**
 * Created by wuketao on 2018/5/18.
 */
public enum FilterTypeEnum {
    /**
     * 前置过滤器
     */
    PRE("pre"),
    /**
     * 环绕过滤器
     */
    ROUTE("route"),
    /**
     * 后置过滤器
     */
    POST("post"),
    /**
     * 错误过滤器
     */
    ERROR("error");

    /**
     * 过滤器类型
     */
    private String value;

    /**
     * 私有构造函数
     *
     * @param value
     */
    private FilterTypeEnum(String value) {
        this.value = value;
    }

    /**
     * 获取过滤器类型值
     * @return
     */
    public String getValue(){
        return this.value;
    }
}
