package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


//Springframework에서 제공하는 Controller interface 의 handleRequest메소드는 리턴타입이 ModelAndView로 되어있음.
public class LoginController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("로그인 처리");
		// 1. 사용자 입력 정보 추출(login.jsp에서 전송한 id, password 받기)
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB연동처리(UserDAO의 메소드 호출)
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션(로그인 후 화면 이동처리)
		// DB연동 후 리턴받은 데이터와 View를 모두 담을 수 있는 객체
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			
			mav.setViewName("redirect:getBoardList.do");
			// 로그인 실패시 로그인화면으로 이동
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}
}
