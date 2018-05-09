package com.mavenwebs.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class NoteComment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String nicName; 
	private String pwd; 
	private String content; 
	private Date regDate;
	private boolean secret;
	@Column(insertable=false, updatable=false)
	private int noteId; 
	
	
	@JoinColumn(name="noteId")
	private Note note;
	
	public NoteComment() 
	{
		
	}

	//for selecting
	public NoteComment(int id, String nicName, String pwd, String content, Date regDate, boolean secret, int noteId) 
	{
		
		this.id = id;
		this.nicName = nicName;
		this.pwd = pwd;
		this.content = content;
		this.regDate = regDate;
		this.secret = secret;
		this.noteId = noteId;
	}

	//for inserting
	public NoteComment(String nicName, String pwd, String content, boolean secret, int noteId) 
	{
		this.nicName = nicName;
		this.pwd = pwd;
		this.content = content;
		this.secret = secret;
		this.noteId = noteId;
	}


	public int getId() 
	{
		return id;
	}


	public void setId(int id) 
	{
		this.id = id;
	}


	public String getNicName() 
	{
		return nicName;
	}


	public void setNicName(String nicName) 
	{
		this.nicName = nicName;
	}


	public String getPwd() 
	{
		return pwd;
	}


	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}


	public String getContent() 
	{
		return content;
	}


	public void setContent(String content) 
	{
		this.content = content;
	}


	public Date getRegDate() 
	{
		return regDate;
	}


	public void setRegDate(Date regDate) 
	{
		this.regDate = regDate;
	}


	public boolean isSecret() 
	{
		return secret;
	}


	public void setSecret(boolean secret) 
	{
		this.secret = secret;
	}

		
	public int getNoteId() 
	{
		return noteId;
	}


	public void setNoteId(int noteId) 
	{
		this.noteId = noteId;
	}


	@Override
	public String toString() 
	{
		return "NoteComment [id=" + id + ", nicName=" + nicName + ", pwd=" + pwd + ", content=" + content + ", regDate="
				+ regDate + ", secret=" + secret + ", noteId=" + noteId + "]";
	}


	
	
	
}
