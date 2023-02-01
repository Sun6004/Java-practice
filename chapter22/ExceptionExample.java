package chapter22;

public class ExceptionExample {
	public static void main(String[] args) {
		
		//일반예외(Exception)
		//Class.forName("java.lang.String");
		
		
		//실행 예외 = (Runtime Exception)
		//실행해봐야 알수있음
		String name = null;
		//if(name != null) {  <= 예외처리코드
		System.out.println(name.contains("홍"));
		//}
	}
}
