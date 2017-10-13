package com.xwtz.platform.steel.bean;

public class SteelworksMonth {
	private String steelworks, month, monthfreightindex;

	public String getSteelworks() {
		return steelworks;
	}

	public void setSteelworks(String steelworks) {
		this.steelworks = steelworks;
	}

	public String getDay() {
		return month;
	}

	public void setDay(String month) {
		this.month = month;
	}

	public String getMonthfreightindex() {
		return monthfreightindex;
	}

	public void setMonthfreightindex(String monthfreightindex) {
		this.monthfreightindex = monthfreightindex;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(steelworks).append("——");
		sb.append(month).append("——");
		sb.append(monthfreightindex).append("——");
		return sb.toString();
	}
}
