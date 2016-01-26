package com.zx.service.impl;

import java.util.List;

import com.zx.common.Page;
import com.zx.dao.DirectoryDaoInterface;
import com.zx.dao.SDirectoryDaoInterface;
import com.zx.entity.Directory;
import com.zx.entity.SDirectory;
import com.zx.service.DirectoryServiceInterface;

public class DirectoryService implements DirectoryServiceInterface {

	private SDirectoryDaoInterface sdirectoryDaoInterface;
	private DirectoryDaoInterface directoryDaoInterface;
	
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
	public Page getAllSDir(int pageNow) {
		// TODO Auto-generated method stub
		return sdirectoryDaoInterface.getAllSDir(pageNow);
	}

	public SDirectoryDaoInterface getSdirectoryDaoInterface() {
		return sdirectoryDaoInterface;
	}

	public void setSdirectoryDaoInterface(SDirectoryDaoInterface sdirectoryDaoInterface) {
		this.sdirectoryDaoInterface = sdirectoryDaoInterface;
	}

	@Override
	public boolean addDir(Directory dir) {
		// TODO Auto-generated method stub
		return directoryDaoInterface.addDir(dir);
	}

	@Override
	public boolean deleteDir(Directory dir) {
		// TODO Auto-generated method stub
		return directoryDaoInterface.deleteDir(dir);
	}

	@Override
	public boolean updateDir(Directory dir) {
		// TODO Auto-generated method stub
		return directoryDaoInterface.updateDir(dir);
	}

	@Override
	public Page getAllDir(int pageNow) {
		// TODO Auto-generated method stub
		return directoryDaoInterface.getAllDir(pageNow);
	}

	public DirectoryDaoInterface getDirectoryDaoInterface() {
		return directoryDaoInterface;
	}

	public void setDirectoryDaoInterface(DirectoryDaoInterface directoryDaoInterface) {
		this.directoryDaoInterface = directoryDaoInterface;
	}

	@Override
	public List<?> findSdirList() {
		// TODO Auto-generated method stub
		return sdirectoryDaoInterface.findSdirList();
	}

}
