package com.xwtz.platform.steel.tablemodel;

import java.util.ArrayList;
import java.util.List;

import com.xwtz.platform.steel.bean.SteelSum;
import com.xwtz.platform.steel.tablecolum.SumIndexColumn;

public class SumIndexTableModel extends TableDataModel {
	public SumIndexTableModel() {
		SumIndexColumn[] columns = SumIndexColumn.values();
		ArrayList<String> allColumns = new ArrayList<String>();
		for (SumIndexColumn column : columns) {
			allColumns.add(column.getColumnName());
		}
		setSchema(allColumns.toArray(new String[columns.length]));
	}

	@Override
	public Class<?> getColumnClass(int col) {
		SumIndexColumn column = SumIndexColumn.values()[col];
		return column.getColumnClass();
	}

	public void addSteelSum(SteelSum steelSum) {

		Object[] row = new Object[getColumnCount()];
		row[SumIndexColumn.Day.ordinal()] = steelSum.getDay();
		row[SumIndexColumn.Productionindex.ordinal()] = steelSum.getProductionindex();
		row[SumIndexColumn.Freightindex.ordinal()] = steelSum.getFreightindex();
		addRow(row);
	}

}
