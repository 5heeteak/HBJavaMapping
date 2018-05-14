package com.hitech.hbjava;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Ex1_CRUD_Program 
{

	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration()
													.configure("com/hitech/hbjava/config/hibernate.cfg.xml")
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();		
		session.beginTransaction();
		
		// 1. insert
		/*
		Book book = new Book("TesT1","TeSt.png","test");
		session.save(book);
		*/
		
		// 2. select
		//Book book = session.get(Book.class, 6);
		//List<Book> books = session.createQuery("from Book").getResultList();
		
		// 3. update
		/*Book book = session.get(Book.class, 14);
		book.setTitle("TestChange");
		session.update(book);*/
		
		//session.createQuery("update Book set title='test' where id=4").executeUpdate();
		
		// 4. delete
		//session.delete(book);
		session.getTransaction().commit();
		factory.close();
	}

}
