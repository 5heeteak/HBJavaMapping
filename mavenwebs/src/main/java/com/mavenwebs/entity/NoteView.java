package com.mavenwebs.entity;

import javax.persistence.Entity;

@Entity
public class NoteView extends AbstractNote
{
	private int commentCount;

	public int getCommentCount() 
	{
		return commentCount;
	}

	public void setCommentCount(int commentCount) 
	{
		this.commentCount = commentCount;
	}
	
	
	

}
