package com.mavenwebs.dao.hb;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavenwebs.dao.NoteCommentDao;
import com.mavenwebs.entity.NoteComment;

@Repository
public class HbNoteCommentDao implements NoteCommentDao
{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public int insert(NoteComment comment) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.save(comment);
		
		return 1;
	}
	
	

	
}
