package com.mavenwebs.dao.hb;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavenwebs.dao.NoteLikeDao;
import com.mavenwebs.entity.Note;
import com.mavenwebs.entity.NoteLike;

@Repository
public class HbNoteLikeDao implements NoteLikeDao 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public NoteLike get(Integer noteId, String memberId) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		NoteLike noteLike  = session.get(NoteLike.class, new NoteLike(noteId, memberId));
		
		return noteLike;
	}

	@Override
	@Transactional
	public int insert(NoteLike noteLike) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.save(noteLike);
		
		return 1;
	}

	@Override
	@Transactional
	public int delete(NoteLike noteLike) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(noteLike);;
		return 0;
	}

}
