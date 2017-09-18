package com.xwtz.platform.steel.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xwtz.platform.steel.bean.SteelSum;
import com.xwtz.platform.steel.bean.SteelworksMonth;
import com.xwtz.platform.steel.dao.IndexDataDao;
import com.xwtz.platform.steel.util.JDBCUtil;

public class SteelMonthDataDaoImpl implements IndexDataDao {
	private Connection conn = null; // 数据库连接
	private List<SteelworksMonth> list = new ArrayList<SteelworksMonth>();

	@Override
	public List<SteelworksMonth> getAllList() {

		String sql = "select *  from steelworks_month ";
		conn = JDBCUtil.getConnection();
		try {
			Statement state = conn.createStatement();
			// 执行查询并返回结果集
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				SteelworksMonth steelworksMonth = new SteelworksMonth();
				String steelworks = rs.getString("steelworks");
				String day = rs.getString("day");
				String freightindex = rs.getString("month_freightindex");
				steelworksMonth.setDay(day);
				steelworksMonth.setSteelworks(steelworks);
				steelworksMonth.setMonthfreightindex(freightindex);
				list.add(steelworksMonth);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll();
		}
		return list;
	}

}
