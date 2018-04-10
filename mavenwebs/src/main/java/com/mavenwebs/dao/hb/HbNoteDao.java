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


@Repository
public class HbNoteDao implements NoteDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Note> getList(Integer page) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Query<Note> query  = session.createQuery("from Note");
		List<Note> list = query.getResultList();
		
		return list;
	}

	@Transactional
	@Override
	public Note get(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		Note note  = session.get(Note.class, id);
		
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

}
