package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ��� ó��");
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		
		boardDAO.updateBoard(vo);		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		
		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�� �� ��ȸ ó��");
		
		//Model ��ü�� RequestServlet ������ �����ҿ� ����
		// RequestServlet ������ �����ҿ� �����ϴ°Ͱ� �����ϰ� ����
		// request.setAttribute() == model.addAttribute()
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	//@RequestParam : Command ��ü�� VO�� ���ΰ��� ���� ����� �Է������� ���� �޾Ƽ� ó��
	// 				value : ȭ�����κ��� ���޵� �Ķ���� �̸�
	//				requied : �������ɿ���
	public String getBoardList(
//			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�� ��� �˻� ó��");
		
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}
}
