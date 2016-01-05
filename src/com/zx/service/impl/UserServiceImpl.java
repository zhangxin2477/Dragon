package com.zx.service.impl;

import java.util.List;

import com.zx.dao.UserDao;
import com.zx.entity.SUser;
import com.zx.entity.User;
import com.zx.service.UserService;

public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public List<User> getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.findByExample(user);
	}

	@Override
	public boolean AddUser(User user, SUser sUser) {
		// TODO Auto-generated method stub
		return userDao.save(user, sUser);
	}

}
