package com.zx.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.entity.Users;
import com.zx.service.UserServiceInterface;

public class ManagerAction extends ActionSupport {

	private static final long serialVersionUID = 3518864766466073762L;
	private UserServiceInterface userServiceInterface;
	private List<?> userList;
	private Users users;
	private String result;

	public String ManagerInit() {
		// ActionContext context = ActionContext.getContext();
		// Map params = context.getParameters();
		HttpServletRequest request = ServletActionContext.getRequest();
		users = (Users) request.getSession().getAttribute("user");
		String menu = request.getParameter("menu");
		if (menu != null && menu.equals("4")) {
			if (users != null && users.getId() != null) {
				userList = this.userServiceInterface.getUserInfo(users.getId());
			}
		}
		return SUCCESS;
	}

	public UserServiceInterface getUserServiceInterface() {
		return userServiceInterface;
	}

	public void setUserServiceInterface(
			UserServiceInterface userServiceInterface) {
		this.userServiceInterface = userServiceInterface;
	}

	public List<?> getUserList() {
		return userList;
	}

	public void setUserList(List<?> userList) {
		this.userList = userList;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
