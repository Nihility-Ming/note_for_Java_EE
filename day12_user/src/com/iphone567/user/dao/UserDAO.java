package com.iphone567.user.dao;

import java.util.List;

import com.iphone567.user.domain.User;

/**
 * 用户操作DAO
 * @author Nihility-Ming
 *
 */
public interface UserDAO {
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int add(User user) throws Exception ;
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public int delete(User user) throws Exception ;
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int update(User user) throws Exception ;
	
	/**
	 * 列出所有用户
	 * @return
	 */
	public List<User> findAllUsers() throws Exception ;
	
	/**
	 * 按照用户名查找某个用户
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username) throws Exception ;
	
	/**
	 * 按照ID查找用户
	 * @param id
	 * @return
	 */
	public User find(Integer id) throws Exception ;
}
