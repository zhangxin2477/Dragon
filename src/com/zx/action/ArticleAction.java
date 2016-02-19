package com.zx.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.common.Page;
import com.zx.entity.Article;
import com.zx.service.ArticleServiceInterface;

public class ArticleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6516573309498369597L;
	private ArticleServiceInterface articleServiceInterface;
	private Page page;
	private Article article;

	public String getArticlePage() {
		try {
			if (page != null) {
				page = this.articleServiceInterface.getArticlePage(page
						.getPageNow());
			}
		} catch (Exception e) {
			System.out.println("getArticlePage is null:" + e.getMessage());
		}
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
}
