package singletonTest;

public class SingletonTest {
	
	public static void main(String[] args) {
		// MySingleton test1 = new MySingleton(); 외부에서 new로 호출불가
		
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		// 참조값 확인 (두 변수의 주소값 같음)
		System.out.println("test2: " +test2.toString());
		System.out.println("test3: " +test3);	
		System.out.println(test2 == test3);
		System.out.println(test2.equals(test3));
		
		test2.displayTest();
	}
}
