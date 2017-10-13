package com.xwtz.platform.steel.tablemodel;

import java.util.ArrayList;

import com.xwtz.platform.steel.bean.CokeMonth;
import com.xwtz.platform.steel.tablecolum.CokeMonthColumn;

public class CokeMonthTableModel extends TableDataModel {
	public CokeMonthTableModel() {
		CokeMonthColumn[] columns = CokeMonthColumn.values();
		ArrayList<String> allColumns = new ArrayList<String>();
		for (CokeMonthColumn column : columns) {
			allColumns.add(column.getColumnName());
		}
		setSchema(allColumns.toArray(new String[columns.length]));
	}

	@Override
	public Class<?> getColumnClass(int col) {
		CokeMonthColumn column = CokeMonthColumn.values()[col];
		return column.getColumnClass();
	}

	public void addCokeMonth(CokeMonth cokeMonth) {
		Object[] row = new Object[getColumnCount()];
		row[CokeMonthColumn.Month.ordinal()] = cokeMonth.getDay();
		row[CokeMonthColumn.Cokefactory.ordinal()] = cokeMonth.getCokefactory();
		row[CokeMonthColumn.Monthfreightindex.ordinal()] = cokeMonth.getMonthfreightindex();
		addRow(row);
	}

}
