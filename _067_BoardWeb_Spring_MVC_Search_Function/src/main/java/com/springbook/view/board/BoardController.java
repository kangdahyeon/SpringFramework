package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
// board�� �� model�� ����� ��ü�� ������ Httpsession���� �����ͺ����ҿ��� ������ Ű��(board)�� ���� 
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
//	 @ModelAttribute : 1. Command ��ü �̸� ���� 2. View(JSP) ���� ����� ������ ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		// ���ϰ��� RequestServlet�����ͺ����ҿ� ����� ->conditionMap�̶�� Ű������ �����Ͱ� ���� 
		return conditionMap;
	}
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("�� ��� ó��");
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	// ModelAttribute�� ���ǿ� board��� �̸����� ����� ��ü�� �ִ��� ã�Ƽ�  Command��ü�� �����
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("�� ���� ó��");
		System.out.println("�Ϸù�ȣ :" +vo.getSeq());
		System.out.println("���� :" +vo.getTitle());
		System.out.println("�ۼ����̸� :" +vo.getWriter());
		System.out.println("���� :" +vo.getContent());
		System.out.println("����� :" +vo.getRegDate());
		System.out.println("��ȸ�� :" +vo.getCnt());
		boardService.updateBoard(vo);		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�� ���� ó��");
		
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("�� �� ��ȸ ó��");
		
		//Model ��ü�� RequestServlet ������ �����ҿ� ����
		// RequestServlet ������ �����ҿ� �����ϴ°Ͱ� �����ϰ� ����
		// request.setAttribute() == model.addAttribute()
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	//@RequestParam : Command ��ü�� VO�� ���ΰ��� ���� ����� �Է������� ���� �޾Ƽ� ó��
	// 				value : ȭ�����κ��� ���޵� �Ķ���� �̸�
	//				requied : �������ɿ���
	public String getBoardList(
//			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			BoardVO vo, Model model) {
		System.out.println("�� ��� �˻� ó��");
		
		// null check
		// �α��� ȭ�鿡�� �α��� ���� �� getBoardList.do �� ȣ�� �� �� searchKeyword, searchCondition ���� null ���� 
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
}
