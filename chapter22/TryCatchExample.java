package chapter22;

public class TryCatchExample {
	public static void main(String[] args) {
		try { //블록실행 시도
			System.out.println("실행시작");
			Class.forName("java.lang.String");
			System.out.println("실행종료");//정상적으로 코드실행되면 그냥 종료
		} catch (ClassNotFoundException e) { //에러발생시 캐치 / e: 발생한에러 정보를 가지고있는 매개변수
			e.printStackTrace();//에러캐치후 실행 / printStackTrace : 에러정보를 추적하여 print
			//지우면 에러표시 숨기기 가능
		} finally {
			System.out.println("에러와 관계없이 반드시실행");
			//에러 발생여부와 상관없이 항상 실행해야하는 내용 (생략가능)
			//위에 return;이 있어도 무조건 실행됨
			//scanner.close(); 와 같이 반드시 반납해야하는 자원을 쓰기위해 존재
		}
		
	}
}
