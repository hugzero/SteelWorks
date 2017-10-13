package com.xwtz.platform.steel.bean;

public class CokeMonth {
	private String cokefactory, Month, monthfreightindex;

	public String getCokefactory() {
		return cokefactory;
	}

	public void setCokefactory(String cokefactory) {
		this.cokefactory = cokefactory;
	}

	public String getDay() {
		return Month;
	}

	public void setDay(String Month) {
		this.Month = Month;
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
		sb.append(cokefactory).append("-——");
		sb.append(Month).append("——");
		sb.append(monthfreightindex).append("——");
		return sb.toString();
	}

}
