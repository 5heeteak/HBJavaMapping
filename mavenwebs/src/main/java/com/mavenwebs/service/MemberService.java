package com.mavenwebs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenwebs.dao.MemberDao;
import com.mavenwebs.dao.MemberRoleDao;
import com.mavenwebs.entity.Member;

@Service
public class MemberService 
{
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberRoleDao memberRoleDao;
	
	@Transactional
	public int insertMember(Member member) 
	{
		int result = memberDao.insert(member);
		return result;
	}

	@Transactional
	public String getDefaultRoleByMemberId(String memberId) 
	{
		String roleName = memberRoleDao.getDefaultRoleByMemberId(memberId);
		return roleName;
	}

}
