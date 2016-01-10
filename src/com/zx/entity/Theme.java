package com.zx.entity;

/**
 * Theme entity. @author MyEclipse Persistence Tools
 */

public class Theme implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String code;

	// Constructors

	/** default constructor */
	public Theme() {
	}

	/** full constructor */
	public Theme(String name, String code) {
		this.name = name;
		this.code = code;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}