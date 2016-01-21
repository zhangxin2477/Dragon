package com.zx.action;

import java.util.List;

import org.apache.struts2.json.JSONResult;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.entity.Theme;
import com.zx.service.ThemeService;

public class ThemeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7040710839716974926L;

	private ThemeService themeService;

	public ThemeService getThemeService() {
		return themeService;
	}

	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}

	private Theme theme;

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	private List<?> themeList;

	public List<?> getThemeList() {
		return themeList;
	}

	public void setThemeList(List<?> themeList) {
		this.themeList = themeList;
	}

	public JSONResult add() {
		System.out.println("addTheme");
		JSONResult jsonResult = new JSONResult();
		if (theme != null) {
			boolean tmp = false;
			tmp = themeService.addTheme(theme);
			if (tmp) {
				jsonResult.setRoot(SUCCESS);
			} else {
				jsonResult.setRoot(ERROR);
			}
		} else {
			jsonResult.setRoot(NONE);
		}
		return jsonResult;
	}
	
	public String add1() {
		System.out.println("addTheme");
		JSONResult jsonResult = new JSONResult();
		if (theme != null) {
			boolean tmp = false;
			tmp = themeService.addTheme(theme);
			if (tmp) {
				jsonResult.setRoot(SUCCESS);
			} else {
				jsonResult.setRoot(ERROR);
			}
		} else {
			jsonResult.setRoot(NONE);
		}
		return SUCCESS;
	}
}
