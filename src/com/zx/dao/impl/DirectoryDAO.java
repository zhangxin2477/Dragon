package com.zx.dao.impl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zx.common.Page;
import com.zx.dao.DirectoryDaoInterface;
import com.zx.entity.Directory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Directory entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zx.entity.Directory
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DirectoryDAO implements DirectoryDaoInterface {
	private static final Logger log = LoggerFactory
			.getLogger(DirectoryDAO.class);
	// property constants
	public static final String THEME_ID = "themeId";
	public static final String _SDIR_ID = "SDirId";
	public static final String NAME = "name";

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

	public void save(Directory transientInstance) {
		log.debug("saving Directory instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (Exception re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Directory persistentInstance) {
		log.debug("deleting Directory instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Directory findById(java.lang.Integer id) {
		log.debug("getting Directory instance with id: " + id);
		try {
			Directory instance = (Directory) getCurrentSession().get(
					"com.zx.entity.Directory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(Directory instance) {
		log.debug("finding Directory instance by example");
		try {
			List<?> results = (List<?>) getCurrentSession()
					.createCriteria("com.zx.entity.Directory")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<?> findByProperty(String propertyName, Object value) {
		log.debug("finding Directory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Directory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByThemeId(Object themeId) {
		return findByProperty(THEME_ID, themeId);
	}

	public List<?> findBySDirId(Object SDirId) {
		return findByProperty(_SDIR_ID, SDirId);
	}

	public List<?> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<?> findAll() {
		log.debug("finding all Directory instances");
		try {
			String queryString = "from Directory";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Page findAll(int pageNow) {
		log.debug("finding all Directory instances");
		Page page = new Page();
		try {
			String queryString = "from Directory";
			Query queryObject = getCurrentSession().createQuery(queryString);
			page.setTotalCount(queryObject.list().size());
			page.setPageNow(pageNow);
			int pageSize = page.getPageSize();
			page.setPageCount((page.getTotalCount() + pageSize - 1) / pageSize);
			queryObject.setFirstResult((pageNow - 1) * pageSize);
			queryObject.setMaxResults(pageSize);
			page.setDataList(queryObject.list());
		} catch (Exception e) {
			log.error("find all failed", e);
			throw e;
		}
		return page;
	}

	public Directory merge(Directory detachedInstance) {
		log.debug("merging Directory instance");
		try {
			Directory result = (Directory) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Directory instance) {
		log.debug("attaching dirty Directory instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Directory instance) {
		log.debug("attaching clean Directory instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DirectoryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DirectoryDAO) ctx.getBean("DirectoryDAO");
	}

	@Override
	public boolean addDir(Directory dir) {
		// TODO Auto-generated method stub
		try {
			this.save(dir);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteDir(Directory dir) {
		// TODO Auto-generated method stub
		try {
			this.getCurrentSession().delete(dir);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateDir(Directory dir) {
		// TODO Auto-generated method stub
		try {
			if (dir.getId() != null) {
				String queryString = "update Directory set ";
				if (dir.getName() != null) {
					queryString += "name='" + dir.getName() + "',";
				}
				if (dir.getThemeId() != null) {
					queryString += "theme_id=" + dir.getThemeId() + ",";
				}
				if (dir.getSDirId() != null) {
					queryString += "s_dir_id=" + dir.getSDirId() + ",";
				}
				queryString = queryString
						.substring(0, queryString.length() - 1);
				Query queryObject = this.getCurrentSession().createQuery(
						queryString);
				queryObject.executeUpdate();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Page getAllDir(int pageNow) {
		// TODO Auto-generated method stub
		return this.findAll(pageNow);
	}
}