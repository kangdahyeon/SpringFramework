package com.springbook.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� ��� �˻� ó��");
		
		// ModelAndView ��ü�� ������ ���
		mav.addObject("boardList", boardDAO.getBoardList(vo));
		// ModelAndView ��ü�� view ���
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
}
