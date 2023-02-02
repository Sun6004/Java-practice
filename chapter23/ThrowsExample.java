package chapter23;

public class ThrowsExample {
	public static void main(String[] args) throws Exception { //throws Exception하나로 에러를 알아서 던짐
		method();
		//예외 발생시키기 => 예외를 만든다.
		//throw를 사용
		try {
			throw new Exception();//new + 에러이름
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	//throws = 메소드를 실행한 위치로 에러를 떠넘김
	// 에러를 단순 떠넘기는것이기 때문에 어디선가 에러를 반드시 처리해야됨
	public static void method() throws ClassNotFoundException {
		Class.forName("hava.lang.String");
	}
}
