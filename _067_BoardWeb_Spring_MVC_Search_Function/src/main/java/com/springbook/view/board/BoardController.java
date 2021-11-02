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
// board로 된 model에 저장된 객체가 있으면 Httpsession에도 데이터보관소에서 동일한 키값(board)로 저장 
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
//	 @ModelAttribute : 1. Command 객체 이름 지정 2. View(JSP) 에서 사용할 데이터 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		// 리턴값은 RequestServlet데이터보관소에 저장됌 ->conditionMap이라는 키값으로 데이터가 저장 
		return conditionMap;
	}
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	// ModelAttribute로 세션에 board라는 이름으로 저장된 객체가 있는지 찾아서  Command객체에 담아줌
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 수정 처리");
		System.out.println("일련번호 :" +vo.getSeq());
		System.out.println("제목 :" +vo.getTitle());
		System.out.println("작성자이름 :" +vo.getWriter());
		System.out.println("내용 :" +vo.getContent());
		System.out.println("등록일 :" +vo.getRegDate());
		System.out.println("조회수 :" +vo.getCnt());
		boardService.updateBoard(vo);		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		
		//Model 객체를 RequestServlet 데이터 보관소에 저장
		// RequestServlet 데이터 보관소에 저장하는것과 동일하게 동작
		// request.setAttribute() == model.addAttribute()
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	//@RequestParam : Command 객체인 VO에 매핑값이 없는 사용자 입력정보는 직접 받아서 처리
	// 				value : 화면으로부터 전달된 파라미터 이름
	//				requied : 생략가능여부
	public String getBoardList(
//			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		
		// null check
		// 로그인 화면에서 로그인 성공 시 getBoardList.do 를 호출 할 때 searchKeyword, searchCondition 값의 null 방지 
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
