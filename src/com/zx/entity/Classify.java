package com.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classify entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "classify", catalog = "dragon")
public class Classify implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5834463023327629804L;
	private Integer id;
	private Integer themeId;
	private String className;
	private Integer classGrade;
	private Integer classLevel;
	private Integer classParentid;

	// Constructors

	/** default constructor */
	public Classify() {
	}

	/** minimal constructor */
	public Classify(Integer themeId, String className, Integer classGrade,
			Integer classLevel) {
		this.themeId = themeId;
		this.className = className;
		this.classGrade = classGrade;
		this.classLevel = classLevel;
	}

	/** full constructor */
	public Classify(Integer themeId, String className, Integer classGrade,
			Integer classLevel, Integer classParentid) {
		this.themeId = themeId;
		this.className = className;
		this.classGrade = classGrade;
		this.classLevel = classLevel;
		this.classParentid = classParentid;
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

	@Column(name = "class_name", nullable = false)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "class_grade", nullable = false)
	public Integer getClassGrade() {
		return this.classGrade;
	}

	public void setClassGrade(Integer classGrade) {
		this.classGrade = classGrade;
	}

	@Column(name = "class_level", nullable = false)
	public Integer getClassLevel() {
		return this.classLevel;
	}

	public void setClassLevel(Integer classLevel) {
		this.classLevel = classLevel;
	}

	@Column(name = "class_parentid")
	public Integer getClassParentid() {
		return this.classParentid;
	}

	public void setClassParentid(Integer classParentid) {
		this.classParentid = classParentid;
	}
}