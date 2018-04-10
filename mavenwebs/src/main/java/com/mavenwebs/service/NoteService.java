package com.mavenwebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenwebs.dao.NoteDao;
import com.mavenwebs.entity.Note;


@Service
public class NoteService
{
	@Autowired
	private NoteDao noteDao;

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

	
	

}
