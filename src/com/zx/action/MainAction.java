package com.zx.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.entity.Classify;
import com.zx.entity.Theme;
import com.zx.entity.Users;
import com.zx.service.ClassifyServiceInterface;
import com.zx.service.ThemeServiceInterface;

public class MainAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4537640671205720119L;
	private ClassifyServiceInterface classifyServiceInterface;
	private Users users;
	private ThemeServiceInterface themeServiceInterface;
	private List<Classify> classifyList;

	@SuppressWarnings("unchecked")
	public String main() {
		HttpServletRequest httpSR = ServletActionContext.getRequest();
		setUsers((Users) httpSR.getSession().getAttribute("user"));
		String namespace = ServletActionContext.getActionMapping()
				.getNamespace();
		namespace = namespace.substring(1, namespace.length());
		Object themeId = ((List<Theme>) this.themeServiceInterface
				.findByNameEn(namespace)).get(0).getId();
		setClassifyList(this.classifyServiceInterface.findByThemeId(themeId));
		httpSR.setAttribute("themeName", namespace);
		return SUCCESS;
	}

	public ClassifyServiceInterface getClassifyServiceInterface() {
		return classifyServiceInterface;
	}

	public void setClassifyServiceInterface(
			ClassifyServiceInterface classifyServiceInterface) {
		this.classifyServiceInterface = classifyServiceInterface;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public ThemeServiceInterface getThemeServiceInterface() {
		return themeServiceInterface;
	}

	public void setThemeServiceInterface(
			ThemeServiceInterface themeServiceInterface) {
		this.themeServiceInterface = themeServiceInterface;
	}

	public List<Classify> getClassifyList() {
		return classifyList;
	}

	public void setClassifyList(List<Classify> classifyList) {
		this.classifyList = classifyList;
	}

}
