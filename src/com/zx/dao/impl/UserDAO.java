package com.zx.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zx.common.Page;
import com.zx.dao.UserDaoInterface;
import com.zx.entity.SUsers;
import com.zx.entity.Users;

@Transactional
public class UserDAO implements UserDaoInterface {

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

	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAO) ctx.getBean("UserDAO");
	}

	@Override
	public boolean add(Users users, SUsers susers) {
		// TODO Auto-generated method stub
		try {
			this.getCurrentSession().save(users);
			susers.setPUsersId(users.getId());
			this.getCurrentSession().save(susers);
			return true;
		} catch (Exception e) {
			System.out.println("user add error:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Users users, SUsers susers) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete SUsers where id=" + susers.getId();
			Query query = this.getCurrentSession().createQuery(sql);
			query.executeUpdate();

			sql = "delete Users where id=" + users.getId();
			query = this.getCurrentSession().createQuery(sql);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("user delete error:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Users users, SUsers susers) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page getUserPage(int pageNow) {
		// TODO Auto-generated method stub
		Page page = new Page();
		String queryString = "SELECT users.id,users.account,users.`name`,users.`password`,users.`level`,users.registertime,users.logintime,users.active,"
				+ "s_users.openid,s_users.type,s_users.age,s_users.sex,s_users.mail,s_users.phone,"
				+ "s_users.address,s_users.education,s_users.school,s_users.id AS susersid "
				+ "FROM users LEFT JOIN s_users  ON users.id=s_users.p_users_id";
		SQLQuery query = this.getCurrentSession().createSQLQuery(queryString);
		page.setTotalCount(query.list().size());
		page.setPageNow(pageNow);
		int pageSize = page.getPageSize();
		page.setPageCount((page.getTotalCount() + pageSize - 1) / pageSize);
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		page.setDataList(query.list());
		return page;
	}

	@Override
	public boolean changeState(Users users) {
		// TODO Auto-generated method stub
		try {
			String queryString = "update Users u set u.active="
					+ users.getActive() + " where id=" + users.getId();
			Query query = this.getCurrentSession().createQuery(queryString);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("user active errir:" + e.getMessage());
			return false;
		}
	}

	@Override
	public List<?> getUserInfo(int userID) {
		// TODO Auto-generated method stub
		try {
			String queryString = "SELECT users.id,users.account,users.`name`,users.`password`,users.`level`,users.registertime,users.logintime,users.active,"
					+ "s_users.openid,s_users.type,s_users.age,s_users.sex,s_users.mail,s_users.phone,"
					+ "s_users.address,s_users.education,s_users.school,s_users.id AS susersid "
					+ "FROM users LEFT JOIN s_users ON users.id=s_users.p_users_id where users.id="
					+ userID;
			SQLQuery query = this.getCurrentSession().createSQLQuery(
					queryString);
			return query.list();
		} catch (Exception e) {
			System.out.println("getuserinfo error:" + e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users checkUsers(Users users) {
		// TODO Auto-generated method stub
		try {
			String queryString = "from Users as model where model.account= ? and model.password= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, users.getAccount());
			queryObject.setParameter(1, users.getPassword());
			List<Users> results = queryObject.list();
			if (results.size() > 0) {
				Timestamp tt = new Timestamp(System.currentTimeMillis());
				queryString = "update Users as model set model.logintime= ? where model.account= ?";
				Query query = this.getCurrentSession().createQuery(queryString);
				query.setParameter(0, tt);
				query.setParameter(1, users.getAccount());
				query.executeUpdate();
				return (Users) results.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("getusers error:" + e.getMessage());
			return null;
		}
	}
}