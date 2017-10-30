package com.hsy.seckilling.entity;

import java.util.Date;


public class TSeckillingSuccess{
	private Long seckillingItemId;
	private Long userPhone;
	private Byte state;
	private Date createTime;
	/**
	 * @description <p>一对多</p>
	 * @author heshiyuan
	 * @date 2017/10/30 18:38
	 */
	private TSeckillingItem seckillingItem ;
	public void setSeckillingItemId(Long seckillingItemId){
		this.seckillingItemId=seckillingItemId;
	}
	public Long getSeckillingItemId(){
		return seckillingItemId;
	}
	public void setUserPhone(Long userPhone){
		this.userPhone=userPhone;
	}
	public Long getUserPhone(){
		return userPhone;
	}
	public void setState(Byte state){
		this.state=state;
	}
	public Byte getState(){
		return state;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}

    public TSeckillingItem getSeckillingItem() {
        return seckillingItem;
    }

    public void setSeckillingItem(TSeckillingItem seckillingItem) {
        this.seckillingItem = seckillingItem;
    }
}

