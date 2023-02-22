package kr.or.ddit.basic;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Browser b = new Browser();
		b.history();
		b.goUrl("www.naver.com");
		b.history();
		
		b.goUrl("www.google.com");
		b.history();
		
		b.goUrl("www.daum.com");
		b.goUrl("www.youtube.com");
		b.history();
		
		System.out.println("<뒤로가기>");
		b.goBack();
		b.history();
		System.out.println("<뒤로가기>");
		b.goBack();
		b.history();
		
		System.out.println("<앞으로가기>");
		b.goForward();
		b.history();
		
		System.out.println("<새로운 사이트로 이동>");
		b.goUrl("www.Netflex.com");
		b.history();
		
	}
}

//웹브라우저의 앞으로가기, 뒤로가기 기능 구현하기(스택이용)
class Browser{
	private Stack<String> back; //이전 방문내역이 저장될 스택
	private Stack<String> forward; //다음 방문내역이 저장될 스택
	private String currentUrl; // 현재 페이지가 저장될 변수
	
	//생성자
	public Browser(){
		back = new Stack<>();
		forward = new Stack<>();
		currentUrl = "";
	}
	
	//사이트를 방문하는 메소드 ==> 매개변수에는 방문할 URL이 저장된다.
	public void goUrl(String url) {
		System.out.println(url+"사이트로 이동합니다...");
		
		//현재 페이지가 있는지 검사
		if(currentUrl != null && !" ".equals(currentUrl)) { //현재 페이지가 있으면
			back.push(currentUrl); //현재 페이지를 back Stack에 추가한다.
		}
		
		currentUrl = url; //현재 페이지를 이동할 페이지로 변경한다.
		forward.clear(); //새로운 페이지를 열었을때, forward 초기화
	}
	
	//뒤로가기 기능
	public void goBack() {
		// isEmpty() ==> 컬렉션이 비었는지 여부를 검사하는 메소드
		if(!back.isEmpty()) { //back 스택이 비어있는지 검사
			forward.push(currentUrl); //현재 페이지를 forward스택에 추가
			currentUrl = back.pop(); // back스택에서 꺼내온 데이터가 현재 페이지가됨
		}
	}
	
	public void goForward() {
		if(!forward.isEmpty()) { //forward 스택이 비어있지 않은지 검사
			back.push(currentUrl); //현재 페이지를 back에 추가
			currentUrl = forward.pop(); //forward스택에서 꺼내온 데이터가 현재 페이지가됨
		}
	}
	
	//방문기록을 확인하는 메소드
	public void history() {
		System.out.println();
		System.out.println();
		System.out.println("방문기록");
		System.out.println("---------------------------");
		System.out.println("back: " +back);
		System.out.println("현재: " +currentUrl);
		System.out.println("froward: " +forward);
		System.out.println("---------------------------");
		System.out.println();

	}
}