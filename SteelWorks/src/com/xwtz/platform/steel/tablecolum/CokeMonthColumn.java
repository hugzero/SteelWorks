package com.xwtz.platform.steel.tablecolum;

public enum CokeMonthColumn {
	Month("Month", String.class), Cokefactory("Cokefactory", String.class), Monthfreightindex("Monthfreightindex",
			String.class);

	private final String columnName;
	private final Class<?> columnClass;

	CokeMonthColumn(String columnName, Class<?> columnClass) {
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
