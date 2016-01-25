package com.zx.service.impl;

import com.zx.common.Page;
import com.zx.dao.ThemeDaoInterface;
import com.zx.entity.Theme;
import com.zx.service.ThemeServiceInterface;

public class ThemeService implements ThemeServiceInterface {

	public ThemeService(){
		
	}
	
	private ThemeDaoInterface themeDaoInterface;
	
	public ThemeDaoInterface getThemeDaoInterface() {
		return themeDaoInterface;
	}

	public void setThemeDaoInterface(ThemeDaoInterface themeDaoInterface) {
		this.themeDaoInterface = themeDaoInterface;
	}

	@Override
	public boolean addTheme(Theme theme) {
		// TODO Auto-generated method stub
		return themeDaoInterface.addTheme(theme);
	}

	@Override
	public Page getTheme(int pageNow) {
		// TODO Auto-generated method stub
		return themeDaoInterface.getTheme(pageNow);
	}

	@Override
	public boolean deleteTheme(Theme theme) {
		// TODO Auto-generated method stub
		return themeDaoInterface.deleteTheme(theme);
	}

	@Override
	public boolean update(Theme theme) {
		// TODO Auto-generated method stub
		return themeDaoInterface.updateTheme(theme);
	}

}
