package com.xwtz.platform.steel.tablecolum;

public enum SteelworksMonthColumn {
	Day("Day",String.class), 
	Steelworks("Steelworks", String.class),
	Monthfreightindex("Monthfreightindex", String.class);


	private final String columnName;
	private final Class<?> columnClass;

	SteelworksMonthColumn(String columnName, Class<?> columnClass) {
		this.columnName = columnName;
		this.columnClass = columnClass;
	}

	public String getColumnName() {
		return columnName;
	}

	public Class<?> getColumnClass() {
		return columnClass;
	}
}
