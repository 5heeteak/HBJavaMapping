package com.mavenwebs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mavenwebs.entity.Member;
import com.mavenwebs.service.MemberService;



@Controller
@RequestMapping("/member/")

public class MemberController 
{
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login()
	{
		return "member.login";
	}
	
	/* spring security가 제공하는 처리기 사용 
	 * @RequestMapping(value="login", method=RequestMethod.POST)
	public String login(String id, String pwd)
	{
		
				
		return "redirect:../index";
	}*/
	
	@GetMapping("join")
	public String join()
	{
		return "member.join";
	}
	
	@PostMapping("join")
	public String join(Member member)
	{
		
		int result = service.insertMember(member);
		
		return "redirect:../index";
	}
}
