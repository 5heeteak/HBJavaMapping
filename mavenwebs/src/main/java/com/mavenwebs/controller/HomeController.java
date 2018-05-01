package com.mavenwebs.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class HomeController 
{
	@RequestMapping("index")
	public String index(@CookieValue(value="vid",defaultValue="") String vid, HttpServletResponse response, Model model)
	{
		if(vid==null || vid.equals(""))
		{
			vid = UUID.randomUUID().toString();
			Cookie cookie = new Cookie("vid",vid);
			
			cookie.setMaxAge(60*60*24*365);
			
			cookie.setPath("/");
			
			response.addCookie(cookie);
		}
		
		else 
			model.addAttribute("visited","true");
		return "index";
	}
	
	@GetMapping("book-list-partial")
	public String bookListPartial()
	{
		
		return "book-list-partial";
	}

	
	@GetMapping("photo-list")
	@ResponseBody
	public String photoList(HttpServletRequest request)
	{
		
		   String url = "/resources/js/img";
		   String path = request.getServletContext().getRealPath(url);
		   
		   List<String> fileName = new ArrayList<>();
		   
		   File file = new File(path);
		   File[] files = file.listFiles();
		   
		   
		   for(File f : files)
			   //System.out.println(f.getName());
			   fileName.add(f.getName());
		   
		   //json 방식
		/*   StringBuilder builder = new StringBuilder();
		   builder.append("[");
		   
		   for(int i = 0; i<fileName.size(); i++)
		   {
			   builder.append(fileName.get(i));
			   
			   if(i < fileName.size()-1)
				   builder.append(",");
		   }
		   
		   builder.append("]");
		   */
		   
		   /*for(int i=0;i<files.length; i++)
		   {
		      System.out.println(files[i].getName());
		   } */
		   
		/*    String[] list = file.list();
		   

		   
		   /* List<String > list = */ 
		   
		   
		   
		   

		//return builder.toString();
		   //Gson방식
		   return new Gson().toJson(fileName);
	}
}
