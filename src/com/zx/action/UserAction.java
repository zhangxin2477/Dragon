package com.zx.action;

import java.util.List;

import org.junit.Test;

import net.sf.json.*;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.entity.SUser;
import com.zx.entity.User;
import com.zx.service.UserService;

public class UserAction extends ActionSupport {
	/**
	 * 
	 */
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
		System.out.println("login");
		if (user != null) {
			System.out.println("传对象：");
			System.out.println(user.getAccount());
			System.out.println(user.getPassword());
			System.out.println(JSONObject.fromObject(user).toString());

			try {
				userList = userService.getUser(user);
				if (userList != null) {
					result = JSONObject.fromObject(userList.get(0)).toString();
					System.out.println("结果为" + result);
					return SUCCESS;
				} else {
					System.out.println("为空");
					return NONE;
				}
			} catch (Exception ex) {
				System.out.println("错误");
				return NONE;
			}
		} else {
			return NONE;
		}
	}

	public String register() {
		System.out.println("register");
		if (user != null && suser != null) {
			user.setName(user.getAccount());
			user.setType(1);
			suser.setUser(user);//单向级联表
			System.out.println("传对象：");
			System.out.println(JSONObject.fromObject(user).toString());
			System.out.println(JSONObject.fromObject(suser).toString());

			try {
				boolean add = userService.AddUser(user, suser);
				if (add) {
					result = "true";
					System.out.println("结果为" + result);
					return SUCCESS;
				} else {
					result = "false";
					System.out.println("结果为" + result);
					return NONE;
				}
			} catch (Exception ex) {
				System.out.println("错误:" + ex.toString());
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
