package com.iphone567.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import tools.DBUtils;

/**
 * 事务具有四大特性： 1. 原子性 2. 一致性 3. 隔离性 4. 永久性
 * 
 * @author Nihility-Ming
 *
 */
public class Test1 {

	private Connection conn = DBUtils.getConnection();

	// 没有事务，遇到中途发生错误时，数据只修改了一半！！
	@Test
	public void test1() {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "update user set gender='male' where id=1";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
			// 模拟错误
			@SuppressWarnings("unused")
			int error = 10 / 0;

			sql = "update user set gender='male' where id=3";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 创建事务，中途遇到错误也不怕，不会对数据库发生任何修改。
	@Test
	public void test2() {
		PreparedStatement prepareStatement = null;
		try {
			// 设置事务隔离级别最高！！！（MySQL默认是Connection.TRANSACTION_REPEATABLE_READ）
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false); // 开启事务

			String sql = "update user set gender='male' where id=1";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();

			// 模拟错误
			@SuppressWarnings("unused")
			int error = 10 / 0;

			sql = "update user set gender='female' where id=3";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();

			// 提交事务
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 回滚事务
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
