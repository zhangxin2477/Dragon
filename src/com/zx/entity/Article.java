package com.zx.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article", catalog = "dragon")
public class Article implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2115901282900807491L;
	private Integer id;
	private Integer classifyId;
	private Integer userId;
	private String title;
	private String content;
	private Timestamp newtime;
	private Timestamp updatetime;
	private Integer limit;
	private Integer praisecount;
	private Integer readcount;
	private Integer state;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(Integer classifyId, String title, String content) {
		this.classifyId = classifyId;
		this.title = title;
		this.content = content;
	}

	/** full constructor */
	public Article(Integer classifyId, Integer userId, String title,
			String content, Timestamp newtime, Timestamp updatetime,
			Integer limit, Integer praisecount, Integer readcount, Integer state) {
		this.classifyId = classifyId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.newtime = newtime;
		this.updatetime = updatetime;
		this.limit = limit;
		this.praisecount = praisecount;
		this.readcount = readcount;
		this.state = state;
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

	@Column(name = "classify_id", nullable = false)
	public Integer getClassifyId() {
		return this.classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "newtime", length = 19)
	public Timestamp getNewtime() {
		return this.newtime;
	}

	public void setNewtime(Timestamp newtime) {
		this.newtime = newtime;
	}

	@Column(name = "updatetime", length = 19)
	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	@Column(name = "limit")
	public Integer getLimit() {
		return this.limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@Column(name = "praisecount")
	public Integer getPraisecount() {
		return this.praisecount;
	}

	public void setPraisecount(Integer praisecount) {
		this.praisecount = praisecount;
	}

	@Column(name = "readcount")
	public Integer getReadcount() {
		return this.readcount;
	}

	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}