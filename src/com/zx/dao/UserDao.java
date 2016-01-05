package com.zx.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zx.entity.SUser;
import com.zx.entity.User;

public interface UserDao {

	public boolean save(User user,SUser sUser);

	public void delete(User persistentInstance);

	public User findById(java.lang.Integer id);
	
	public List findByExample(User instance);

	public List findByProperty(String propertyName, Object value);

	public List findByAccount(Object account);

	public List findAll();
}
