package com.innospeech.customManager.config;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.innospeech.customManager.model.Users;

import lombok.extern.log4j.Log4j2;

@SuppressWarnings("deprecation")
@Component
public class Intercepter extends HandlerInterceptorAdapter  {
	
	@Override   //true 면 다음 controller로 수행 false면 다음 컨트롤러 로 안넘어가게함
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result =true;
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("LOGIN");
		
		if(user==null) {
			response.sendRedirect("/main.do");
			result =false;
		}
		return result;
	}
	
	//controller 처리 이후 이벤트 작동
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//log.info("================================ END ================================");
	}
	
	//view 처리 이후 이벤트 작동
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
}
