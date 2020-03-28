package com.app.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class UnauthorizedUserAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			System.out.println(
					"User: " + auth.getName() + " attempted to access the protected URL: " + request.getRequestURI());
		}
		request.setAttribute("authentication", auth);
		
		response.sendRedirect(request.getContextPath() + "/v1/users/accessDenied");
	}

}