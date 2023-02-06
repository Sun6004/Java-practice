package chapter24;

public class StringIndex {
	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		//indexOf 매개값으로 주어진 문자열이 시작하는 인댁스 리턴
		
		if(subject.indexOf("자바")!= -1) { //내가 찾고자하는 문자열이 없으면 -1 해봄
			System.out.println("자바와 관련된 책");
		}else {
			System.out.println("자바와 관련없는 책");
		}
	}
}
