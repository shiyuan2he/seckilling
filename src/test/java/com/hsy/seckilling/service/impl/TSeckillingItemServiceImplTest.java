package com.hsy.seckilling.service.impl;

import com.hsy.seckilling.service.ITSeckillingItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path seckilling/com.hsy.seckilling.service.impl
 * @date 2017/10/31 10:17
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class TSeckillingItemServiceImplTest {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    @Autowired
    ITSeckillingItemService seckillingItemService ;
    @Test
    public void getSeckillItemList() throws Exception {
        _logger.info("getSeckillItemList={}",seckillingItemService.getSeckillItemList());
    }

    @Test
    public void getById() throws Exception {
        _logger.info("getById={}",seckillingItemService.getById(10000));
    }

    @Test
    public void exportSeckillingUrl() throws Exception {
        _logger.info("exportSeckillingUrl={}",seckillingItemService.exportSeckillingUrl(10000));
    }

    @Test
    public void executeSeckilling() throws Exception {
        _logger.info("executeSeckilling={}",
                seckillingItemService.executeSeckilling(10000,15910854444l,"3fc5ca014e34bf344f00c24ad124d318"));
    }

}