<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>

<%
	// 사용자 입력정보 추철(getBoard.jsp)에서 전송된 정보 추출
	String seq = request.getParameter("seq");

	// DB전송 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(vo);
	
	// 글 삭제 처리 후 글 목록 화면으로 이동
	response.sendRedirect("getBoardList.jsp");
%>