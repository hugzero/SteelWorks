package com.xwtz.platform.steel.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	// 数据加入到数据库
	/**
	 * 数据库驱动类名称
	 */
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * 连接字符串
	 */
	// private static final String URLSTR =
	// "jdbc:mysql://192.168.0.107:3306/ibase4j?characterEncoding=UTF-8";
	private static final String URLSTR = "jdbc:mysql://127.0.0.1:3306/ibase4j?characterEncoding=UTF-8";

	/**
	 * 用户名
	 */
	private static final String USERNAME = "root";

	/**
	 * 密码
	 */
	private static final String USERPASSWORD = "123456";

	/**
	 * 创建数据库连接对象
	 */
	private static Connection connnection = null;

	/**
	 * 创建PreparedStatement对象
	 */
	private static PreparedStatement preparedStatement = null;

	/**
	 * 创建CallableStatement对象
	 */
	private static CallableStatement callableStatement = null;

	/**
	 * 创建结果集对象
	 */
	private static ResultSet resultSet = null;

	static {
		try {
			// 加载数据库驱动程序
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动错误");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 建立数据库连接
	 * 
	 * @return 数据库连接
	 */
	public static Connection getConnection() {
		try {
			// 获取连接
			connnection = DriverManager.getConnection(URLSTR, USERNAME, USERPASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connnection;
	}

	/**
	 * 关闭所有资源
	 */
	public static void closeAll() {
		// 关闭结果集对象
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// 关闭PreparedStatement对象
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// 关闭CallableStatement 对象
		if (callableStatement != null) {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// 关闭Connection 对象
		if (connnection != null) {
			try {
				connnection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
