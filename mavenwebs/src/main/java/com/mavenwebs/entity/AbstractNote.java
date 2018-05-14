package com.mavenwebs.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

//@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class AbstractNote 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private String title; 
	private String content; 
	private String writerId; 
	private Date regDate; 
	private int hit; 
	@Column(name="`order`")
	private int order;
	private boolean pub;

	//단일 테이블을 사용하는 경우 : insert, update, delete
	//다중 테이블을 사용하는 경우 : select
	// 1(*) : 1(parent) / 1(p) : 1(*) : 1(C:집계) < - > 1 : N
	// 뷰를 만들어서 사용 											OneToMany 사용
	
	//@OneToMany(mappedBy="note", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Transient
	private List<NoteComment> comments;
	
	@Transient
	private AbstractNote prev;
	@Transient
	private AbstractNote next;
		
	public AbstractNote() 
	{
		
	}

	public AbstractNote(int id, String title, String content, String writerId, Date regDate, int hit, boolean pub) 
	{
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.regDate = regDate;	
		this.hit = hit;
		this.pub = pub;
	}
	
	public AbstractNote(String title, String content, String writerId) 
	{
		this.title = title;
		this.content = content;
		this.writerId = writerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getContent() 
	{
		return content;
	}

	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getWriterId() 
	{
		return writerId;
	}

	public void setWriterId(String writerId) 
	{
		this.writerId = writerId;
	}

	public Date getRegDate() 
	{
		return regDate;
	}

	public void setRegDate(Date regDate) 
	{
		this.regDate = regDate;
	}

	public int getHit() 
	{
		return hit;
	}

	public void setHit(int hit) 
	{
		this.hit = hit;
	}

	public int getOrder() 
	{
		return order;
	}
	
	public void setOrder(int order) 
	{
		this.order = order;
	}
	
	public boolean isPub() 
	{
		return pub;
	}

	public void setPub(boolean pub) 
	{
		this.pub = pub;
	}
	
		
	public List<NoteComment> getComments() {
		return comments;
	}

	public void setComments(List<NoteComment> comments) {
		this.comments = comments;
	}
	
	public AbstractNote getPrev() 
	{
		return prev;
	}

	public void setPrev(AbstractNote prev) 
	{
		this.prev = prev;
	}

	public AbstractNote getNext() 
	{
		return next;
	}

	public void setNext(AbstractNote next) 
	{
		this.next = next;
	}


	@Override
	public String toString() 
	{
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", writerId=" + writerId + ", regDate="
				+ regDate + ", hit=" + hit + ", order=" + order + ", pub=" + pub + "]";
	}

	
	
	
	
	

}
