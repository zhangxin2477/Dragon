package com.zx.service;

import java.util.List;

import com.zx.common.Page;
import com.zx.entity.Theme;

public interface ThemeServiceInterface {
	public boolean addTheme(Theme theme);
	public Page getTheme(int pageNow);
	public boolean deleteTheme(Theme theme);
	public boolean update(Theme theme);
	public List<?> findAll();
}
