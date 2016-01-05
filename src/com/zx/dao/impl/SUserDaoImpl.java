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

import com.zx.entity.SUser;

/**
 * A data access object (DAO) providing persistence and search support for SUser
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zx.entity.SUser
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SUserDaoImpl {
	private static final Logger log = LoggerFactory.getLogger(SUserDaoImpl.class);
	// property constants
	public static final String OPENID = "openid";
	public static final String TYPE = "type";
	public static final String AGE = "age";
	public static final String SEX = "sex";
	public static final String MAIL = "mail";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	public static final String EDUCATION = "education";
	public static final String SCHOOL = "school";

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

	public void save(SUser transientInstance) {
		log.debug("saving SUser instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SUser persistentInstance) {
		log.debug("deleting SUser instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SUser findById(java.lang.Integer id) {
		log.debug("getting SUser instance with id: " + id);
		try {
			SUser instance = (SUser) getCurrentSession().get(
					"com.zx.entity.SUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SUser instance) {
		log.debug("finding SUser instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.zx.entity.SUser")
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
		log.debug("finding SUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOpenid(Object openid) {
		return findByProperty(OPENID, openid);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByMail(Object mail) {
		return findByProperty(MAIL, mail);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByEducation(Object education) {
		return findByProperty(EDUCATION, education);
	}

	public List findBySchool(Object school) {
		return findByProperty(SCHOOL, school);
	}

	public List findAll() {
		log.debug("finding all SUser instances");
		try {
			String queryString = "from SUser";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SUser merge(SUser detachedInstance) {
		log.debug("merging SUser instance");
		try {
			SUser result = (SUser) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SUser instance) {
		log.debug("attaching dirty SUser instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SUser instance) {
		log.debug("attaching clean SUser instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SUserDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (SUserDaoImpl) ctx.getBean("SUserDAO");
	}
}