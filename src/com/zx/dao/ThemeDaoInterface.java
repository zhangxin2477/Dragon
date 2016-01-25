package com.zx.dao;

import com.zx.common.Page;
import com.zx.entity.Theme;

public interface ThemeDaoInterface {
	public boolean addTheme(Theme theme);
	public Page getTheme(int pageNow);
	public boolean deleteTheme(Theme theme);
	public boolean updateTheme(Theme theme);
}
