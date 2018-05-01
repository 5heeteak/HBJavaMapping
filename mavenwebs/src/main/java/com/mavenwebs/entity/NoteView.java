package com.mavenwebs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class NoteView extends Note
{	
	@Column(insertable=false, updatable=false) //insert, update 금지
	private int commentCount;
	
	@Transient
	private NoteView prev;
	@Transient
	private NoteView next;
	
	public NoteView() 
	{
		
	}
	
	public NoteView(int id, String title, String content, String writerId, Date regDate, int hit, boolean pub) 
	{
		super(id, title, content, writerId, regDate, hit, pub);
	}

	public int getCommentCount() 
	{
		return commentCount;
	}

	public void setCommentCount(int commentCount) 
	{
		this.commentCount = commentCount;
	}
	
	public NoteView getPrev() 
	{
		return prev;
	}

	public void setPrev(NoteView prev) 
	{
		this.prev = prev;
	}

	public NoteView getNext() 
	{
		return next;
	}

	public void setNext(NoteView next) 
	{
		this.next = next;
	}

	@Override
	public String toString() 
	{
		return "NoteView [note="+super.toString()+"commentCount=" + commentCount + "]";
	}
	
	
	
	
}
