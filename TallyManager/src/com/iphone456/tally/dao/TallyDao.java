package com.iphone456.tally.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.iphone456.tally.tools.DBUtils;
import com.iphone567.tally.domain.Tally;

public class TallyDao {
	private QueryRunner queryRunner = DBUtils.getQueryRunner();

	public int add(Tally tally) {
		String sql = "INSERT INTO gjp_zhangwu VALUES(null, ?, ?, ?, ?, ?)";
		Object[] params = { tally.getFlname(), tally.getMoney(), tally.getZhanghu(), tally.getCreatetime(),
				tally.getDescription() };
		try {
			return queryRunner.update(sql, params);
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return 0;
	}

	public int delete(int id) {
		String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?";
		try {
			return queryRunner.update(sql, id);
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return 0;
	}

	public int update(Tally tally) {
		String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
		Object[] params = { tally.getFlname(), tally.getMoney(), tally.getZhanghu(), tally.getCreatetime(),
				tally.getDescription(),tally.getZwid() };
		try {
			return queryRunner.update(sql, params);
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return 0;
	}

	public Tally check(int id) {
		String sql = "SELECT * FROM gjp_zhangwu WHERE zwid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<>(Tally.class), new Object[] { id });
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return null;
	}

	public List<Tally> check() {
		String sql = "SELECT * FROM gjp_zhangwu";
		try {
			return queryRunner.query(sql, new BeanListHandler<>(Tally.class));
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return null;
	}

	public List<Tally> check(String startDate, String endDate) {
		String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
		try {
			return queryRunner.query(sql, new BeanListHandler<>(Tally.class), new Object[] { startDate, endDate });
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return null;
	}
}
