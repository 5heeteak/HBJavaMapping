package com.mavenwebs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Entity
//@Table(name="Note")
public class NoteView1 extends Note
{	
	/*@Column(insertable=false, updatable=false) //insert, update 금지
	private int commentCount;*/
	
	@Transient
	private Note prev;
	@Transient
	private Note next;
	
	public NoteView1() 
	{
		
	}
	
	public NoteView1(int id, String title, String content, String writerId, Date regDate, int hit, boolean pub) 
	{
		//super(id, title, content, writerId, regDate, hit, pub);
	}

	/*public int getCommentCount() 
	{
		return commentCount;
	}

	public void setCommentCount(int commentCount) 
	{
		this.commentCount = commentCount;
	}
	*/
	public Note getPrev() 
	{
		return prev;
	}

	public void setPrev(Note prev) 
	{
		this.prev = prev;
	}

	public Note getNext() 
	{
		return next;
	}

	public void setNext(Note next) 
	{
		this.next = next;
	}

	@Override
	public String toString() 
	{
		return "NoteView [note="+super.toString() + "]";
	}
	
	
	
	
}
