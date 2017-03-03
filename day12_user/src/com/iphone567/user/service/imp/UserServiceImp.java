package com.iphone567.user.service.imp;

import com.iphone567.user.dao.UserDAO;
import com.iphone567.user.dao.imp.UserDAOImp;
import com.iphone567.user.domain.User;
import com.iphone567.user.service.UserService;

public class UserServiceImp implements UserService {
	
	private UserDAO userDAO = new UserDAOImp(); 

	@Override
	public int register(User user) {
		try {
			userDAO.add(user);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int login(User user) {
		try {
			if(userDAO.findUserByUsername(user.getUsername()) != null) {
				return 1;
			}
			return 0;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateInfo(User user) {
		try {
			User theUser = userDAO.findUserByUsername(user.getUsername());
			if(theUser == null) {
				return 0;
			}
			userDAO.update(user);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
