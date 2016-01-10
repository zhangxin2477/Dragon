package com.zx.dao;

import java.util.List;

import com.zx.entity.Theme;

public interface ThemeDao {

	public void save(Theme theme);

	public void delete(Theme persistentInstance);

	public List findAll();
}
