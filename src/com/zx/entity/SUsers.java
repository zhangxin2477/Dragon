package com.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SUsers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "s_users", catalog = "dragon")
public class SUsers implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7483933180998285314L;
	private Integer id;
	private Integer PUsersId;
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
	public SUsers() {
	}

	/** minimal constructor */
	public SUsers(Integer PUsersId) {
		this.PUsersId = PUsersId;
	}

	/** full constructor */
	public SUsers(Integer PUsersId, String openid, String type, Integer age,
			String sex, String mail, String phone, String address,
			String education, String school) {
		this.PUsersId = PUsersId;
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
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "p_users_id", nullable = false)
	public Integer getPUsersId() {
		return this.PUsersId;
	}

	public void setPUsersId(Integer PUsersId) {
		this.PUsersId = PUsersId;
	}

	@Column(name = "openid", length = 50)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "type", length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "sex", length = 4)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "mail", length = 50)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "education", length = 50)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name = "school", length = 50)
	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}