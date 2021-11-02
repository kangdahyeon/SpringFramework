package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	// CRUD기능의 메소드 구현
	// 글등록
	void insertBoard(BoardVO vo);
	
	// 글 수정
	void updateBoard(BoardVO vo);
	
	// 글삭제
	void deleteBoard(BoardVO vo);
	
	//글 상세목록
	BoardVO getBoard(BoardVO vo);
	
	// 글목록
	List<BoardVO> getBoardList(BoardVO vo);

}
