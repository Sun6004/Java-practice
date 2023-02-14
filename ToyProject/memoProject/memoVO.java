package memoProject;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class memoVO {

	private String no;
	private String title;
	private String content;
	
	public memoVO(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}


	public memoVO(String no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
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


	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
	
	
	public String toString() {
		return String.format("%d\t%d\t%d\t",  no, title, content);
	}
	
	
}
