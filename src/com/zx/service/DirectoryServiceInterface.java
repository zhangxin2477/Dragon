package com.zx.service;

import com.zx.common.Page;
import com.zx.entity.SDirectory;

public interface DirectoryServiceInterface {
	public boolean addSDir(SDirectory sdir);
	public boolean updateSDir(SDirectory sdir);
	public boolean deleteSDir(SDirectory sdir);
	public Page getSDir(int pageNow);
}
