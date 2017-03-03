package com.iphone567.user.test;

import org.junit.Test;

import com.iphone567.user.dao.UserDAO;
import com.iphone567.user.dao.imp.UserDAOImp;
import com.iphone567.user.domain.User;

public class UserDAOTest {
	UserDAO userDao = new UserDAOImp();
	@Test
	public void testAdd() {
		User user = new User(3, "dsgsd", "3234", 25, "t333v@qq.com", "female", "I am japan", false);
		try {
			int add = userDao.add(user);
			System.out.println(add);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
