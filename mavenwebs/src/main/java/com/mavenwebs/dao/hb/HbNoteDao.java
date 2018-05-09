package com.mavenwebs.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavenwebs.dao.NoteDao;
import com.mavenwebs.entity.Note;
import com.mavenwebs.entity.NoteView;


@Repository
public class HbNoteDao implements NoteDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<NoteView> getList(Integer page) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Query<NoteView> query  = session.createQuery("from NoteView", NoteView.class);
		List<NoteView> list = query.getResultList();
		
		return list;
	}

	@Override
	@Transactional
	public NoteView get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		NoteView note  = session.get(NoteView.class, id);
		
		return note;
	}

	@Transactional
	@Override
	public int insert(Note note) 
	{
		
		return 0;
	}

	@Transactional
	@Override
	public int update(Note note) 
	{
		
		return 0;
	}

	@Override
	@Transactional
	public NoteView getPrev(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Query<NoteView> query = session
														.createQuery("from NoteView "
														+ "where regDate < (select regDate from NoteView where id=:id)" 
														+ "order by regDate desc "
														,NoteView.class)
														.setParameter("id", id)
														.setMaxResults(1);
		
		NoteView note = null;
		List<NoteView> list = query.list();
		
		if(list.size() > 0)
			note = list.get(0);
					
		return note;
	}

	@Override
	@Transactional
	public NoteView getNext(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Query<NoteView> query = session
														.createQuery("from NoteView "
														+ "where regDate > (select regDate from NoteView where id=:id)" 
														+ "order by regDate "
														,NoteView.class)
														.setParameter("id", id)
														.setMaxResults(1);
		
		NoteView note = null;
		List<NoteView> list = query.list();
		
		if(list.size() > 0)
			note = list.get(0);
		
		return note;
	}

}
