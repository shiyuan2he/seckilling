package com.hsy.seckilling.service;

import com.hsy.seckilling.dto.Exposer;
import com.hsy.seckilling.dto.SecKillingExecute;
import com.hsy.seckilling.entity.TSeckillingItem;
import com.hsy.seckilling.exception.RepeatSeckillingException;
import com.hsy.seckilling.exception.SeckillingCloseException;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p>站在"使用者"角度，设计接口</p>
 * @path seckilling/com.hsy.seckilling.service
 * @date 2017/10/31 09:12
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface ITSeckillingItemService {
    /**
     * @description <p>获取所有秒杀商品</p>
     * @return 秒杀商品集合
     * @author heshiyuan
     * @date 2017/10/31 09:14
     */
    List<TSeckillingItem> getSeckillItemList() ;
    /**
     * @description <p>获取单个秒杀商品</p>
     * @param seckillingId 秒杀商品主键
     * @return 单个秒杀商品对象
     * @author heshiyuan
     * @date 2017/10/31 09:13
     */
    TSeckillingItem getById(long seckillingId) ;
    /**
     * @description <p>秒杀开始，输出秒杀接口地址，否则输出秒杀开启时间和结束时间</p>
     * @param
     * @return
     * @author heshiyuan
     * @date 2017/10/31 09:17
     */
    Exposer exportSeckillingUrl(long seckillingId);
    /**
     * @description <p>执行秒杀</p>
     * @param seckillingId
     * @param userPhone
     * @param md5
     * @return
     * @author heshiyuan
     * @date 2017/10/31 09:21
     */
    SecKillingExecute executeSeckilling(long seckillingId, long userPhone, String md5)
            throws RepeatSeckillingException,SeckillingCloseException;
}
