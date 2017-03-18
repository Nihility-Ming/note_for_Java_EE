package com.itheima.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements UserDao {
	
	//需要spring注入模板 ,底层使用session，session 有sessionFactory获得
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

}
