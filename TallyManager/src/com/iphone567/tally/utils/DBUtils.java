package com.iphone567.tally.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

/**
 * 数据库工具类
 * 
 * @author Nihility-Ming
 *
 */
public class DBUtils {
	private static DataSource dataSource;
	private static QueryRunner queryRunner;

	static {
		Properties properties = new Properties();
		InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			properties.load(inputStream);
			dataSource = BasicDataSourceFactory.createDataSource(properties);
			queryRunner = new QueryRunner(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库DataSource，内置数据库连接池
	 * 
	 * @return 数据库DataSource
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	public static QueryRunner getQueryRunner() {
		return queryRunner;
	}
}
