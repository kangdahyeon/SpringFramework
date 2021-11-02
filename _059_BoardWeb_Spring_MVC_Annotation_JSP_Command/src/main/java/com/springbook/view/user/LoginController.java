package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


//Springframework에서 제공하는 Controller interface 의 handleRequest메소드는 리턴타입이 ModelAndView로 되어있음.
@Controller
public class LoginController {
	// @RequestMapping(value="/login.do", method=RequestMethod.GET)
	@GetMapping(value="login.do")
	// userVO의 이름으로 Command객체 생성
	// 이름을 지정 안할 시에 자동으로 첫글자가 소문자로 변경된 이름으로 생성됨.
	// Command의 이름 지정 : @ModelAttribute("user") -> user의 Command객체 생성
	public String loginView(@ModelAttribute("user")UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		// 로그인화면으로 이동시 처음 입력값 세팅
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
		
	}
	
	// GET방식으로 오면 로그인화면으로 POST방식으로 요청이 오면 로그인처리
	// @RequestMapping(value="/login.do", method=RequestMethod.POST)
	@PostMapping(value="/login.do")
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
