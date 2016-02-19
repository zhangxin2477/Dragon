package com.zx.service.impl;

import com.zx.common.Page;
import com.zx.dao.ArticleDaoInterface;
import com.zx.entity.Article;
import com.zx.service.ArticleServiceInterface;

public class ArticleService implements ArticleServiceInterface {

	private ArticleDaoInterface articleDaoInterface;
	
	@Override
	public boolean add(Article article) {
		// TODO Auto-generated method stub
		return this.articleDaoInterface.add(article);
	}

	@Override
	public boolean update(int id, int classify, String title, String content,
			int limit) {
		// TODO Auto-generated method stub
		return this.articleDaoInterface.update(id, classify, title, content, limit);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return this.articleDaoInterface.delete(id);
	}

	@Override
	public Page getArticlePage(int pageNow) {
		// TODO Auto-generated method stub
		return this.articleDaoInterface.getArticlePage(pageNow);
	}

	public ArticleDaoInterface getArticleDaoInterface() {
		return articleDaoInterface;
	}

	public void setArticleDaoInterface(ArticleDaoInterface articleDaoInterface) {
		this.articleDaoInterface = articleDaoInterface;
	}

}
