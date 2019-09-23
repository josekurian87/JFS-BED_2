package com.wipro.jfs.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class AuthFIlter implements Filter {

	private static final List<String> EXCLUDE_URL = Arrays.asList("/login/do", "/register/do", "/registration/do", "/css/", "/js/");

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		boolean skipFlag = false;

		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession httpSession =  httpRequest.getSession();
		String queryString = httpRequest.getServletPath();
		
		for(String url:EXCLUDE_URL) {
			if(queryString.contains(url))
				skipFlag = true;
		}
		
		if(httpSession.getAttribute("usr_auth")!=null || skipFlag) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/").forward(request,response);
		}
	}

}
