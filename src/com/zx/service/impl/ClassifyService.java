package com.zx.service.impl;

import java.util.List;

import com.zx.common.Page;
import com.zx.dao.ClassifyDaoInterface;
import com.zx.entity.Classify;
import com.zx.service.ClassifyServiceInterface;

public class ClassifyService implements ClassifyServiceInterface {

	private ClassifyDaoInterface classifyDaoInterface;
	
	@Override
	public boolean addClassify(Classify classify) {
		// TODO Auto-generated method stub
		return this.classifyDaoInterface.addClassify(classify);
	}

	@Override
	public boolean deleteClassify(Classify classify) {
		// TODO Auto-generated method stub
		return this.classifyDaoInterface.deleteClassify(classify);
	}

	@Override
	public boolean updateClassify(Classify classify) {
		// TODO Auto-generated method stub
		return this.classifyDaoInterface.updateClassify(classify);
	}

	@Override
	public Page getClassify(int pageNow) {
		// TODO Auto-generated method stub
		return this.classifyDaoInterface.getClassify(pageNow);
	}

	public ClassifyDaoInterface getClassifyDaoInterface() {
		return classifyDaoInterface;
	}

	public void setClassifyDaoInterface(ClassifyDaoInterface classifyDaoInterface) {
		this.classifyDaoInterface = classifyDaoInterface;
	}

	@Override
	public List<Classify> getClassify(String params) {
		// TODO Auto-generated method stub
		return this.classifyDaoInterface.getClassify(params);
	}

	@Override
	public List<Classify> findByThemeId(Object themeId) {
		// TODO Auto-generated method stub
		return this.classifyDaoInterface.findByThemeId(themeId);
	}

}
