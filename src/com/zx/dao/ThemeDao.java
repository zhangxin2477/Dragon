package com.zx.dao;

import java.util.List;

import com.zx.entity.Theme;

public interface ThemeDao {
	public boolean addTheme(Theme theme);
	public List<?> getTheme(Theme theme);
	public boolean deleteTheme(Theme theme);
}
