package com.hitech.hbjava;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Ex2_OneToOne_Program 
{

	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration()
													.configure("com/hitech/hbjava/config/hibernate.cfg.xml")
													//.addAnnotatedClass(BookDetail.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();		
		session.beginTransaction();
		
		//자식 레코드 추가 시 부모 레코드도 같이 추가
	/*	Book book = new Book("SIST","TEST.png","SISTSIST");
		BookDetail detail = new BookDetail();
		
		detail.setPublisher("쌍용");
		detail.setBook(book);
		
		session.save(detail);*/
		
		// BookDetail를 선택하여 Book에 내용 가져오기?
		/*BookDetail detail = session.get(BookDetail.class, 48);
		Book book = detail.getBook();
		
		System.out.println(book.getTitle());
		*/
		//자식레코드 삭제 시 부모레코드 같이 삭제
		//OneToOne 관계에서만 cascade 설정 시 삭제 가능
	/*	BookDetail detail = session.get(BookDetail.class, 24);
		session.delete(detail);*/
		
		//부모레코드 선택 시 자식 레코드 같이 가져오기
		/*Book book = session.get(Book.class, 107);
		BookDetail detail = book.getBookDetail();
		
		System.out.println(detail.getPublisher());*/
		
		//cascade 제한설정 (자식 레코드 삭제 시 부모 레코드 삭제 x)
		/*BookDetail detail = session.get(BookDetail.class, 48);
		detail.getBook().setBookDetail(null);
		session.delete(detail);
		*/
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
