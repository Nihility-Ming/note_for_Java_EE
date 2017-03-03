package com.iphone567.user.service;

import com.iphone567.user.domain.User;

public interface UserService {
	public int register(User user) throws Exception;
	public int login(User user) throws Exception;
	public int updateInfo(User user) throws Exception;
}
