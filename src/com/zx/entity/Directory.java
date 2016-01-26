package com.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Directory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "directory", catalog = "dragon")
public class Directory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6829769892993904589L;
	private Integer id;
	private Integer themeId;
	private Integer SDirId;
	private String name;

	// Constructors

	/** default constructor */
	public Directory() {
	}

	/** minimal constructor */
	public Directory(Integer themeId, String name) {
		this.themeId = themeId;
		this.name = name;
	}

	/** full constructor */
	public Directory(Integer themeId, Integer SDirId, String name) {
		this.themeId = themeId;
		this.SDirId = SDirId;
		this.name = name;
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

	@Column(name = "s_dir_id")
	public Integer getSDirId() {
		return this.SDirId;
	}

	public void setSDirId(Integer SDirId) {
		this.SDirId = SDirId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}