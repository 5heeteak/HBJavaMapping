package com.mavenwebs.dao.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavenwebs.dao.MemberRoleDao;
import com.mavenwebs.entity.MemberRole;
import com.mavenwebs.entity.MemberRoleKey;

@Repository
public class HbMemberRoleDao implements MemberRoleDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String getDefaultRoleByMemberId(String memberId) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		List <MemberRole> list = session.createQuery("from MemberRole mr where mr.defaultRole=1").getResultList();
		
		String roleName = list.get(0).getRoleId();
		
		System.out.println(memberId);
		System.out.println(roleName);
		
		return roleName;
	}
	
	

}
