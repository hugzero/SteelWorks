package com.xwtz.platform.steel.tablemodel;

import java.util.ArrayList;

import com.xwtz.platform.steel.bean.SteelworksMonth;
import com.xwtz.platform.steel.tablecolum.SteelworksMonthColumn;

public class SteelMonthTableModel extends TableDataModel {
	public SteelMonthTableModel() {
		SteelworksMonthColumn[] columns = SteelworksMonthColumn.values();
		ArrayList<String> allColumns = new ArrayList<String>();
		for (SteelworksMonthColumn column : columns) {
			allColumns.add(column.getColumnName());
		}
		setSchema(allColumns.toArray(new String[columns.length]));
	}

	@Override
	public Class<?> getColumnClass(int col) {
		SteelworksMonthColumn column = SteelworksMonthColumn.values()[col];
		return column.getColumnClass();
	}

	public void addSteelworksMonth(SteelworksMonth steelworksMonth) {
		Object[] row = new Object[getColumnCount()];
		row[SteelworksMonthColumn.Day.ordinal()] = steelworksMonth.getDay();
		row[SteelworksMonthColumn.Steelworks.ordinal()] = steelworksMonth.getSteelworks();
		row[SteelworksMonthColumn.Monthfreightindex.ordinal()] = steelworksMonth.getMonthfreightindex();
		addRow(row);
	}

}
