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
import com.zx.dao.ThemeDaoInterface;
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
public class ThemeDAO implements ThemeDaoInterface {
	private static final Logger log = LoggerFactory.getLogger(ThemeDAO.class);
	// property constants
	public static final String NAME_EN = "nameEn";
	public static final String NAME_CN = "nameCn";
	public static final String PRE_KEY = "preKey";

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

	public List<?> findByExample(Theme instance) {
		log.debug("finding Theme instance by example");
		try {
			List<?> results = (List<?>) getCurrentSession()
					.createCriteria("com.zx.entity.Theme")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<?> findPageByExample(Theme instance) {
		log.debug("finding Theme instance by example");
		try {
			List<?> results = (List<?>) getCurrentSession()
					.createCriteria("com.zx.entity.Theme")
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

	public List<?> findByNameEn(Object nameEn) {
		return findByProperty(NAME_EN, nameEn);
	}

	public List<?> findByNameCn(Object nameCn) {
		return findByProperty(NAME_CN, nameCn);
	}

	public List<?> findByKey(Object preKey) {
		return findByProperty(PRE_KEY, preKey);
	}

	public List<?> findAll() {
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

	public Page findAll(int pageNo) {
		log.debug("finding all Theme instances");
		Page page = new Page();
		try {
			String queryString = "from Theme";
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

	@SuppressWarnings("unchecked")
	public boolean update(Theme theme) {
		try {
			if (theme.getId() != null
					&& (theme.getNameCn() != null || theme.getNameEn() != null || theme
							.getPreKey() != null)) {
				List<Theme> nc = (List<Theme>) findByNameCn(theme.getNameCn());
				List<Theme> ne = (List<Theme>) findByNameEn(theme.getNameEn());
				boolean tmp = false;
				if (nc.size() == 0) {
					if (ne.size() == 0) {
						tmp = true;
					} else if (ne.get(0).getId() == theme.getId()) {
						tmp = true;
					}
				} else if (nc.get(0).getId() == theme.getId()) {
					if (ne.size() == 0) {
						tmp = true;
					} else if (ne.get(0).getId() == theme.getId()) {
						tmp = true;
					}
				}
				if (tmp) {
					String queryString = "update Theme set ";
					if (theme.getNameCn() != null) {
						queryString += "name_cn='" + theme.getNameCn() + "',";
					}
					if (theme.getNameEn() != null) {
						queryString += "name_en='" + theme.getNameEn() + "',";
					}
					if (theme.getPreKey() != null) {
						queryString += "pre_key='" + theme.getPreKey() + "',";
					}
					queryString = queryString.substring(0,
							queryString.length() - 1);
					queryString += " where id=" + theme.getId();
					Query queryObject = getCurrentSession().createQuery(
							queryString);
					queryObject.executeUpdate();
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
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

	public static ThemeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ThemeDAO) ctx.getBean("ThemeDAO");
	}

	@Override
	public boolean addTheme(Theme theme) {
		// TODO Auto-generated method stub
		try {
			if (findByNameCn(theme.getNameCn()).size() == 0
					&& findByNameEn(theme.getNameEn()).size() == 0) {
				this.getCurrentSession().save(theme);
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
	public Page getTheme(int pageNow) {
		// TODO Auto-generated method stub
		return findAll(pageNow);
	}

	@Override
	public boolean deleteTheme(Theme theme) {
		// TODO Auto-generated method stub
		try {
			this.getCurrentSession().delete(theme);// 主键值
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateTheme(Theme theme) {
		// TODO Auto-generated method stub
		return update(theme);
	}
}