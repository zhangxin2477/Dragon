package com.zx.entity;

/**
 * Theme entity. @author MyEclipse Persistence Tools
 */

public class Theme implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8930757350323781756L;
	private Integer id;
	private String nameEn;
	private String nameCn;
	private String key;

	// Constructors

	/** default constructor */
	public Theme() {
	}

	/** full constructor */
	public Theme(String nameEn, String nameCn, String key) {
		this.nameEn = nameEn;
		this.nameCn = nameCn;
		this.key = key;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameCn() {
		return this.nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}