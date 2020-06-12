package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * @author Vishnu Awasthi (Vishnuawasthi121@gmail.com)
 *
 */

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UnauthorizedUserAccessDeniedHandler unauthorizedUserAccessDeniedHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	// Uncomment below piece of code in order to enable SSL
		/*	http.requiresChannel()
		.anyRequest()
		.requiresSecure();*/
		
		
		http.authorizeRequests(authorizeRequests -> {
			authorizeRequests.antMatchers("/api/**").hasAnyAuthority("OPERATOR", "ADMIN");
			authorizeRequests.antMatchers("/members-api/**").hasAnyAuthority("MEMBER");
			authorizeRequests.antMatchers("/admin-api/**").hasAnyAuthority("ADMIN");
		})
		.exceptionHandling().accessDeniedHandler(unauthorizedUserAccessDeniedHandler)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.httpBasic();
	}

}
