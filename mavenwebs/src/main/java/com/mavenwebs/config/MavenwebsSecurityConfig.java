package com.mavenwebs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.mavenwebs.config")
public class MavenwebsSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		//인터셉터 설정
		http
			.csrf().disable()
			.authorizeRequests()
			//--------------------------------------------------
			//.antMatchers("/*","/note/**","/member/**").anonymous()
			//.antMatchers("/resources/**").permitAll()
			//--------------------------------------------------
			.antMatchers("/author/**").hasAnyRole("AUTHOR","ADMIN")
			.antMatchers("/admin/**").hasRole("ADMIN")
			//.access("hasRole('AUTHOR') and hasRole('ADMIN)")
			//.anyRequest().authenticated()
			.and() //여기까지 설정 다른 설정 시작 알림
		.formLogin()
			.loginPage("/member/login")
			.loginProcessingUrl("/login")
			.successHandler(successHandler)
			//.failureHandler(authenticationFailureHandler)
			//.loginProcessingUrl("member/login")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/member/logout")//logout url 사용자 지정
			.logoutSuccessUrl("/index")
			.invalidateHttpSession(true)
			.and()
		.httpBasic();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		//UserBuilder 를 이용하여 passwordEncoder 설정
		//defaultPasswordEncoder는 현재 프로젝트에서 설정한 encoder방식사용
		// spring4.0까지만 사용 가능
		//UserBuilder users = User.withDefaultPasswordEncoder();
		//spring5 이상에서 사용
		UserBuilder users = User.builder();
		
		auth
				.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select id, pwd password, 1 enabled from Member where id=?")
				.authoritiesByUsernameQuery("select memberId id, roleId authority from MemberRole where memberId=?")
				.passwordEncoder(new BCryptPasswordEncoder());
				/*.inMemoryAuthentication()
				.withUser(users.username("snoopy").password("{noop}1234").roles("ADMIN"))
				.withUser(users.username("snonopy").password("{noop}1234").roles("AUTHOR"));*/
		
		
	}

}
