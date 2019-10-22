package com.yiran.o2o.enums;

public enum ProductStateEnum {
	OFFLINE(-1, "illegal product"), DOWN(0, "sold out"), SUCCESS(1, "operate success"), INNER_ERROR(-1001, "operate failed"), EMPTY(-1002, "null product");

	private int state;

	private String stateInfo;

	private ProductStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static ProductStateEnum stateOf(int index) {
		for (ProductStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
