package com.zx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SDirectory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "s_directory", catalog = "dragon")
public class SDirectory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3968525873643762854L;
	private Integer id;
	private Integer SDirId;
	private String name;

	// Constructors

	/** default constructor */
	public SDirectory() {
	}

	/** minimal constructor */
	public SDirectory(String name) {
		this.name = name;
	}

	/** full constructor */
	public SDirectory(Integer SDirId, String name) {
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