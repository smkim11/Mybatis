package com.example.signapp.filter;

import java.io.IOException;

import com.example.signapp.dto.Employee;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/*")
public class SignFilter  implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request instanceof HttpServletRequest) {
			HttpServletRequest httpReq = (HttpServletRequest)request;
			HttpSession session= httpReq.getSession();
			Employee employee = (Employee)session.getAttribute("loginInfo");
			
			// 로그인 없이 접근 가능한 경로
			String uri = httpReq.getRequestURI();
			if (uri.equals("/login") || 
				    uri.equals("/signup") ||
				    uri.equals("/loginProcess") || 
				    uri.equals("/addSign") ||
				    uri.startsWith("/useId") ||
				    uri.startsWith("/js") ||
				    uri.equals("/")) {
					chain.doFilter(request, response);
					return;
				}

			
			// 로그인이 안되어 있을때
			if(employee == null) {
				if(response instanceof HttpServletResponse) {
					log.info("SignFilter에 걸려서 loginPage로 이동");
					((HttpServletResponse)response).sendRedirect("/");
				}
				return;
			}
		}
		
		chain.doFilter(request, response);
	}
}
