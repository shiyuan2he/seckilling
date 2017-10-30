package com.hsy.seckilling.dao;

import com.hsy.seckilling.entity.TSeckillingItem;

import java.util.Date;
import java.util.List;

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
public interface TSeckillingItemMapper {
    /**
     * @description <p></p>
     * @param seckillId 根据id获取秒删商品
     * @return 选择的秒杀商品对象
     * @author heshiyuan 
     * @date 2017/10/30 17:38
     */
    TSeckillingItem getById(long seckillId) ;
    /**
     * @description <p>获取秒杀商品列表</p>
     * @param offset 偏移量
     * @param limit 分页
     * @return 秒杀商品列表集合
     * @author heshiyuan
     * @date 2017/10/30 17:40
     */
    List<TSeckillingItem> getAll(int offset, int limit) ;
    /**
     * @description <p>减库存</p>
     * @param seckillingId 减库存的商品ID
     * @param killTime 秒杀时间
     * @return 减少的行数
     * @author heshiyuan
     * @date 2017/10/30 17:42
     */
    int reduceNumber(long seckillingId,Date killTime) ;
}
