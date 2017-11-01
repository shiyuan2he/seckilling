package com.hsy.seckilling.entity;

import java.util.Date;


public class TSeckillingItem{
	private Long id;
	private String name;
	private Integer number;
	private Date createTime;
	private Date startTime;
	private Date endTime;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setNumber(Integer number){
		this.number=number;
	}
	public Integer getNumber(){
		return number;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setStartTime(Date startTime){
		this.startTime=startTime;
	}
	public Date getStartTime(){
		return startTime;
	}
	public void setEndTime(Date endTime){
		this.endTime=endTime;
	}
	public Date getEndTime(){
		return endTime;
	}

    @Override
    public String toString() {
        return "TSeckillingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", createTime=" + createTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

