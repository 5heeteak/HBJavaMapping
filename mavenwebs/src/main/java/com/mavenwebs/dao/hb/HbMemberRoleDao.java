package com.mavenwebs.dao.hb;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavenwebs.dao.MemberDao;
import com.mavenwebs.dao.MemberRoleDao;
import com.mavenwebs.entity.Member;


@Repository
public class HbMemberRoleDao implements MemberRoleDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String getDefaultRoleByMemberId(String memberId) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		
		return null;
	}
	
	

}
