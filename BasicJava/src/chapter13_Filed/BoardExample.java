package chapter13_Filed;

public class BoardExample {

	public static void main(String[] args) {
		Board board1 = new Board("제목","내용");
		Board board2 = new Board("제목","내용","홍길동");
		Board board3 = new Board("제목","내용","홍길동","2025-12-31");
		Board board4 = new Board("제목","내용","홍길동","2025-12-31333",0);
	
		board1.info();
		
		board2.info();
		
		board3.info();
		
		board4.info();
		
		
	}
}
