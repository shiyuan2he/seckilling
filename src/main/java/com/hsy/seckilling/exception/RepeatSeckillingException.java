package com.hsy.seckilling.exception;

/**
 * @author heshiyuan
 * @description <p>重复秒杀异常-运行期异常</p>
 * @path seckilling/com.hsy.seckilling.exception
 * @date 2017/10/31 09:24
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class RepeatSeckillingException extends RuntimeException{

    public RepeatSeckillingException(String message) {
        super(message);
    }

    public RepeatSeckillingException(String message, Throwable cause) {
        super(message, cause);
    }
}
