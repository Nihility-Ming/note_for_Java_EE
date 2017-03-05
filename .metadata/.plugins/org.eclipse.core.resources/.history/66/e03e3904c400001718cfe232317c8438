package com.iphone567.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.iphone567.utils.C3P0Utils;

/**
 * 测试C3P0Utils
 * 
 * @author Nihility-Ming
 *
 */
public class C3P0UtilsTest {

	@Test
	public void test() {
		Connection connection = C3P0Utils.getConnection();
		PreparedStatement statement = null;
		int result = 0;

		try {
			statement = connection.prepareStatement("insert into gjp_zhangwu values(null, ?, ?, ?, ?, ?)");
			statement.setString(1, "吃点东西");
			statement.setDouble(2, 199.54);
			statement.setString(3, "支付宝");
			statement.setString(4, "2009-01-01");
			statement.setString(5, "没有描述...");
			result = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(connection, statement);
		}
		
		if (result == 0) {
			System.out.println("添加数据失败！");
		} else {
			System.out.println("添加数据成功！");
		}
	}

}
