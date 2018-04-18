package com.mavenwebs.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.mavenwebs.service.MemberService;

@Component
public class MavenwebsLoginSuccessHandler implements AuthenticationSuccessHandler
{
	@Autowired
	private MemberService service;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess
	(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException 
	{
		//login 시 아이디 가져오기
		String memberId = authentication.getName();
		//login 성공한 아이디에서 ROLE 가져오기
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		System.out.println(memberId);
		for(String role : roles)
			System.out.println(role);
				
		//session에서 저장된 정보가져오기
		HttpSession session = request.getSession();
		
		if(session != null)
		{
			//savedRequest 가져오는 작업
			SavedRequest savedRequest =  (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			
			if(savedRequest != null)
			{
				//savedRequest에서 redirectUrl을 가져오는 작업
				String returnUrl = savedRequest.getRedirectUrl();
				System.out.println(returnUrl);
				redirectStrategy.sendRedirect(request, response, returnUrl);
			}
			
			else
			{
				//직접 로그인시
				String defaultRole = service.getDefaultRoleByMemberId(memberId);
			}
		}
		
		
	}

}
