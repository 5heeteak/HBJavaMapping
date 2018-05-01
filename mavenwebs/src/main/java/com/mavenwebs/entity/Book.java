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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//컬럼의 속성을 그대로 사용(자동증가 설정했을 시)
	private int id;
	private String title;
	private String coverImg;
	private String writerId;
	private Date regDate;
	private int hit;
	@Column(name="`order`")
	private int order;
	
	public Book() 
	{
		
	}

	public Book(int id, String title, String coverImg, String writerId, Date regDate, int hit, int order) 
	{
		this.id = id;
		this.title = title;
		this.coverImg = coverImg;
		this.writerId = writerId;
		this.regDate = regDate;
		this.hit = hit;
		this.order = order;
	}
	
	public Book(String title, String coverImg, String writerId) 
	{
		this.title = title;
		this.coverImg = coverImg;
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

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getCoverImg() 
	{
		return coverImg;
	}

	public void setCoverImg(String coverImg) 
	{
		this.coverImg = coverImg;
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

	@Override
	public String toString() 
	{
		return "Book [id=" + id + ", title=" + title + ", coverImg=" + coverImg + ", writerId=" + writerId
				+ ", regDate=" + regDate + ", hit=" + hit + ", order=" + order + "]";
	}

	
	
	
	
	
	

	
	
	
	
	
}
