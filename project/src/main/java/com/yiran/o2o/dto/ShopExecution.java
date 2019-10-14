package com.yiran.o2o.dto;

import java.util.List;

import com.yiran.o2o.entity.Shop;
import com.yiran.o2o.enums.ShopStateEnum;

public class ShopExecution {
	// shop status
	private int state;
	
	// shop staus info
	private String stateInfo;
	
	// shop numbers
	private int count;
	
	//curr shop
	private Shop shop;
	
	// shop list
	private List<Shop> shopList;
	
	public ShopExecution() {
		
	}
	// when shop execute failed, use this constructor
	public ShopExecution(ShopStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}
	// shop execute success use this constrotor
	public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public List<Shop> getShopList() {
		return shopList;
	}
	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
	// shop list
	public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopList = shopList;
	}
}
