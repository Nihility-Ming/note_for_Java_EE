package com.iphone567.user.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iphone567.user.dao.UserDAO;
import com.iphone567.user.domain.User;
import com.iphone567.utils.DBUtils;

public class UserDAOImp implements UserDAO {

	private final Connection conn = DBUtils.getConnection();

	@Override
	public int add(User user) throws Exception {
		PreparedStatement prepareStatement = null;
		try{
			String sql = "insert into user values(null,?,?,?,?,?,?,null)";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setInt(3, user.getAge());
			prepareStatement.setString(4, user.getEmail());
			prepareStatement.setString(5, user.getGender());
			prepareStatement.setString(6, user.getDescription());
			return prepareStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, prepareStatement, null);
		}
		
		return 0;
	}

	@Override
	public int delete(User user) throws Exception {
		PreparedStatement prepareStatement = null;
		try{
			String sql = "delete from user where id=?";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setInt(1, user.getId());
			return prepareStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, prepareStatement, null);
		}
		
		return 0;
	}

	@Override
	public int update(User user) throws Exception {
		PreparedStatement prepareStatement = null;
		try{
			String sql = "update user set password=? age=? email=? gender=? description=?";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, user.getPassword());
			prepareStatement.setInt(2, user.getAge());
			prepareStatement.setString(3, user.getEmail());
			prepareStatement.setString(4, user.getGender());
			prepareStatement.setString(5, user.getDescription());
			return prepareStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, prepareStatement, null);
		}
		
		return 0;
	}

	@Override
	public List<User> findAllUsers() throws Exception {
		PreparedStatement prepareStatement = null;
		ResultSet q= null;
		try{
			String sql = "select * from user";
			prepareStatement = conn.prepareStatement(sql);
			q = prepareStatement.executeQuery();
			List<User> list = new ArrayList<User>();
			while(q.next()) {
				User user = new User(q.getInt("id"), q.getString("username"), q.getString("password"), q.getInt("age"), q.getString("email"), q.getString("gender"), q.getString("description"), q.getBoolean("is_delete"));
				list.add(user);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, prepareStatement, q);
		}
		
		return null;
	}

	@Override
	public User findUserByUsername(String username) throws Exception {
		PreparedStatement prepareStatement = null;
		ResultSet q= null;
		try{
			String sql = "select * from user where username=?";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, username);
			q = prepareStatement.executeQuery();
			List<User> list = new ArrayList<User>();
			while(q.next()) {
				User user = new User(q.getInt("id"), q.getString("username"), q.getString("password"), q.getInt("age"), q.getString("email"), q.getString("gender"), q.getString("description"), q.getBoolean("is_delete"));
				list.add(user);
			}
			return list.get(0);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, prepareStatement, q);
		}
		
		return null;
	}

	@Override
	public User find(Integer id) throws Exception {
		PreparedStatement prepareStatement = null;
		ResultSet q= null;
		try{
			String sql = "select * from user where id=?";
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			q = prepareStatement.executeQuery();
			List<User> list = new ArrayList<User>();
			while(q.next()) {
				User user = new User(q.getInt("id"), q.getString("username"), q.getString("password"), q.getInt("age"), q.getString("email"), q.getString("gender"), q.getString("description"), q.getBoolean("is_delete"));
				list.add(user);
			}
			return list.get(0);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, prepareStatement, q);
		}
		
		return null;
	}

}
