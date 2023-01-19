package chapter14;

public class Cal {
	int value;
	static double pi = 3.14159;
	
	static int plus(int x, int y) {
		return x+y;
	}
	void run() {
		System.out.println("계산기 실행완료");
	}
	public static void main(String[] args) {
			
		Cal cal = new Cal();//static이 안붙으면 new클래스를 생성하고 사용해야함
		cal.value = 100;
		int i = Cal.plus(20, 30);//가능은 하지만 static방식으로 접근하지 않았다고 경고
		
		Cal.plus(10,20); //static이 붙으면 바로 사용가능
		
		
	}
}
