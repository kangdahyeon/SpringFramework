package com.springbook.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardServiceClient {

	public static void main(String[] args) {
		//EntityManager생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("_078_JPAProject");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA글 등록 테스트 중입니다");
			
			em.persist(board);
			
			String jpql = "select b from board b order by b.seq desc";
			
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			for(Board brd : boardList) {
				System.out.println("---->" + brd.toString());
			}
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			// 트랜잭션 롤백
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
