package chapter19;

public class MyClass {
	
	//필드
	RemoteControl rc = new Television();
	
	MyClass(){
		
	}
	
	//생성자
	MyClass(RemoteControl rc){
		this.rc = rc;
		rc.turnOn();
		rc.setVolume(5);
	}
	//메소드
	void methodA() {
		//로컬변수
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
	}
	
	//생성자의 매개값으로 구현 객체 대입
	void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(5);
	}
}
