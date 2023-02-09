package Projsct1;

import java.security.Timestamp;

//Vo: Value Object 값을 저장하는 객체
//DTO: Data Transfer Object 저장된 값을 전달하는 객체
//Bean: 자바가 커피에서 따온 이름이라 객체를 Bean으로 표현하기도 함
//Model: 데이터와 관련된 객체를 Model이라고 부르기도 함
//Item: 각각의 데이터를 표현하는 의미로 아이템이라고 부르기도 함
//JavaBeans패턴 vs Builder 패턴 공부해보기

//객체 선언 도구 => Lombok(편하지만 플러그인을 설치해야 함)
//Lombok :꼭 필요하지 않아도 습관적으로 생성하는 코드(boilerplate code)를 없애주는 역할
public class MemoVO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Timestamp registerDate; //시간을 보여주기 위해서 Timestamp사용
	private Timestamp modifyDate;

	//insert할때 사용
	public MemoVO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	//update 할 때 사용
	public MemoVO(int no, String title, String content, String writer) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	//select할 때 사용
	public MemoVO(int no, String title, String content, String writer, Timestamp registerDate, Timestamp modifyDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.registerDate = registerDate;
		this.modifyDate = modifyDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s",no,title,content,writer,registerDate,modifyDate);
	}
	
}
