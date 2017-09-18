package com.xwtz.platform.steel.bean;

public class SteelSum {
	private String day, productionindex, freightindex;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getProductionindex() {
		return productionindex;
	}

	public void setProductionindex(String productionindex) {
		this.productionindex = productionindex;
	}

	public String getFreightindex() {
		return freightindex;
	}

	public void setFreightindex(String freightindex) {
		this.freightindex = freightindex;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(day).append("——");
		sb.append(productionindex).append("——");
		sb.append(freightindex).append("——");
		return sb.toString();
	}
}
