package com.zx.service;

import java.util.List;

import com.zx.common.Page;
import com.zx.entity.Directory;
import com.zx.entity.SDirectory;

public interface DirectoryServiceInterface {
	public boolean addSDir(SDirectory sdir);

	public boolean updateSDir(SDirectory sdir);

	public boolean deleteSDir(SDirectory sdir);

	public Page getAllSDir(int pageNow);
	
	public List<?> findSdirList();

	public boolean addDir(Directory dir);

	public boolean deleteDir(Directory dir);

	public boolean updateDir(Directory dir);

	public Page getAllDir(int pageNow);
}
