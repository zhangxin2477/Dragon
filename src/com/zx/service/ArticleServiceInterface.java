package com.zx.service;

import com.zx.common.Page;
import com.zx.entity.Article;

public interface ArticleServiceInterface {
	public boolean add(Article article);

	public boolean update(int id, int classify, String title, String content,
			int limit);

	public boolean delete(int id);

	public Page getArticlePage(int pageNow);
}
