package com.zx.service.impl;

import com.zx.common.Page;
import com.zx.dao.UserDaoInterface;
import com.zx.entity.SUsers;
import com.zx.entity.Users;
import com.zx.service.UserServiceInterface;

public class UserService implements UserServiceInterface {

	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	private UserDaoInterface userDaoInterface;

	@Override
	public boolean add(Users users, SUsers susers) {
		// TODO Auto-generated method stub
		return this.userDaoInterface.add(users, susers);
	}

	@Override
	public boolean delete(Users users, SUsers susers) {
		// TODO Auto-generated method stub
		System.out.println("user delet1");
		return this.userDaoInterface.delete(users, susers);
	}

	@Override
	public boolean update(Users users, SUsers susers) {
		// TODO Auto-generated method stub
		return this.userDaoInterface.update(users, susers);
	}

	@Override
	public Page getUserPage(int pageNow) {
		// TODO Auto-generated method stub
		return this.userDaoInterface.getUserPage(pageNow);
	}

	public UserDaoInterface getUserDaoInterface() {
		return userDaoInterface;
	}

	public void setUserDaoInterface(UserDaoInterface userDaoInterface) {
		this.userDaoInterface = userDaoInterface;
	}

	@Override
	public boolean changeState(Users users) {
		// TODO Auto-generated method stub
		return this.userDaoInterface.changeState(users);
	}

}
