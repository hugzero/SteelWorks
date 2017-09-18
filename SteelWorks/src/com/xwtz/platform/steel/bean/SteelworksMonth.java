package com.xwtz.platform.steel.bean;

public class SteelworksMonth {
	private String steelworks, day, monthfreightindex;

	public String getSteelworks() {
		return steelworks;
	}

	public void setSteelworks(String steelworks) {
		this.steelworks = steelworks;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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
		sb.append(day).append("——");
		sb.append(monthfreightindex).append("——");
		return sb.toString();
	}
}
