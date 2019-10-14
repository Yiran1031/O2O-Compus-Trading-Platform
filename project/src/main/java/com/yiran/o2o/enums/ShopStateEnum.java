package com.yiran.o2o.enums;

public enum ShopStateEnum {
	CHECK(0, "checking"),OFFLINE(-1, "illegal shop"), SUCCESS(1, "request success"), 
	PASS(2, "check success"), INNER_ERROR(-1001, "system error"), 
	NULL_SHOPID(-1002, "shopID is empty"), NULL_SHOP(-1003, "shop information not found");
	private int state;
	private String stateInfo;
	
	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	} 
	public static ShopStateEnum statsOf(int state) {
		for (ShopStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}
	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}
}
