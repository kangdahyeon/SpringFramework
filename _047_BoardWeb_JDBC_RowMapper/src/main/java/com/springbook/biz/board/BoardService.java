package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	// CRUD����� �޼ҵ� ����
	// �۵��
	void insertBoard(BoardVO vo);
	
	// �� ����
	void updateBoard(BoardVO vo);
	
	// �ۻ���
	void deleteBoard(BoardVO vo);
	
	//�� �󼼸��
	BoardVO getBoard(BoardVO vo);
	
	// �۸��
	List<BoardVO> getBoardList(BoardVO vo);

}
