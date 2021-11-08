package com.springbook.biz.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Board
 *
 */
// @Entity : 객체를 엔티티 클래스로 선언. 테이블과 1:1 매핑
@Entity
// @Table : 엔티티클래스가 어떤 테이블과 매핑될 지 설정. 기본적으로 엔티티클래스 명으로 된 테이블과 매핑
@Table(name="BOARD")
public class Board {
	// @Id : 테이블의 기본 키 값 설정
	@Id
	// @GeneratedValue : 기본 키 값 자동 생성하여 할당. 데이터베이스마다 방식이 다름.
	// strategy : 기본 키 값 자동 생성 방식 설정
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Board_Seq")
	// @SequenceGenerator : 시퀀스 생성기. 지정한 시퀀스 이름으로 시퀀스 생성
	@SequenceGenerator(name = "Board_Seq", sequenceName = "Board_Seq")
	private int seq;
	private String title;
	private String writer;
	private String content;
	// @Temporal : 날짜 타입을 매핑할 때 사용함
	@Temporal(TemporalType.DATE)
	private Date regDate;
	private int cnt;
	
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
	
}
