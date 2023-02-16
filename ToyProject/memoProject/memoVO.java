package memoProject;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class memoVO {

	private int no;
	private String title;
	private String content;
	private String writer;
	

	public memoVO(int no, String title) {
		super();
		this.no = no;
		this.title = title;
	}

	public memoVO(int no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}

	public memoVO(int no, String title, String content, String writer) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
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

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

	public String toString() {
		return String.format("%d\t%d\t%d", no, title, content);
	}

}
