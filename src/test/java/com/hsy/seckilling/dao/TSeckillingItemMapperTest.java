package com.hsy.seckilling.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path seckilling/com.hsy.seckilling.dao
 * @date 2017/10/31 08:27
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TSeckillingItemMapperTest {
    private Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    TSeckillingItemMapper tSeckillingItemMapper ;
    @Test
    public void getById() throws Exception {
        _logger.info("getById={}",tSeckillingItemMapper.getById(10000l) );
    }

    @Test
    public void getAll() throws Exception {
        _logger.info("getAll={}",tSeckillingItemMapper.getAll(1,2) );
    }

    @Test
    public void reduceNumber() throws Exception {
        _logger.info("getAll={}",tSeckillingItemMapper.reduceNumber(10000l,new Date()));
    }

}