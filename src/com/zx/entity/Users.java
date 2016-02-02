package com.zx.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "dragon")
public class Users implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6912008424840324032L;
	private Integer id;
	private Integer themeId;
	private String account;
	private String name;
	private String password;
	private Integer level;
	private Timestamp registertime;
	private Timestamp logintime;
	private Integer active;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Integer themeId, String account, String name, String password,
			Integer active) {
		this.themeId = themeId;
		this.account = account;
		this.name = name;
		this.password = password;
		this.active = active;
	}

	/** full constructor */
	public Users(Integer themeId, String account, String name, String password,
			Integer level, Timestamp registertime, Timestamp logintime,
			Integer active) {
		this.themeId = themeId;
		this.account = account;
		this.name = name;
		this.password = password;
		this.level = level;
		this.registertime = registertime;
		this.logintime = logintime;
		this.active = active;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "theme_id", nullable = false)
	public Integer getThemeId() {
		return this.themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	@Column(name = "account", nullable = false, length = 20)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "registertime", length = 19)
	public Timestamp getRegistertime() {
		return this.registertime;
	}

	public void setRegistertime(Timestamp registertime) {
		this.registertime = registertime;
	}

	@Column(name = "logintime", length = 19)
	public Timestamp getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	@Column(name = "active")
	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}