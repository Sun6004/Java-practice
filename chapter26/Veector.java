package chapter26;

import java.util.*;


public class Veector {
	public static void main(String[] args) {
		//Vector<E>list = new Vector<E>();//Vector : 멀티 스레드에 안전하게 설계된 클래스(스레드 복습하면 이해하기 쉬움)
		//ArrayList와 비슷하게 동작
		
		Vector<Board> list = new Vector<Board>();
		
		list.add(new Board("제목1" ,"내용1", "글쓴이1"));
		list.add(new Board("제목2" ,"내용2", "글쓴이2"));
		list.add(new Board("제목3" ,"내용3", "글쓴이3"));
		list.add(new Board("제목4" ,"내용4", "글쓴이4"));
		list.add(new Board("제목5" ,"내용5", "글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		
		for (int i = 0; i < list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject + "\t" + board.content +"\t" +board.writer);
			
		}
	}

	
}
