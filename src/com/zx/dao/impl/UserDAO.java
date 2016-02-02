package com.zx.dao.impl;

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
			System.out.println("user delet2");
			//String su=
			this.getCurrentSession().delete("from SUsers where id="+susers.getId());
			System.out.println("user delet3");
			this.getCurrentSession().delete("from Users where id="+users.getId());
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
		String queryString = "SELECT users.id,users.theme_id,theme.name_cn,users.account,users.`name`,"
				+ "users.`password`,users.`level`,users.registertime,users.logintime,users.active,"
				+ "s_users.openid,s_users.type,s_users.age,s_users.sex,s_users.mail,s_users.phone,"
				+ "s_users.address,s_users.education,s_users.school,s_users.id AS susersid "
				+ "FROM users LEFT JOIN (s_users CROSS JOIN theme) ON (users.id=s_users.p_users_id AND users.theme_id=theme.id)";
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
}