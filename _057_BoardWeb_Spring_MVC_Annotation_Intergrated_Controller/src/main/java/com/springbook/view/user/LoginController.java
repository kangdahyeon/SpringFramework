package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


//Springframework���� �����ϴ� Controller interface �� handleRequest�޼ҵ�� ����Ÿ���� ModelAndView�� �Ǿ�����.
@Controller
public class LoginController {
	@RequestMapping(value="/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		
		System.out.println("�α��� ó��");
	
		if(userDAO.getUser(vo) != null) {
			
			return "redirect:getBoardList.do";
			// �α��� ���н� �α���ȭ������ �̵�
		} else {
			return "login.jsp";
		}
	}
}
