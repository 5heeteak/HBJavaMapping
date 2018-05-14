package com.mavenwebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenwebs.dao.NoteDao;
import com.mavenwebs.dao.NoteLikeDao;
import com.mavenwebs.entity.Note;
import com.mavenwebs.entity.NoteView;

@Service
public class HomeService 
{
	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;

	public List<NoteView> getNoteList(Integer page) 
	{
		//noteDao = new MyBatisNoteDao();
		List<NoteView> list = noteDao.getList(page);
		
		//list의 각 Note 객체마다 NoteComment 객체를
		// 1: N으로 담는다. 
		
		
		
		return list;
	}

}
