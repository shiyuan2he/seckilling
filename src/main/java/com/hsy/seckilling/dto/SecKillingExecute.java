package com.hsy.seckilling.dto;

import com.hsy.seckilling.entity.TSeckillingSuccess;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path seckilling/com.hsy.seckilling.dto
 * @date 2017/10/31 09:22
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SecKillingExecute {

    private long seckillingId ;
    private int state ;
    private String stateInfo ;
    private TSeckillingSuccess seckillingSuccess ;

    public SecKillingExecute(long seckillingId, int state, String stateInfo, TSeckillingSuccess seckillingSuccess) {
        this.seckillingId = seckillingId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.seckillingSuccess = seckillingSuccess;
    }

    public SecKillingExecute(long seckillingId, int state, String stateInfo) {
        this.seckillingId = seckillingId;
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public long getSeckillingId() {
        return seckillingId;
    }

    public void setSeckillingId(long seckillingId) {
        this.seckillingId = seckillingId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public TSeckillingSuccess getSeckillingSuccess() {
        return seckillingSuccess;
    }

    public void setSeckillingSuccess(TSeckillingSuccess seckillingSuccess) {
        this.seckillingSuccess = seckillingSuccess;
    }
}
