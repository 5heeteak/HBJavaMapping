package com.mavenwebs.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mavenwebs.entity.Note;
import com.mavenwebs.entity.NoteComment;
import com.mavenwebs.entity.NoteView;
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
		List<NoteView> notes = service.getNoteList(page);
		
		//model을 이용하여 notes에 값을 저장
		model.addAttribute("notes", notes);
		
		return "note.list";
	}
	
	@RequestMapping("ajax-list")
	@ResponseBody
	public String ajaxList(@RequestParam(value="p", defaultValue="1") 
				Integer page) 
	{
																			// Model 객체를 생성 Model은 공유객체
		List<NoteView> notes = service.getNoteList(page);
		
		/*List<String> list = new ArrayList<>();
		
		for(NoteView n : notes)
			list.add(n.getTitle());*/
						
		return new Gson().toJson(notes);
	}
	
	
	//id라는 매개변수를 이용하여 url값을 저장
	@GetMapping("{id}")
	public String noteDetail(@PathVariable("id") Integer id, Model model) 
	{
		
		NoteView note = service.getNote(id);
		//NoteView prev = service.getPrevNote(id);
		
		model.addAttribute("note", note);
		//model.addAttribute("prev", prev);
		
		return "note.detail";
	}
	
	
	@GetMapping("{id}/like")
	public String like(@PathVariable("id") Integer noteId, Model model, Principal principal) 
	{
		
		String memberId = "snonopy";//principal.getName();
		
		service.setNoteLike(noteId, memberId);
 		
		return "redirect:../{id}";
	}
	
	@PostMapping("{id}/comment/reg")
	@ResponseBody
	public String commentReg(NoteComment comment,@RequestParam("nic-name") String nicName, @PathVariable("id") Integer noteId)
	{
		comment.setNicName(nicName);
		comment.setNoteId(noteId);
		
		int result = service.addNoteComment(comment);
				
		return String.valueOf(result);
	}
	
}
