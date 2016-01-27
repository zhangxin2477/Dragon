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
import com.zx.dao.SDirectoryDaoInterface;
import com.zx.entity.SDirectory;
import com.zx.entity.Directory;

/**
 * A data access object (DAO) providing persistence and search support for
 * SDirectory entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zx.entity.SDirectory
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unused")
@Transactional
public class SDirectoryDAO implements SDirectoryDaoInterface {
	private static final Logger log = LoggerFactory
			.getLogger(SDirectoryDAO.class);
	// property constants
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

	public void save(SDirectory transientInstance) {
		log.debug("saving SDirectory instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SDirectory persistentInstance) {
		log.debug("deleting SDirectory instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SDirectory findById(java.lang.Integer id) {
		log.debug("getting SDirectory instance with id: " + id);
		try {
			SDirectory instance = (SDirectory) getCurrentSession().get(
					"com.zx.entity.SDirectory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(SDirectory instance) {
		log.debug("finding SDirectory instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("com.zx.entity.SDirectory")
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
		log.debug("finding SDirectory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SDirectory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findBySDirId(Object SDirId) {
		return findByProperty(_SDIR_ID, SDirId);
	}

	public List<?> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<?> findSdirList() {
		log.debug("finding all SDirectory instances");
		try {
			String queryString = "select * from s_directory as sdir LEFT JOIN `directory` as dir ON sdir.id=dir.s_dir_id";
			SQLQuery query = getCurrentSession().createSQLQuery(queryString);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			System.out.println(re.getMessage());
			return null;
		}
	}

	public Page findAll(int pageNo) {
		log.debug("finding all SDirectory instances");
		Page page = new Page();
		try {
			String queryString = "from SDirectory";
			Query queryObject = getCurrentSession().createQuery(queryString);
			page.setTotalCount(queryObject.list().size());
			page.setPageNow(pageNo);
			int pageSize = page.getPageSize();
			page.setPageCount((page.getTotalCount() + pageSize - 1) / pageSize);
			queryObject.setFirstResult((pageNo - 1) * pageSize);
			queryObject.setMaxResults(pageSize);
			page.setDataList(queryObject.list());
		} catch (Exception e) {
			log.error("find all failed", e);
			throw e;
		}
		return page;
	}

	public SDirectory merge(SDirectory detachedInstance) {
		log.debug("merging SDirectory instance");
		try {
			SDirectory result = (SDirectory) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SDirectory instance) {
		log.debug("attaching dirty SDirectory instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SDirectory instance) {
		log.debug("attaching clean SDirectory instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SDirectoryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SDirectoryDAO) ctx.getBean("SDirectoryDAO");
	}

	@Override
	public boolean addSDir(SDirectory sdir) {
		// TODO Auto-generated method stub
		try {
			if (findByName(sdir.getName()).size() == 0
					&& findByName(sdir.getName()).size() == 0) {
				this.save(sdir);
				return true;
			}
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean deleteSDir(SDirectory sdir) {
		// TODO Auto-generated method stub
		try {
			this.getCurrentSession().delete(sdir);// 主键值
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public boolean updateSDir(SDirectory sdir) {
		// TODO Auto-generated method stub
		try {
			if (sdir.getId() != null && sdir.getName() != null) {
				List<SDirectory> sd = (List<SDirectory>) findByName(sdir
						.getName());
				boolean tmp = false;
				if (sd.size() == 0) {
					tmp = true;
				} else {
					if (sd.get(0).getId() == sdir.getId()) {
						tmp = true;
					}
				}
				if (tmp) {
					String queryString = "update SDirectory set name='"
							+ sdir.getName() + "' where id=" + sdir.getId();
					Query queryObject = getCurrentSession().createQuery(
							queryString);
					queryObject.executeUpdate();
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Page getAllSDir(int pageNow) {
		// TODO Auto-generated method stub
		return findAll(pageNow);
	}
}