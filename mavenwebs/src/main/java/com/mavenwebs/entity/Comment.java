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
public class Comment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String content; 
	private Date regDate;
	@Column(insertable=false, updatable=false)
	private int noteId; 
	private String writerId;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="noteId")
	private Note note;
	
	public Comment() 
	{
		
	}
	
	public Comment(String content, int noteId, String writerId) 
	{
		this.content = content;
		this.noteId = noteId;
		this.writerId = writerId;
	}

	public Comment(int id, String content, Date regDate, int noteId, String writerId) 
	{
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.noteId = noteId;
		this.writerId = writerId;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
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

	public int getNoteId() 
	{
		return noteId;
	}

	public void setNoteId(int noteId) 
	{
		this.noteId = noteId;
	}

	public String getWriterId() 
	{
		return writerId;
	}

	public void setWriterId(String writerId) 
	{
		this.writerId = writerId;
	}
	
	
	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	@Override
	public String toString() 
	{
		return "Comment [id=" + id + ", content=" + content + ", regDate=" + regDate + ", noteId=" + noteId
				+ ", writerId=" + writerId + "]";
	}
	


	
	
	
}
