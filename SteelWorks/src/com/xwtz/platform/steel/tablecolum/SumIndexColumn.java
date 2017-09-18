package com.xwtz.platform.steel.tablecolum;

public enum SumIndexColumn {
	Day("Day",String.class), 
	Productionindex("Productionindex", String.class),
	Freightindex("Freightindex", String.class);


	private final String columnName;
	private final Class<?> columnClass;

	SumIndexColumn(String columnName, Class<?> columnClass) {
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
