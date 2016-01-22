package com.zx.action;

import java.util.List;

import org.apache.struts2.json.JSONResult;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.entity.Theme;
import com.zx.service.ThemeServiceInterface;

public class ThemeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7040710839716974926L;

	public ThemeAction(){
		
	}
	
	private JSONResult jsonResult;
	
	public JSONResult getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JSONResult jsonResult) {
		this.jsonResult = jsonResult;
	}

	private ThemeServiceInterface themeService;

	public ThemeServiceInterface getThemeService() {
		return themeService;
	}

	public void setThemeService(ThemeServiceInterface themeService) {
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
		try {
			jsonResult = new JSONResult();
			jsonResult.setDefaultEncoding("UTF-8");
			jsonResult.setStatusCode(0);
			if (theme != null) {
				boolean tmp = false;
				tmp = themeService.addTheme(theme);
				if (tmp) {
					jsonResult.setRoot(SUCCESS);
				} else {
					jsonResult.setRoot(ERROR);
				}
			} else {
				jsonResult.setRoot(ERROR);
			}
			return jsonResult;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
