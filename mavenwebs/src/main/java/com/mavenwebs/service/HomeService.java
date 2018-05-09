package com.mavenwebs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenwebs.dao.NoteDao;
import com.mavenwebs.dao.NoteLikeDao;
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
		return list;
	}

}
