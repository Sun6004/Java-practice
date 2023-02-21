package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	public static void main(String[] args) {
		/*
		 * Stack => 후입선출의 자료구조 (자료가 쌓여 나중에 들어간 자료가 위에 위치하기 때문에 먼저 나옴)
		 * 
		 * 					----------------------------
		 * Queue =>   입>	   8  7  6  5  4  3  2  1     출>  (선입선출 자료구조)		 * 				  	
		 * 					----------------------------
		 */
		
		/*
		 * Stack의 명령
		 * 1) 자료입력: push(입력값)
		 * 2) 자료출력: pop() => 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제
		 * 				peek() => 삭제없이 자료를 꺼내옴(꺼내서 사용전에 미리꺼내서 검사하기위해 사용)
		 */
		
		Stack<String> st = new Stack<>();
		st.push("asd");
		st.push("zxc");
		st.push("zzz");
		st.push("kkk");
		st.push("^^");
		
		System.out.println("현재 Stack: " + st);
		
		String data = st.pop();
		System.out.println("꺼내온값: "+data);
		System.out.println("꺼내온값: "+st.pop());
		
		System.out.println("입력한값: "+st.push("-_-"));
		System.out.println("남은Stack: " + st);
		System.out.println("꺼내온값: "+st.pop());
		
		//peek
		System.out.println("삭제없이 꺼내온값: "+st.peek());
		System.out.println("Stack: "+st);
		System.out.println();
		System.out.println("--------------------------------------------");
		System.out.println();
		
		/*
		 * Queue의 명령
		 * 1) 자료입력: offer(입력값)
		 * 2) 자료출력: poll() ==> 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
		 * 				peek() ==> 삭제없이 자료를 꺼내온다.
		 * Queue는 LinkedList를 이용해서 사용할 수 있다.
		 */
		Queue<String> q = new LinkedList<>();
		
		//자료저장
		q.offer("홍길동");
		q.offer("일지매");
		q.offer("성춘향");
		q.offer("변학도");
		q.offer(">_<");
		
		System.out.println("현재 Queue값: "+q);
		
		System.out.println("꺼내온값: "+q.poll());
		System.out.println("꺼내온값: "+q.poll());
		System.out.println("꺼내온값: "+q.poll());
		
		System.out.println("현재 Queue값: "+q);
		q.offer("홍길동");
		q.offer("일지매");
		System.out.println("현재 Queue값: "+q);
		System.out.println("삭제없이 꺼내온 값: "+q.peek());
		System.out.println("삭제없이 꺼내온 값: "+q.peek());
		System.out.println("삭제없이 꺼내온 값: "+q.peek());
		System.out.println("현재 Queue값: "+q);


	}
}
