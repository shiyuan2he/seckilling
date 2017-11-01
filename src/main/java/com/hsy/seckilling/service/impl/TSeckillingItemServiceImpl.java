package com.hsy.seckilling.service.impl;

import com.hsy.seckilling.dao.TSeckillingItemMapper;
import com.hsy.seckilling.dao.TSeckillingSuccessMapper;
import com.hsy.seckilling.dto.Exposer;
import com.hsy.seckilling.dto.SecKillingExecute;
import com.hsy.seckilling.entity.TSeckillingItem;
import com.hsy.seckilling.entity.TSeckillingSuccess;
import com.hsy.seckilling.enums.SeckillingStateEnum;
import com.hsy.seckilling.exception.RepeatSeckillingException;
import com.hsy.seckilling.exception.SeckillingCloseException;
import com.hsy.seckilling.exception.SeckillingException;
import com.hsy.seckilling.service.ITSeckillingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path seckilling/com.hsy.seckilling.service.impl
 * @date 2017/10/31 09:30
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service("seckillingItemService")
public class TSeckillingItemServiceImpl implements ITSeckillingItemService {
    private static final String slat = "ffsafsdfjlpf;ahdsofnadfpsdfwqf092r]idf\\afas" ; //盐值
    @Autowired
    TSeckillingItemMapper tSeckillingItemMapper ;
    @Autowired
    TSeckillingSuccessMapper tSeckillingSuccessMapper ;
    @Override
    public List<TSeckillingItem> getSeckillItemList() {
        return tSeckillingItemMapper.getAll(0,4);
    }

    @Override
    public TSeckillingItem getById(long seckillingId) {
        return tSeckillingItemMapper.getById(seckillingId);
    }

    @Override
    public Exposer exportSeckillingUrl(long seckillingId) {
        TSeckillingItem tSeckillingItem = tSeckillingItemMapper.getById(seckillingId) ;
        if(null == tSeckillingItem) return new Exposer(false,seckillingId);
        long nowDate = Calendar.getInstance().getTime().getTime();
        if(nowDate<tSeckillingItem.getStartTime().getTime() || nowDate>tSeckillingItem.getEndTime().getTime()){
            return new Exposer(false,seckillingId,nowDate,
                    tSeckillingItem.getStartTime().getTime(),tSeckillingItem.getEndTime().getTime()) ;
        }
        return new Exposer(true,getMd5(seckillingId),seckillingId);
    }
    /**
     * @description <p>使用注解控制事务的优点
     *  1、开发团队达成一致约定，明确标注事务方法的编程风格
     * </p>
     */
    @Transactional
    @Override
    public SecKillingExecute executeSeckilling(long seckillingId, long userPhone, String md5) throws RepeatSeckillingException, SeckillingCloseException {
        if(null==md5 || !md5.equals(getMd5(seckillingId))) throw new SeckillingException("seckilling data was wrong");
        //   秒杀： 减库存+记录秒杀行为
        Date date = Calendar.getInstance().getTime() ;
        int updateCount = tSeckillingItemMapper.reduceNumber(seckillingId,date);
        if(updateCount > 0){
            TSeckillingSuccess seckillingSuccess = new TSeckillingSuccess() ;
            seckillingSuccess.setUserPhone(userPhone);
            seckillingSuccess.setSeckillingItemId(seckillingId);
            seckillingSuccess.setState((byte) 0);
            seckillingSuccess.setCreateTime(date);
            int insertCount = tSeckillingSuccessMapper.insertSeckillingSuccess(seckillingSuccess) ;
            if(insertCount>0){
                TSeckillingSuccess seckillingSuccess1 = tSeckillingSuccessMapper.getSeckillingSuccessWithSeckillingItem(seckillingId,userPhone) ;
                return new SecKillingExecute(seckillingId,1,SeckillingStateEnum.SUCCESS.getStateInfo(),seckillingSuccess1) ;
            }else{
                throw new RepeatSeckillingException(SeckillingStateEnum.REPEATE_KILL.getStateInfo()) ;
            }
        }else{
            throw new SeckillingCloseException(SeckillingStateEnum.END.getStateInfo());
        }
    }
    private String getMd5(long seckillingid){
        String base = seckillingid + "" + slat ;
        return DigestUtils.md5DigestAsHex(base.getBytes()) ;
    }
}
