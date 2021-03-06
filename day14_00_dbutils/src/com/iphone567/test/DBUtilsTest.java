package com.iphone567.test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.iphone567.domain.Zhangwu;
import com.iphone567.utils.C3P0Utils;

public class DBUtilsTest {
	
	private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

	/**
	 * 测试批量操作Insert
	 */
	@Test
	public void testBatch() {
		Object[][] params = new Object[3][];
		for(int i=0; i<params.length; i++) {
			params[i] = new Object[]{"flname"+i, i+1000.0, "zhanghu", new Date(System.currentTimeMillis()+(i*1000000000)), "description"};
		}
		
		try {
			queryRunner.batch("insert into gjp_zhangwu values(null,?,?,?,?,?)", params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		// The number of rows updated.
		try {
			int rowsUpdated = queryRunner.update("delete from gjp_zhangwu where zwid=?", new Object[] {12});
			System.out.println("rowsUpdated:" + rowsUpdated);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() {
		// The number of rows updated.
		try {
			int rowsUpdated = queryRunner.update("update gjp_zhangwu set money=? where zwid=?", new Object[] {10086.5, 11});
			System.out.println("rowsUpdated:" + rowsUpdated);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ================================ query ================================
	
	@Test
	public void testQuery_BeanHandler() {
		try {
			Zhangwu zhangwu = queryRunner.query("select * from gjp_zhangwu where zwid=?", new BeanHandler<Zhangwu>(Zhangwu.class), new Object[]{10});
			System.out.println(zhangwu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery_BeanListHandler() {
		try {
			List<Zhangwu> zhangwuList = queryRunner.query("select * from gjp_zhangwu", new BeanListHandler<Zhangwu>(Zhangwu.class));
			System.out.println(zhangwuList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery_ArrayHandler() {
		try {
			Object[] zhangwu = queryRunner.query("select * from gjp_zhangwu where zwid=?", new ArrayHandler(), 8);
			System.out.println(Arrays.toString(zhangwu));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery_ArrayListHandler() {
		try {
			List<Object[]> zhangwuList = queryRunner.query("select * from gjp_zhangwu", new ArrayListHandler());
			
			for(int i = 0; i<zhangwuList.size(); i++) {
				System.out.println(Arrays.toString(zhangwuList.get(i)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery_ColumnListHandler() {
		try {
			List<String> zhangwuList = queryRunner.query("select * from gjp_zhangwu", new ColumnListHandler<String>("flname"));
			
			for(int i = 0; i<zhangwuList.size(); i++) {
				System.out.println(zhangwuList.get(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery_KeyedHandler() {
		try {
			Map<Integer, Map<String, Object>> zhangwuMap =  queryRunner.query("select * from gjp_zhangwu", new KeyedHandler<Integer>("zwid"));
			System.out.println(zhangwuMap.get(10));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery_MapHandler() {
		try {
			Map<String, Object> zhangwuMap =  queryRunner.query("select * from gjp_zhangwu where zwid=10", new MapHandler());
			System.out.println(zhangwuMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery_MapListHandler() {
		try {
			List<Map<String, Object>> zhangwuMapList =  queryRunner.query("select * from gjp_zhangwu", new MapListHandler());
			System.out.println(zhangwuMapList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 获取只有一个结果值，可以用这个查询
	@Test
	public void testQuery_ScalarHandler() {
		try {
			String eight_flname = queryRunner.query("select * from gjp_zhangwu where zwid=?", new ScalarHandler<String>("flname"), 8);
			System.out.println(eight_flname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
