package com.zx.dao.impl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zx.dao.ThemeDao;
import com.zx.entity.Theme;

/**
 * A data access object (DAO) providing persistence and search support for Theme
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zx.entity.Theme
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ThemeDaoImpl implements ThemeDao {
	private static final Logger log = LoggerFactory.getLogger(ThemeDaoImpl.class);
	// property constants
	public static final String NAME = "name";
	public static final String CODE = "code";

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

	public void save(Theme transientInstance) {
		log.debug("saving Theme instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Theme persistentInstance) {
		log.debug("deleting Theme instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Theme findById(java.lang.Integer id) {
		log.debug("getting Theme instance with id: " + id);
		try {
			Theme instance = (Theme) getCurrentSession().get(
					"com.zx.entity.Theme", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Theme instance) {
		log.debug("finding Theme instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.zx.entity.Theme")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Theme instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Theme as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List findAll() {
		log.debug("finding all Theme instances");
		try {
			String queryString = "from Theme";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Theme merge(Theme detachedInstance) {
		log.debug("merging Theme instance");
		try {
			Theme result = (Theme) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Theme instance) {
		log.debug("attaching dirty Theme instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Theme instance) {
		log.debug("attaching clean Theme instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ThemeDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ThemeDaoImpl) ctx.getBean("ThemeDAO");
	}
}