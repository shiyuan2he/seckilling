package com.hsy.seckilling.dto;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path seckilling/com.hsy.seckilling.dto
 * @date 2017/10/31 11:44
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SeckillingResult<T> {

    private boolean success ;
    private T data ;
    private String errorInfo ;

    public SeckillingResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillingResult(boolean success, String errorInfo) {
        this.success = success;
        this.errorInfo = errorInfo;
    }
}
