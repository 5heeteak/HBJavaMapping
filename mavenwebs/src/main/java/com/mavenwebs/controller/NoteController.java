package com.mavenwebs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mavenwebs.entity.Note;
import com.mavenwebs.service.NoteService;

@Controller
//공통된 /note/ 부분을 분리
@RequestMapping("/note/")
public class NoteController 
{	
	//service 함수 정의
	@Autowired
	private NoteService service;
	
	
	@RequestMapping("list")
	public String noteList(@RequestParam(value="p", defaultValue="1") 
				Integer page, Model model) 
	{
																			// Model 객체를 생성 Model은 공유객체
		List<Note> notes = service.getNoteList(page);
		
		//model을 이용하여 notes에 값을 저장
		model.addAttribute("notes", notes);
		
		return "note.list";
	}
	
	
	//id라는 매개변수를 이용하여 url값을 저장
	@RequestMapping("{id}")
	public String noteDetail(@PathVariable("id") Integer id, Model model) 
	{
		
		Note note = service.getNote(id);
		
		//model.addAttribute("note", note);
		
		return note.getContent();
	}

}
