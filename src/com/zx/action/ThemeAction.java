package com.zx.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.zx.common.Page;
import com.zx.entity.Theme;
import com.zx.service.ThemeServiceInterface;

public class ThemeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7040710839716974926L;

	private String result;
	private ThemeServiceInterface themeServiceInterface;
	private Theme theme;
	private Page page;

	public String add() {
		try {
			if (theme != null) {
				if (themeServiceInterface.addTheme(theme)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
			} else {
				result = NONE;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = e.getMessage();
		}
		return Action.SUCCESS;
	}

	public String getAll() {
		try {
			if (page != null) {
				page = themeServiceInterface.getTheme(page.getPageNow());
			} else {
				System.out.println("page is null!");
			}
		} catch (Exception e) {
			System.out.println("exception:" + e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String delete() {
		try {
			if (theme.getId() != null) {
				if (themeServiceInterface.deleteTheme(theme)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
			} else {
				result = NONE;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = e.getMessage();
		}
		return Action.SUCCESS;
	}

	public String update() {
		try {
			if (theme != null
					&& theme.getId() != null
					&& (theme.getNameCn() != null || theme.getNameEn() != null || theme
							.getPreKey() != null)) {
				if (themeServiceInterface.update(theme)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
			} else {
				System.out.println("error:null!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = e.getMessage();
		}
		return Action.SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ThemeServiceInterface getThemeServiceInterface() {
		return themeServiceInterface;
	}

	public void setThemeServiceInterface(
			ThemeServiceInterface themeServiceInterface) {
		this.themeServiceInterface = themeServiceInterface;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
