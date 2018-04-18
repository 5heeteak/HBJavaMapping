package com.mavenwebs.controller.author;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AuthorHomeController")
@RequestMapping("/author/")
public class HomeController 
{
	@RequestMapping("index")
	public String index() 
	{
		
		return "author.index";
	}

}
