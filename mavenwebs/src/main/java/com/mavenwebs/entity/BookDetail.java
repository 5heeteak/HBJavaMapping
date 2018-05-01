package com.mavenwebs.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BookDetail 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private int pageCount; 
	private int width; 
	private int height; 
	private String publisher; 
	private Date pubDate; 
	private int bookId;

	public BookDetail() 
	{
		
	}
	
	public BookDetail(int pageCount, String publisher) 
	{
		this.pageCount = pageCount;
		this.publisher = publisher;
	}

		
	public BookDetail(int id, int pageCount, int width, int height, String publisher, Date pubDate, int bookId) 
	{
		this.id = id;
		this.pageCount = pageCount;
		this.width = width;
		this.height = height;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.bookId = bookId;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getPageCount() 
	{
		return pageCount;
	}

	public void setPageCount(int pageCount) 
	{
		this.pageCount = pageCount;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}

	public String getPublisher() 
	{
		return publisher;
	}

	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}

	public Date getPubDate() 
	{
		return pubDate;
	}

	public void setPubDate(Date pubDate) 
	{
		this.pubDate = pubDate;
	}

	public int getBookId() 
	{
		return bookId;
	}

	public void setBookId(int bookId) 
	{
		this.bookId = bookId;
	}

	@Override
	public String toString() 
	{
		return "BookDetail [id=" + id + ", pageCount=" + pageCount + ", width=" + width + ", height=" + height
				+ ", publisher=" + publisher + ", pubDate=" + pubDate + ", bookId=" + bookId + "]";
	}
	
	

		
}
