package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŭ���̾�Ʈ�� �����ϴ� �����Ͱ� �ѱ��� ��� ���������� 
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŭ���̾�Ʈ ��û path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		// http://localhost:9900/biz/login.do
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// Ŭ���̾�Ʈ ��û path�� ���� �б�ó���Ѵ�.
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó��");
			// 1. ����� �Է� ���� ����(login.jsp���� ������ id, password �ޱ�)
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB����ó��(UserDAO�� �޼ҵ� ȣ��)
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			// 3. ȭ�� �׺���̼�(�α��� �� ȭ�� �̵�ó��)
			if(user != null) {
				response.sendRedirect("getBoardList.do");
				// �α��� ���н� �α���ȭ������ �̵�
			} else {
				response.sendRedirect("login.jsp");
			}
		} else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("login.do");
			
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
			
			// ����� �Է����� ����
			String title = request.getParameter("title");
			String writer = request.getParameter("wirter");
			String content = request.getParameter("content");
			
			// DB����ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
			
			// ����� �Է����� ����(getBoard.jsp���� ���۵� ���� ����)
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			// DB���� ó��(BoardDAO�� �޼ҵ� ȣ��)
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			vo.setTitle(title);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// ȭ�� �׺���̼�
			// ����ó�� �� �� ���ȭ������ �̵�
			response.sendRedirect("gerBoardList.do");
			
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
			String seq = request.getParameter("seq");

			// DB���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// �� ���� ó�� �� �� ��� ȭ������ �̵�
			response.sendRedirect("getBoardList.do");
			
			// �� ���� ó�� �� �� ��� ȭ������ �̵�
			response.sendRedirect("getBoardList.jsp");
			
		} else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ó��");
			
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			// �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.
			HttpSession session = request.getSession();
			
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			// �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
	}

}
