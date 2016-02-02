package com.zx.action;

import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.common.Page;
import com.zx.entity.SUsers;
import com.zx.entity.Theme;
import com.zx.entity.Users;
import com.zx.service.UserServiceInterface;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -7028181918413153024L;
	private String result;
	private UserServiceInterface userServiceInterface;
	private Page page;
	private Users users;
	private SUsers susers;
	private Theme theme;

	public String login() {
		return NONE;
	}

	public String register() {
		try {
			if (users != null && users.getAccount() != null
					&& users.getPassword() != null) {
				users.setName(users.getAccount());
				users.setThemeId(2);
				Timestamp tt = new Timestamp(System.currentTimeMillis());
				users.setRegistertime(tt);
				if (susers == null) {
					susers = new SUsers();
				}
				if (this.userServiceInterface.add(users, susers)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
				return SUCCESS;
			} else {
				return NONE;
			}
		} catch (Exception e) {
			System.out.println("user register error:" + e.getMessage());
			result = ERROR;
			return SUCCESS;
		}
	}

	public String getUserPage() {
		try {
			if (page != null) {
				page = this.userServiceInterface.getUserPage(page.getPageNow());
			}
		} catch (Exception e) {
			System.out.println("user action error:" + e.getMessage());
			page = null;
		}
		return SUCCESS;
	}

	public String changeState() {
		try {
			if (users != null && users.getId() != null
					&& users.getActive() != null) {
				if (this.userServiceInterface.changeState(users)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
			}
		} catch (Exception e) {
			System.out.println("user changestate error:" + e.getMessage());
			result = ERROR;
		}
		return SUCCESS;
	}

	public String deleteUser() {
		try {
			if (users != null && susers != null && users.getId() != null
					&& susers.getId() != null) {
				if (this.userServiceInterface.delete(users, susers)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
			}
		} catch (Exception e) {
			System.out.println("user delete error:" + e.getMessage());
			result = ERROR;
		}
		return SUCCESS;
	}

	public String index() {
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public UserServiceInterface getUserServiceInterface() {
		return userServiceInterface;
	}

	public void setUserServiceInterface(
			UserServiceInterface userServiceInterface) {
		this.userServiceInterface = userServiceInterface;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public SUsers getSusers() {
		return susers;
	}

	public void setSusers(SUsers susers) {
		this.susers = susers;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}
