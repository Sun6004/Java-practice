package chapter18;

public class Tiger extends Animal{
	public Tiger() {
		this.kind = "포유류";
	}
	
	//추상 메소드 재정의
	public void sound() {
		System.out.println("어흥");
	}
}
