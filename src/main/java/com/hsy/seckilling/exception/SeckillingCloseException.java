package com.hsy.seckilling.exception;

/**
 * @author heshiyuan
 * @description <p>秒杀关闭异常</p>
 * @path seckilling/com.hsy.seckilling.exception
 * @date 2017/10/31 09:27
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SeckillingCloseException extends RuntimeException{
    public SeckillingCloseException(String message) {
        super(message);
    }

    public SeckillingCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
