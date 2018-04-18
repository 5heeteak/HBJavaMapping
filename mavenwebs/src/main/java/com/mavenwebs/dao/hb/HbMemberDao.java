package com.mavenwebs.dao.hb;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavenwebs.dao.MemberDao;
import com.mavenwebs.entity.Member;


@Repository
public class HbMemberDao implements MemberDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insert(Member member) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.save(member);
		
		return 1;
	}

	
	
	

}
