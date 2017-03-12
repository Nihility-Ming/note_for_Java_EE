package com.itheima.service;

import com.itheima.domain.User;

/**
 * �û���ز�����ҵ���ӿ�
 * @author zhy
 *
 */
public interface IUserService {
	
	
	/**
	 * �����û����ж��û��Ƿ����
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	
	
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	int register(User user);
}
