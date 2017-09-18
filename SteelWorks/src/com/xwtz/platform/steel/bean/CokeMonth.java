package com.xwtz.platform.steel.bean;

public class CokeMonth {
	private String cokefactory,day,monthfreightindex;

	public String getCokefactory() {
		return cokefactory;
	}

	public void setCokefactory(String cokefactory) {
		this.cokefactory = cokefactory;
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
		sb.append(cokefactory).append("——");
		sb.append(day).append("——");
		sb.append(monthfreightindex).append("——");
		return sb.toString();
	}
	
}
