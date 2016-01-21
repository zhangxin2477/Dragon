package com.zx.service.impl;

import java.util.List;

import com.zx.dao.ThemeDao;
import com.zx.entity.Theme;
import com.zx.service.ThemeService;

public class ThemeServiceImpl implements ThemeService {

	public ThemeServiceImpl(){
		
	}
	
	private ThemeDao themeDao;
	
	public ThemeDao getThemeDao() {
		return themeDao;
	}

	public void setThemeDao(ThemeDao themeDao) {
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
