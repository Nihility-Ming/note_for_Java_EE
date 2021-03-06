package com.iphone567.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	// 自动寻找c3p0-config.xml来设置属性
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	public static Connection getConnection() {
		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			new RuntimeException("服务器正忙...");
		}

		return null;
	}

	public static void release(Connection conn, Statement statement) {
		release(conn, statement, null);
	}

	public static void release(Connection conn, Statement statement, ResultSet resultSet) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
