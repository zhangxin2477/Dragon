package com.zx.dao;

import java.util.List;

import com.zx.common.Page;
import com.zx.entity.Classify;

public interface ClassifyDaoInterface {
	public boolean addClassify(Classify classify);
	public boolean deleteClassify(Classify classify);
	public boolean updateClassify(Classify classify);
	public Page getClassify(int pageNow);
	public List<Classify> getClassify(String params);
}
