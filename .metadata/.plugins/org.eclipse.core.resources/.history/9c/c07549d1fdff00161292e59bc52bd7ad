package com.iphone456.tally.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * 数据库工具类
 * 
 * @author Nihility-Ming
 *
 */
public class DBUtils {
	private static BasicDataSource basicDataSource = new BasicDataSource();
	private static QueryRunner queryRunner;

	static {
		Properties properties = new Properties();
		InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			properties.load(inputStream);
			basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
			basicDataSource.setUrl(properties.getProperty("url"));
			basicDataSource.setUsername(properties.getProperty("user"));
			basicDataSource.setPassword(properties.getProperty("password"));
			basicDataSource.setMaxActive(10);
			basicDataSource.setInitialSize(10);
			basicDataSource.setMaxIdle(5);
			basicDataSource.setMinIdle(1);
			
			queryRunner = new QueryRunner(basicDataSource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库DataSource，内置数据库连接池
	 * 
	 * @return 数据库DataSource
	 */
	public static DataSource getDataSource() {
		return basicDataSource;
	}

	public static QueryRunner getQueryRunner() {
		return queryRunner;
	}
}
