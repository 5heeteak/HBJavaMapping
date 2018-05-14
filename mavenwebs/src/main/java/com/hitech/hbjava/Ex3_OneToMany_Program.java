package com.hitech.hbjava;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mavenwebs.entity.Comment;
import com.mavenwebs.entity.Note;
import com.mavenwebs.entity.NoteView;


public class Ex3_OneToMany_Program 
{

	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration()
													.configure("com/hitech/hbjava/config/hibernate.cfg.xml")
													//.addAnnotatedClass(Book.class)
													//.addAnnotatedClass(BookDetail.class)
													.addAnnotatedClass(Note.class)
													.addAnnotatedClass(NoteView.class)
													.addAnnotatedClass(Comment.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();		
		session.beginTransaction();
		
		//1. Note 목로글 가져오기
		//List<Note> list = session.createQuery("from Note").getResultList();
		Query query = session.createQuery("from Note", Note.class);
		List<Note> list = query.getResultList();
		
		for(Note n : list)
		{
			System.out.println(n.getTitle());
			
		/*	for(Comment c : n.getComments())
				System.out.println(c.getContent());*/
		}
		
		//2. 각 Note에 Comment 목록 채우기
	/*	for(Note n : list)
		{
			//Comment에서 noteId를 이용하여 쿼리문작성?
			Query query1 = session.createQuery("from Comment where noteId=:noteId", Comment.class);
			query1.setParameter("noteId", n.getId());
			List<Comment> comments = query1.getResultList();
			n.setComments(comments);
		}*/
		
		//3. NoteView 목록 가져오기
		/*Query query = session.createQuery("from NoteView", NoteView.class);
		List<NoteView> list = query.getResultList();
		
		for(Note n : list)
			System.out.println(n.getTitle());
		
		Query querys =session.createQuery("from NoteView",NoteView.class);
		List<NoteView> views = querys.getResultList();
		
		for(NoteView view : views)
		{
			if(view.getCommentCount()>0)
			{
				System.out.println("ID:"+view.getId());
				System.out.println("제목:"+view.getTitle());
				System.out.println("댓글수:"+view.getCommentCount());
			}
		}		 */

		//4. Many To Many
		/*Note note = session.get(Note.class, 76);
		System.out.println(note.getTitle());
		
		List<Book> books = note.getBooks();
		
		for(Book b : books)
			System.out.println(b.getId()+"/////"+b.getTitle());
		
		Book book = session.get(Book.class, 1);
		List<Note> notes = book.getNotes();
		
		for(Note n : notes)
			System.out.println(n.getTitle());
		*/
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
