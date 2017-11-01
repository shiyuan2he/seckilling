package com.hsy.seckilling.dto;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path seckilling/com.hsy.seckilling.dto
 * @date 2017/10/31 09:18
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class Exposer {

    private boolean exposed ;
    private String md5 ; // 加密措施
    private long seckillingId ;
    private long now ;
    private long start ;
    private long end ;

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckillingId() {
        return seckillingId;
    }

    public void setSeckillingId(long seckillingId) {
        this.seckillingId = seckillingId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public Exposer(boolean exposed, long seckillingId) {
        this.exposed = exposed;
        this.seckillingId = seckillingId;
    }

    public Exposer(boolean exposed, long seckillingId, long now, long start, long end) {
        this.exposed = exposed;
        this.seckillingId = seckillingId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckillingId=" + seckillingId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public Exposer(boolean exposed, String md5, long seckillingId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillingId = seckillingId;
    }
}
