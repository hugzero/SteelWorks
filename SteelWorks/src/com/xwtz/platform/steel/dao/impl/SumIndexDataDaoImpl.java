package com.xwtz.platform.steel.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xwtz.platform.steel.bean.SteelSum;
import com.xwtz.platform.steel.dao.IndexDataDao;
import com.xwtz.platform.steel.util.JDBCUtil;


public class SumIndexDataDaoImpl implements IndexDataDao {
	private Connection conn = null; // 数据库连接
	private List<SteelSum> list = new ArrayList<SteelSum>();

	@Override
	public List<SteelSum> getAllList() {

		String sql = "select *  from sum_index ";
		conn = JDBCUtil.getConnection();
		try {
			Statement state = conn.createStatement();
			// 执行查询并返回结果集
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				SteelSum steelSum = new SteelSum();

				String day = rs.getString("day");
				String productionindex = rs.getString("productionindex");
				String freightindex = rs.getString("freightindex");
				steelSum.setDay(day);
				steelSum.setProductionindex(productionindex);
				steelSum.setFreightindex(freightindex);
				list.add(steelSum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll();
		}
		return list;
	}

}
