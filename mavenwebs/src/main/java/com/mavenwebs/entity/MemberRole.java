package com.mavenwebs.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MemberRole 
{
	@EmbeddedId
	MemberRoleKey memberRoleKey;
	
	/*@Id
	private String memberId;
	@Id
	private String roleId;*/
	private String regAdmin;
	private Date regDate;
	private boolean defaultRole;
	
	public MemberRole() 
	{
		
	}

	//updating
	public MemberRole(String memberId, String roleId, String regAdmin) 
	{
		this.memberRoleKey.setMemberId(memberId);
		this.memberRoleKey.setRoleId(roleId);
		this.regAdmin = regAdmin;
	}
	
	//selecting
	public MemberRole(String memberId, String roleId, String regAdmin, Date regDate, boolean defaultRole) 
	{
		this.memberRoleKey.setMemberId(memberId);
		this.memberRoleKey.setRoleId(roleId);
		this.regAdmin = regAdmin;
		this.regDate = regDate;
		this.defaultRole = defaultRole;
	}

	public String getMemberId() 
	{
		return memberRoleKey.getMemberId();
	}

	public void setMemberId(String memberId) 
	{
		this.memberRoleKey.setMemberId(memberId);
	}

	public String getRoleId() 
	{
		return memberRoleKey.getRoleId();
	}

	public void setRoleId(String roleId) 
	{
		this.memberRoleKey.setRoleId(roleId);
	}

	public String getRegAdmin() 
	{
		return regAdmin;
	}

	public void setRegAdmin(String regAdmin) 
	{
		this.regAdmin = regAdmin;
	}

	public Date getRegDate() 
	{
		return regDate;
	}

	public void setRegDate(Date regDate) 
	{
		this.regDate = regDate;
	}

	public boolean isDefaultRole() 
	{
		return defaultRole;
	}

	public void setDefaultRole(boolean defaultRole) 
	{
		this.defaultRole = defaultRole;
	}
	
	

	public MemberRoleKey getMemberRoleKey() {
		return memberRoleKey;
	}

	public void setMemberRoleKey(MemberRoleKey memberRoleKey) {
		this.memberRoleKey = memberRoleKey;
	}

	@Override
	public String toString() 
	{
		return "MemberRole [memberId=" + getMemberId() + ", roleId=" + getRoleId() + ", regAdmin=" + regAdmin + ", regDate="
				+ regDate + ", defaultRole=" + defaultRole + "]";
	}
	
	

}
