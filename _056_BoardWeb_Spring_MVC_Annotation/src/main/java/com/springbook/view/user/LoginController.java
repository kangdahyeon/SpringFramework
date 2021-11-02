package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


//Springframework에서 제공하는 Controller interface 의 handleRequest메소드는 리턴타입이 ModelAndView로 되어있음.
@Controller
public class LoginController {
	@RequestMapping(value="/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		
		System.out.println("로그인 처리");
	
		if(userDAO.getUser(vo) != null) {
			
			return "redirect:getBoardList.do";
			// 로그인 실패시 로그인화면으로 이동
		} else {
			return "login.jsp";
		}
	}
}
