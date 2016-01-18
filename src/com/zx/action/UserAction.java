package com.zx.action;

import java.util.List;

import net.sf.json.*;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.entity.SUser;
import com.zx.entity.User;
import com.zx.service.UserService;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -7028181918413153024L;
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private SUser suser;

	public SUser getSuser() {
		return suser;
	}

	public void setSuser(SUser suser) {
		this.suser = suser;
	}

	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		if (user != null) {
			try {
				userList = userService.getUser(user);
				if (userList != null) {
					result = JSONObject.fromObject(userList.get(0)).toString();
					return SUCCESS;
				} else {
					return NONE;
				}
			} catch (Exception ex) {
				return NONE;
			}
		} else {
			return NONE;
		}
	}

	public String register() {
		if (user != null && suser != null) {
			user.setName(user.getAccount());
			user.setType(1);
			suser.setUser(user);//单向级联表
			try {
				boolean add = userService.AddUser(user, suser);
				if (add) {
					result = "true";
					return SUCCESS;
				} else {
					result = "false";
					return NONE;
				}
			} catch (Exception ex) {
				result = "false";
				return NONE;
			}
		} else {
			result = "false";
			return NONE;
		}
	}
	
	public String index(){
		return SUCCESS;
	}

}
