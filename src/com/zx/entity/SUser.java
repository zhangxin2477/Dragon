package com.zx.entity;

/**
 * SUser entity. @author MyEclipse Persistence Tools
 */

public class SUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7339364216000856424L;
	private Integer id;
	private User user;
	private String openid;
	private String type;
	private Integer age;
	private String sex;
	private String mail;
	private String phone;
	private String address;
	private String education;
	private String school;

	// Constructors

	/** default constructor */
	public SUser() {
	}

	/** minimal constructor */
	public SUser(User user) {
		this.user = user;
	}

	/** full constructor */
	public SUser(User user, String openid, String type, Integer age,
			String sex, String mail, String phone, String address,
			String education, String school) {
		this.user = user;
		this.openid = openid;
		this.type = type;
		this.age = age;
		this.sex = sex;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		this.education = education;
		this.school = school;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}