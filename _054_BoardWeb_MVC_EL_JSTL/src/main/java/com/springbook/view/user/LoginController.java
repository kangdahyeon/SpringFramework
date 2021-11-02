package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
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
		if(user != null) {

			return "getBoardList.do";
			// 로그인 실패시 로그인화면으로 이동
		} else {
			return "login";
		}
	}
}
