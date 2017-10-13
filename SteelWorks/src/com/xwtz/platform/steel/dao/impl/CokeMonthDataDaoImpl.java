package com.xwtz.platform.steel.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xwtz.platform.steel.bean.CokeMonth;
import com.xwtz.platform.steel.dao.IndexDataDao;
import com.xwtz.platform.steel.util.JDBCUtil;

public class CokeMonthDataDaoImpl implements IndexDataDao {
	private Connection conn = null; // 数据库连接
	private List<CokeMonth> list = new ArrayList<CokeMonth>();

	@Override
	public List<CokeMonth> getAllList() {

		String sql = "select *  from coke_month ";
		conn = JDBCUtil.getConnection();
		try {
			Statement state = conn.createStatement();
			// 执行查询并返回结果集
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				CokeMonth cokeMonth = new CokeMonth();
				String cokefactory = rs.getString("cokefactory");
				String day = rs.getString("month");
				String freightindex = rs.getString("monthfreightindex");
				cokeMonth.setDay(day);
				cokeMonth.setCokefactory(cokefactory);
				cokeMonth.setMonthfreightindex(freightindex);
				list.add(cokeMonth);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll();
		}
		return list;
	}

}
