package com.mavenwebs.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mavenwebs.dao.NoteCommentDao;
import com.mavenwebs.entity.Note;
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
		
		//Note note = new Note(comment.getNoteId());
		
		int id = (int) session.save(comment);
		
		int result = (id>0)? 1 : 0;
		
		return result;
	}

	@Override
	@Transactional
	public List<NoteComment> getListByNoteId(Integer page, Integer noteId)
	{
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<NoteComment> query = session
				.createQuery("from NoteComment where noteId=:noteId order by regDate DESC",NoteComment.class)
				.setParameter("noteId",noteId);
		
		List<NoteComment> result = query.getResultList();
		
		return result;
	}
	
	
	
	

	
}
