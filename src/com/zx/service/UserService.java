package com.zx.service;

import java.util.List;

import com.zx.entity.SUser;
import com.zx.entity.User;

public interface UserService {
	public List<User> getUserList();
	public User getUser(Integer id);
	public List<User> getUser(User user);
	public boolean AddUser(User user,SUser sUser);
}
