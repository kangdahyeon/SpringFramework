package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.Criteria;
import com.springbook.biz.board.PageVO;

@Controller
//board�� model ����� ��ü�� ������ HttpSession ������ �����ҿ��� ������ Ű ��(board)�� ����
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//@ModelAttribute : 1. Command ��ü �̸� ����
	//					2. View(JSP)���� ����� ������ ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		//���� ���� ReqeustServlet ������ �����ҿ� ����
		//conditionMap�̶�� Ű ������ �����Ͱ� ����
		return conditionMap;
	}
	
	@RequestMapping(value="/insertBoard.do")
	//Command ��ü : ����ڰ� ������ �����͸� ������ VO�� �ٷ� ����
	//				����� �Է� ���� �������� �ڵ尡 ������� ������ ����ȭ ����
	//              ����� �Է� input�� name �Ӽ��� VO ��������� �̸��� �������ִ� ���� �߿�
	public String insertBoard(BoardVO vo) throws IOException {
		System.out.println("�� ��� ó��");
		
		//���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/Dev211/" + fileName));
		}
		
		boardService.insertBoard(vo);
		
		//ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
		return "redirect:getBoardList.do";
	}
	
	//ModelAttribute�� ���ǿ� board��� �̸����� ����� ��ü�� �ִ��� ã�Ƽ� Command��ü�� �����
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("�� ���� ó��");
		System.out.println("�Ϸù�ȣ : " + vo.getSeq());
		System.out.println("���� : " + vo.getTitle());
		System.out.println("�ۼ��� �̸� : " + vo.getWriter());
		System.out.println("���� : " + vo.getContent());
		System.out.println("����� : " + vo.getRegDate());
		System.out.println("��ȸ�� : " + vo.getCnt());
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
	public String getBoard(BoardVO vo, Model model, Criteria cri) {
		System.out.println("�� �� ��ȸ ó��");
		
		System.out.println(cri.getPageNum());
		System.out.println(cri.getAmount());
		//Model ��ü�� RequestServlet ������ �����ҿ� ����
		//RequestServlet ������ �����ҿ� �����ϴ� �Ͱ� �����ϰ� ����
		//request.setAttribute("board", boardDAO.getBoard(vo)) == model.addAttribute("board", boardDAO.getBoard(vo))
		model.addAttribute("board", boardService.getBoard(vo));
		model.addAttribute("criteria", cri);
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	//@RequestParam : Command ��ü�� VO�� ���ΰ��� ���� ����� �Է������� ���� �޾Ƽ� ó��
	//				  value = ȭ�����κ��� ���޵� �Ķ���� �̸�(jsp�� input�� name�Ӽ� ��)
	//				  required = ���� ���� ����
	public String getBoardList(BoardVO vo, Model model, Criteria cri) {
		System.out.println("�� ��� �˻� ó��");
		System.out.println(cri.getPageNum());
		System.out.println(cri.getAmount());
		//Null check
		//�α��� ȭ�鿡�� �α��μ��� �� getBoardList.do ȣ�� �� �� searchKeyword, searchCondition ���� null ���� 
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		int total = boardService.selectBoardCount(vo);
		
		model.addAttribute("boardList", boardService.getBoardList(vo, cri));
		model.addAttribute("pageMaker", new PageVO(cri, total));
		return "getBoardList.jsp";
	}
}
