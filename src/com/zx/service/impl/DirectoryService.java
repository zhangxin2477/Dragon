package com.zx.service.impl;

import com.zx.common.Page;
import com.zx.dao.SDirectoryDaoInterface;
import com.zx.entity.SDirectory;
import com.zx.service.DirectoryServiceInterface;

public class DirectoryService implements DirectoryServiceInterface {

	private SDirectoryDaoInterface sdirectoryDaoInterface;
	
	@Override
	public boolean addSDir(SDirectory sdir) {
		// TODO Auto-generated method stub
		return sdirectoryDaoInterface.addSDir(sdir);
	}

	@Override
	public boolean updateSDir(SDirectory sdir) {
		// TODO Auto-generated method stub
		return sdirectoryDaoInterface.updateSDir(sdir);
	}

	@Override
	public boolean deleteSDir(SDirectory sdir) {
		// TODO Auto-generated method stub
		return sdirectoryDaoInterface.deleteSDir(sdir);
	}

	@Override
	public Page getSDir(int pageNow) {
		// TODO Auto-generated method stub
		return sdirectoryDaoInterface.getSDir(pageNow);
	}

	public SDirectoryDaoInterface getSdirectoryDaoInterface() {
		return sdirectoryDaoInterface;
	}

	public void setSdirectoryDaoInterface(SDirectoryDaoInterface sdirectoryDaoInterface) {
		this.sdirectoryDaoInterface = sdirectoryDaoInterface;
	}

}
