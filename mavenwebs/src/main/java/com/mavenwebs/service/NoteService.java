package com.mavenwebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenwebs.dao.NoteDao;
import com.mavenwebs.dao.NoteLikeDao;
import com.mavenwebs.entity.Note;
import com.mavenwebs.entity.NoteLike;
import com.mavenwebs.entity.NoteView;


@Service
public class NoteService
{
	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;

	public List<NoteView> getNoteList(Integer page) 
	{
		//noteDao = new MyBatisNoteDao();
		List<NoteView> list = noteDao.getList(page);
		return list;
	}

	public NoteView getNote(Integer id)
	{
		NoteView note = noteDao.get(id);
		NoteView prev = noteDao.getPrev(id);
		NoteView next = noteDao.getNext(id);
		note.setPrev(prev);
		note.setNext(next);
		
		return note ;
	}

	public void setNoteLike(Integer noteId, String memberId) 
	{
		NoteLike noteLike = noteLikeDao.get(noteId, memberId);
		
		if(noteLike == null)
			noteLikeDao.insert(new NoteLike(noteId, memberId));
		else
			noteLikeDao.delete(noteLike);
		
		//return noteLike;
	}

	
	

}
