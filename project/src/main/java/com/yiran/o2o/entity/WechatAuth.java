package com.yiran.o2o.entity;

import java.util.Date;

public class WechatAuth {
	private Long wechatAuthId;
	private String openId;
	private Date createTime;
	private PersonInfo perfonInfo;
	public Long getWechatAuthId() {
		return wechatAuthId;
	}
	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public PersonInfo getPerfonInfo() {
		return perfonInfo;
	}
	public void setPerfonInfo(PersonInfo perfonInfo) {
		this.perfonInfo = perfonInfo;
	}

}
