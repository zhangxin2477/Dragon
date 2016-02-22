package com.zx.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zx.common.Page;
import com.zx.dao.ArticleDaoInterface;
import com.zx.entity.Article;

@Transactional
public class ArticleDAO implements ArticleDaoInterface {
	private static final Logger log = LoggerFactory.getLogger(ArticleDAO.class);
	// property constants
	public static final String CLASSIFY_ID = "classifyId";
	public static final String USER_ID = "userId";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String LIMIT = "limit";
	public static final String PRAISECOUNT = "praisecount";
	public static final String READCOUNT = "readcount";
	public static final String STATE = "state";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Article transientInstance) {
		log.debug("saving Article instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public Article findById(java.lang.Integer id) {
		log.debug("getting Article instance with id: " + id);
		try {
			Article instance = (Article) getCurrentSession().get(
					"com.zx.entity.Article", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Article> findByExample(Article instance) {
		log.debug("finding Article instance by example");
		try {
			List<Article> results = (List<Article>) getCurrentSession()
					.createCriteria("com.zx.entity.Article")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Article> findByProperty(String propertyName, Object value) {
		log.debug("finding Article instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Article as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Article> findByClassifyId(Object classifyId) {
		return findByProperty(CLASSIFY_ID, classifyId);
	}

	public List<Article> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<Article> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Article> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<Article> findByLimit(Object limit) {
		return findByProperty(LIMIT, limit);
	}

	public List<Article> findByPraisecount(Object praisecount) {
		return findByProperty(PRAISECOUNT, praisecount);
	}

	public List<Article> findByReadcount(Object readcount) {
		return findByProperty(READCOUNT, readcount);
	}

	public List<Article> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	@SuppressWarnings("unchecked")
	public List<Article> findAll() {
		log.debug("finding all Article instances");
		try {
			String queryString = "from Article";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Article merge(Article detachedInstance) {
		log.debug("merging Article instance");
		try {
			Article result = (Article) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Article instance) {
		log.debug("attaching dirty Article instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Article instance) {
		log.debug("attaching clean Article instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ArticleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ArticleDAO) ctx.getBean("ArticleDAO");
	}

	@Override
	public boolean add(Article article) {
		// TODO Auto-generated method stub
		try {
			if (article.getClassifyId() != null && article.getTitle() != null
					&& article.getContent() != null) {
				this.getCurrentSession().save(article);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("article add error:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(int id, int classify, String title, String content,
			int property) {
		// TODO Auto-generated method stub
		try {
			Timestamp updatetime = new Timestamp(System.currentTimeMillis());
			Object[] params = new Object[] { classify, title, content,
					updatetime, property, id };
			String sql = "update Article a set a.classifyId=?,a.title=?,a.content=?,a.updatetime=?,a.property=? where a.id=?";
			Query query = this.getCurrentSession().createQuery(sql);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
			int num = query.executeUpdate();
			if (num > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("article update error:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			Object[] params = new Object[] { id };
			String sql = "delete Article where id=?";
			Query query = this.getCurrentSession().createQuery(sql);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
			int num = query.executeUpdate();
			if (num > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("article delete error:" + e.getMessage());
			return false;
		}
	}

	@Override
	public Page getArticlePage(int pageNow) {
		// TODO Auto-generated method stub
		Page page = new Page();
		try {
			String queryString = "SELECT article.*,classify.class_name FROM article LEFT JOIN classify ON article.classify_id=classify.id";
			SQLQuery query = getCurrentSession().createSQLQuery(queryString);
			page.setTotalCount(query.list().size());
			page.setPageNow(pageNow);
			int pageSize = page.getPageSize();
			page.setPageCount((page.getTotalCount() + pageSize - 1) / pageSize);
			query.setFirstResult((pageNow - 1) * pageSize);
			query.setMaxResults(pageSize);
			page.setDataList(query.list());
		} catch (Exception e) {
			System.out.println("article getpage error:" + e.getMessage());
			return null;
		}
		return page;
	}

	@Override
	public boolean changeState(int state, int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "update Article a set a.state=? where a.id=?";
			Query query = this.getCurrentSession().createQuery(sql);
			query.setParameter(0, state);
			query.setParameter(1, id);
			int result = query.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("article changestate error:" + e.getMessage());
			return false;
		}
	}
}