package com.zx.dao;

import java.util.List;

import com.zx.common.Page;
import com.zx.entity.SDirectory;

public interface SDirectoryDaoInterface {
	public boolean addSDir(SDirectory sdir);
	public boolean deleteSDir(SDirectory sdir);
	public boolean updateSDir(SDirectory sdir);
	public Page getAllSDir(int pageNow);
	public List<?> findSdirList();
}
