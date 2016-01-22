package com.zx.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.service.UserServiceInterface;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -7028181918413153024L;
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private UserServiceInterface userService;

	public UserServiceInterface getUserService() {
		return userService;
	}

	public void setUserService(UserServiceInterface userService) {
		this.userService = userService;
	}

	public String login() {
		System.out.println("login");
		// if (user != null) {
		// try {
		// userList = userService.getUser(user);
		// if (userList != null) {
		// result = JSONObject.fromObject(userList.get(0)).toString();
		// return SUCCESS;
		// } else {
		// return NONE;
		// }
		// } catch (Exception ex) {
		// return NONE;
		// }
		// } else {
		return NONE;
		// }
	}

	public String register() {
		// if (user != null && suser != null) {
		// user.setName(user.getAccount());
		// user.setType(1);
		// suser.setUser(user);//单向级联表
		// try {
		// boolean add = userService.AddUser(user, suser);
		// if (add) {
		// result = "true";
		// return SUCCESS;
		// } else {
		// result = "false";
		// return NONE;
		// }
		// } catch (Exception ex) {
		// result = "false";
		// return NONE;
		// }
		// } else {
		// result = "false";
		return NONE;
		// }
	}

	public String index() {
		return SUCCESS;
	}

}
