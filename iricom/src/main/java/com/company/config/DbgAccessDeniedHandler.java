package com.company.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class DbgAccessDeniedHandler implements AccessDeniedHandler{

	private String errorPage;
	
	public void setErrorPage(String errorPage){
		if((errorPage != null) &&!errorPage.startsWith("/")){
			throw new IllegalArgumentException("ErrorPage Must begin with '/'");
		}
		this.errorPage = errorPage;
	}
	//access deny �ɶ� ��� �Ǵ� �ڵ鷯.
	//ajax ��û�� ���� �Ϲ����� ���� ���� ó�� 
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//ajax �ĺ��ڸ� �Ѱ� ���� 
		String ajaxHeader = request.getHeader("Ajax-call");
		String result = "";
		//response status 403
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setCharacterEncoding("UTF-8");
		//�Ϲ����� ��Ȳ(ajax �ĺ��ڰ� ���� ���)
		if(ajaxHeader == null){
			request.setAttribute("errorMsg", accessDeniedException);
			request.getRequestDispatcher(errorPage).forward(request, response);
		}
		//ajax ��Ȳ
		else{
			if(ajaxHeader.equals("true")){
				result += "{\"result\":\"fail\",\"message\":\"" + accessDeniedException.getMessage() + "\"}";
			}
			else{
				result += "{\"result\":\"fail\",\"message\":\"Access Denied(Header Value MisMatch)\"}";
			}
		}
		
		response.getWriter().print(result);
		response.getWriter().flush();
	}

}
