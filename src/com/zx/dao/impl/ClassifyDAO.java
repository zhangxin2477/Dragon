package com.zx.dao.impl;

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
import com.zx.dao.ClassifyDaoInterface;
import com.zx.entity.Classify;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classify entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zx.entity.Classify
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ClassifyDAO implements ClassifyDaoInterface {
	private static final Logger log = LoggerFactory
			.getLogger(ClassifyDAO.class);
	// property constants
	public static final String THEME_ID = "themeId";
	public static final String CLASS_NAME = "className";
	public static final String CLASS_GRADE = "classGrade";
	public static final String CLASS_LEVEL = "classLevel";
	public static final String CLASS_PARENTID = "classParentid";

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

	public void save(Classify transientInstance) {
		log.debug("saving Classify instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Classify persistentInstance) {
		log.debug("deleting Classify instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Classify findById(java.lang.Integer id) {
		log.debug("getting Classify instance with id: " + id);
		try {
			Classify instance = (Classify) getCurrentSession().get(
					"com.zx.entity.Classify", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Classify> findByExample(Classify instance) {
		log.debug("finding Classify instance by example");
		try {
			List<Classify> results = (List<Classify>) getCurrentSession()
					.createCriteria("com.zx.entity.Classify")
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
	public List<Classify> findByProperty(String propertyName, Object value) {
		log.debug("finding Classify instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Classify as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Classify> findByThemeId(Object themeId) {
		return findByProperty(THEME_ID, themeId);
	}

	public List<Classify> findByClassName(Object className) {
		return findByProperty(CLASS_NAME, className);
	}

	public List<Classify> findByClassGrade(Object classGrade) {
		return findByProperty(CLASS_GRADE, classGrade);
	}

	public List<Classify> findByClassLevel(Object classLevel) {
		return findByProperty(CLASS_LEVEL, classLevel);
	}

	public List<Classify> findByClassParentid(Object classParentid) {
		return findByProperty(CLASS_PARENTID, classParentid);
	}

	@SuppressWarnings("unchecked")
	public List<Classify> findAll() {
		log.debug("finding all Classify instances");
		try {
			String queryString = "from Classify";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classify merge(Classify detachedInstance) {
		log.debug("merging Classify instance");
		try {
			Classify result = (Classify) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classify instance) {
		log.debug("attaching dirty Classify instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classify instance) {
		log.debug("attaching clean Classify instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClassifyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClassifyDAO) ctx.getBean("ClassifyDAO");
	}

	@Override
	public boolean addClassify(Classify classify) {
		// TODO Auto-generated method stub
		try {
			this.getCurrentSession().save(classify);
			return true;
		} catch (Exception e) {
			System.out.println("addClassify:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteClassify(Classify classify) {
		// TODO Auto-generated method stub
		try {
			this.getCurrentSession().delete(classify);
			return true;
		} catch (Exception e) {
			System.out.println("deleteClassify:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateClassify(Classify classify) {
		// TODO Auto-generated method stub
		try {
			this.getCurrentSession().update(classify);
			return true;
		} catch (Exception e) {
			System.out.println("updateClassify:" + e.getMessage());
			return false;
		}
	}

	@Override
	public Page getClassify(int pageNow) {
		// TODO Auto-generated method stub
		Page page = new Page();
		try {
			String queryString = "SELECT c.id,c.theme_id,theme.name_cn,c.class_name,c.class_grade,c.class_level,c.class_parentid,c.class_parentname FROM(SELECT a.id,a.theme_id,a.class_name,a.class_grade,a.class_level,a.class_parentid,b.class_name class_parentname FROM classify a LEFT JOIN classify b ON a.class_parentid=b.id) c LEFT JOIN theme ON c.theme_id=theme.id";
			SQLQuery queryObject = getCurrentSession().createSQLQuery(
					queryString);
			page.setTotalCount(queryObject.list().size());
			page.setPageNow(pageNow);
			int pageSize = page.getPageSize();
			page.setPageCount((page.getTotalCount() + pageSize - 1) / pageSize);
			queryObject.setFirstResult((pageNow - 1) * pageSize);
			queryObject.setMaxResults(pageSize);
			page.setDataList(queryObject.list());
			return page;
		} catch (Exception e) {
			System.out.println("getClassify:" + e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classify> getClassify(String params) {
		// TODO Auto-generated method stub
		try {
			String queryString = "select * from classify" + params;
			SQLQuery queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.addEntity(Classify.class);
			return queryObject.list();
		} catch (Exception e) {
			System.out.println("getClassifyList:" + e.getMessage());
			return null;
		}
	}
}