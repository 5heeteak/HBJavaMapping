package com.mavenwebs.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MemberRoleKey implements Serializable
{
	private String memberId;
	private String roleId;

	public MemberRoleKey() 
	{
		
	}

	public String getMemberId() 
	{
		return memberId;
	}

	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getRoleId() 
	{
		return roleId;
	}

	public void setRoleId(String roleId) 
	{
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "MemberRoleKey [memberId=" + memberId + ", roleId=" + roleId + "]";
	}
	
	
	
}
