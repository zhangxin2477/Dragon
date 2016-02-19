package com.zx.dao;

import com.zx.common.Page;
import com.zx.entity.Article;

public interface ArticleDaoInterface {

	public boolean add(Article article);

	public boolean update(int id, int classify, String title, String content,
			int limit);

	public boolean delete(int id);

	public Page getArticlePage(int pageNow);
}
