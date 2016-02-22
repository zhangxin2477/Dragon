package com.zx.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.common.Page;
import com.zx.entity.Article;
import com.zx.entity.Users;
import com.zx.service.ArticleServiceInterface;

public class ArticleAction extends ActionSupport {

	private static final long serialVersionUID = -6516573309498369597L;
	private ArticleServiceInterface articleServiceInterface;
	private Page page;
	private Article article;
	private String result;

	public String addArticle() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Users users = (Users) request.getSession().getAttribute("user");
			if (users != null) {
				article.setUserId(users.getId());
				article.setNewtime(new Timestamp(System.currentTimeMillis()));
				if (article != null
						&& this.articleServiceInterface.add(article)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
			} else {
				result = "login_out";
			}
		} catch (Exception e) {
			System.out.println("addArticle error:" + e.getMessage());
			result = ERROR;
		}
		return SUCCESS;
	}

	public String getArticlePage() {
		try {
			if (page != null) {
				page = this.articleServiceInterface.getArticlePage(page
						.getPageNow());
			}
		} catch (Exception e) {
			System.out.println("getArticlePage is null:" + e.getMessage());
			page = null;
		}
		return SUCCESS;
	}

	public String changeState() {
		try {
			if (article != null
					&& article.getState() != null
					&& article.getId() != null
					&& this.articleServiceInterface.changeState(
							article.getState(), article.getId())) {
				result = SUCCESS;
			} else {
				result = ERROR;
			}
		} catch (Exception e) {
			System.out.println("article changestate error:" + e.getMessage());
			result = ERROR;
		}
		return SUCCESS;
	}

	public String deleteArticle() {
		try {
			if (article != null && article.getId() != null
					&& this.articleServiceInterface.delete(article.getId())) {
				result = SUCCESS;
			} else {
				result = ERROR;
			}
		} catch (Exception e) {
			System.out.println("deleteArticle error:" + e.getMessage());
			result = ERROR;
		}
		return SUCCESS;
	}

	public String PublishInit() {
		return SUCCESS;
	}

	public String GetContentDetail() {
		return SUCCESS;
	}

	public ArticleServiceInterface getArticleServiceInterface() {
		return articleServiceInterface;
	}

	public void setArticleServiceInterface(
			ArticleServiceInterface articleServiceInterface) {
		this.articleServiceInterface = articleServiceInterface;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
