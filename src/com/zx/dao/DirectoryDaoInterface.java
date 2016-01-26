package com.zx.dao;

import com.zx.common.Page;
import com.zx.entity.Directory;

public interface DirectoryDaoInterface {
	public boolean addDir(Directory dir);

	public boolean deleteDir(Directory dir);

	public boolean updateDir(Directory dir);

	public Page getAllDir(int pageNow);
}
