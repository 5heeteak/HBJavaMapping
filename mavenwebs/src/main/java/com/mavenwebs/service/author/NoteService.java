package com.mavenwebs.service.author;

import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Service;

import com.mavenwebs.dao.NoteDao;
import com.mavenwebs.entity.Note;


@Service("authorNoteService")
public class NoteService 
{
	@Autowired
	private NoteDao noteDao;
	

	public int insertNote(Note note) 
	{
		
		noteDao.insert(note);
		return 0;
		
	}

	public List<Note> getNoteList(Integer page) 
	{
		
		List<Note> list = noteDao.getList(page);
		
		/*for(Note n : list)
		{
			String content = n.getContent();
			
			if(content == null) continue;
			
			Document doc = Jsoup.parse(content);
			
			String text = doc.text();
			Elements img = doc.select("img");
			
			if(text.length() > 250)
				text = text.substring(	0,249);
			
			if(img != null)
				n.setContent(img.toString()+text);
			else
				n.setContent(text);
			
			if(img.size() > 0)
				text += img.first().toString();
			
			n.setContent(text);
		}*/
		return list;
	}

	public int updateNote(Note note) 
	{
		//noteDao.update(note);
		return 0;
	}

	public Note getNote(Integer id) 
	{
		Note note = noteDao.get(id);
		return note;
	}



}
