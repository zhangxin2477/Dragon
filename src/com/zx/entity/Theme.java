package com.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Theme entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "theme", catalog = "dragon")
public class Theme implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8930757350323781756L;
	private Integer id;
	private String nameEn;
	private String nameCn;
	private String preKey;

	// Constructors

	/** default constructor */
	public Theme() {
	}

	/** full constructor */
	public Theme(String nameEn, String nameCn, String preKey) {
		this.nameEn = nameEn;
		this.nameCn = nameCn;
		this.preKey = preKey;
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

	@Column(name = "name_en", nullable = false)
	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Column(name = "name_cn", nullable = false)
	public String getNameCn() {
		return this.nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	@Column(name = "pre_key", nullable = false)
	public String getPreKey() {
		return this.preKey;
	}

	public void setPreKey(String preKey) {
		this.preKey = preKey;
	}

}