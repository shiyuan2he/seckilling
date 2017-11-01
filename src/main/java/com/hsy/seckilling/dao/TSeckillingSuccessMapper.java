package com.hsy.seckilling.dao;

import com.hsy.seckilling.entity.TSeckillingSuccess;
import org.apache.ibatis.annotations.Param;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path seckilling/com.hsy.seckilling.dao
 * @date 2017/10/30 17:36
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface TSeckillingSuccessMapper {
    /**
     * @description <p></p>
     * @param seckillingSuccess 待插入的秒杀明细
     * @return 插入的行数
     * @author heshiyuan 
     * @date 2017/10/30 17:46
     */
    int insertSeckillingSuccess(TSeckillingSuccess seckillingSuccess);
    /**
     * @description <p>根据id获取商品秒杀明细并携带秒杀商品信息</p>
     * @param seckillingId 秒杀商品id
     * @return 秒杀商品明细
     * @author heshiyuan
     * @date 2017/10/30 18:39
     */
    TSeckillingSuccess getSeckillingSuccessWithSeckillingItem(@Param("seckillingId") long seckillingId, @Param("userPhone") long userPhone) ;
}
