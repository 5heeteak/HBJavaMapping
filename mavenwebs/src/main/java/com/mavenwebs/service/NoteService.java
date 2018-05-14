package com.mavenwebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenwebs.dao.NoteCommentDao;
import com.mavenwebs.dao.NoteDao;
import com.mavenwebs.dao.NoteLikeDao;
import com.mavenwebs.entity.Note;
import com.mavenwebs.entity.NoteComment;
import com.mavenwebs.entity.NoteLike;
import com.mavenwebs.entity.NoteView;


@Service
public class NoteService
{
	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;
	
	@Autowired
	private NoteCommentDao noteCommentDao;

	public List<NoteView> getNoteList(Integer page) 
	{
		//noteDao = new MyBatisNoteDao();
		List<NoteView> list = noteDao.getList(page);
		return list;
	}

	public NoteView getNote(Integer id)
	{
		NoteView note = noteDao.get(id);
		Note prev = noteDao.getPrev(id);
		Note next = noteDao.getNext(id);
		int page = 1;
		List<NoteComment> comments = noteCommentDao.getListByNoteId(page, id);
		
		note.setPrev(prev);
		note.setNext(next);
		note.setComments(comments);
		
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

	public int addNoteComment(NoteComment comment) 
	{
		
		int result = noteCommentDao.insert(comment);
		
		return result;
	}

	
	

}
