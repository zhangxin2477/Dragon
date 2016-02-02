package com.zx.service;

import com.zx.common.Page;
import com.zx.entity.SUsers;
import com.zx.entity.Users;

public interface UserServiceInterface {
	public boolean add(Users users, SUsers susers);

	public boolean delete(Users users, SUsers susers);

	public boolean update(Users users, SUsers susers);
	
	public boolean changeState(Users users);

	public Page getUserPage(int pageNow);
}
