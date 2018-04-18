package com.mavenwebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenwebs.dao.NoteDao;
import com.mavenwebs.dao.NoteLikeDao;
import com.mavenwebs.entity.Note;
import com.mavenwebs.entity.NoteLike;


@Service
public class NoteService
{
	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;

	public List<Note> getNoteList(Integer page) 
	{
		//noteDao = new MyBatisNoteDao();
		List<Note> list = noteDao.getList(page);
		return list;
	}

	public Note getNote(Integer id)
	{
		Note note = noteDao.get(id);
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
