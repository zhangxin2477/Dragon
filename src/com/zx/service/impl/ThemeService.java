package com.zx.service.impl;

import java.util.List;

import com.zx.dao.ThemeDaoInterface;
import com.zx.entity.Theme;
import com.zx.service.ThemeServiceInterface;

public class ThemeService implements ThemeServiceInterface {

	public ThemeService(){
		
	}
	
	private ThemeDaoInterface themeDao;
	
	public ThemeDaoInterface getThemeDao() {
		return themeDao;
	}

	public void setThemeDao(ThemeDaoInterface themeDao) {
		this.themeDao = themeDao;
	}

	@Override
	public boolean addTheme(Theme theme) {
		// TODO Auto-generated method stub
		return themeDao.addTheme(theme);
	}

	@Override
	public List<?> getTheme(Theme theme) {
		// TODO Auto-generated method stub
		return themeDao.getTheme(theme);
	}

	@Override
	public boolean deleteTheme(Theme theme) {
		// TODO Auto-generated method stub
		return themeDao.deleteTheme(theme);
	}

}
