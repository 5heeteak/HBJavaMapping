package com.mavenwebs.controller.author;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.aop.aspectj.InstantiationModelAwarePointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mavenwebs.entity.Note;
import com.mavenwebs.service.author.NoteService;

@Controller("authorNoteController")
@RequestMapping("/author/note/")
public class NoteController 
{
	@Autowired
	private NoteService service;
	
	
	@RequestMapping("list")
	public String list(@RequestParam(value="p",defaultValue="1")Integer page,Model model)
	{
		List<Note> notes = service.getNoteList(page);
		
		model.addAttribute("notes", notes);

		return "author.note.list";
	}
	
	@RequestMapping("{id}")
	public String detail(@PathVariable("id") Integer id, Model model)
	{
		Note note = service.getNote(id);
		
		model.addAttribute("note", note);
		
		
		return "author.note.detail";
	}
	
	@RequestMapping(value="reg", method=RequestMethod.GET)
	public String reg()
	{
				//tiles 사용 시 /를 .으로 변환
		return "author.note.reg";
	}
	
	@RequestMapping(value="reg", method=RequestMethod.POST)
	public String reg(Note note, MultipartFile file, HttpServletRequest request)
	{
		
		ServletContext ctx = request.getServletContext();
	     String path = ctx.getRealPath("/resources/note/newlec/");
	      
	      //회원아이디 별 폴더 생성
	     /* String memberId = "aa";
	      ServletContext ctx = request.getServletContext();
	      String path = ctx.getRealPath("/resources/note/"+memberId+"/");
	      
	      File f = new File(path);
	      if(!f.exists())
	    	  f.mkdirs();	*/
		
		if(!file.isEmpty())
		{

			try {
				InputStream fis = file.getInputStream();
				String fname = file.getOriginalFilename();
				
				FileOutputStream fos = new FileOutputStream(path + File.separator + fname);
				
				byte[] buf = new byte[1024];
				
				int size = 0;
				
				while((size = fis.read(buf,0,1024)) != -1)
					fos.write(buf,0,size);
				
				fis.close();
				fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return "error";
			}
			
		}
		int result = service.insertNote(note);
		
		//redirect: == sendRedirect
		return "redirect:list";
	}
	
	
	@RequestMapping(value="list/{id}/edit", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model)
	{
		Note note = service.getNote(id);
		
		model.addAttribute("note", note);
		
		return "author.note.edit";
	}
	
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String edit()
	{
		
				
		return "author.note.edit";
	}
	
		
	@RequestMapping("data")
	@ResponseBody
	public String data()
	{
		
		return "DATA 데이타";
	}

	

}
