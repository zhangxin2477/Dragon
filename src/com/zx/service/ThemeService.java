package com.zx.service;

import java.util.List;

import com.zx.entity.Theme;

public interface ThemeService {
	public boolean addTheme(Theme theme);
	public List<?> getTheme(Theme theme);
	public boolean deleteTheme(Theme theme);
}
