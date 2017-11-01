package com.hsy.seckilling.dao;

import com.hsy.seckilling.entity.TSeckillingSuccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;

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
public class TSeckillingSuccessMapperTest {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass());
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    TSeckillingSuccessMapper tSeckillingSuccessMapper ;
    @Test
    public void insertSeckillingSuccess() throws Exception {
        TSeckillingSuccess seckillingSuccess = new TSeckillingSuccess() ;
        seckillingSuccess.setCreateTime(Calendar.getInstance().getTime());
        seckillingSuccess.setSeckillingItemId(10000l);
        seckillingSuccess.setUserPhone(15910868555l);
        seckillingSuccess.setState((byte) 0);
        tSeckillingSuccessMapper.insertSeckillingSuccess(seckillingSuccess) ;
    }

    @Test
    public void getSeckillingSuccessWithSeckillingItem() throws Exception {
        _logger.info("getSeckillingSuccessWithSeckillingItem={}",tSeckillingSuccessMapper.getSeckillingSuccessWithSeckillingItem(10000l,15910868555l));
    }

}