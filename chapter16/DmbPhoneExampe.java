package chapter16;

public class DmbPhoneExampe {

	public static void main(String[] args) {
		// 객체 생성
		DmbPhone dmbphone = new DmbPhone("자바폰", "검정", 10);

		// phone클래스로부터 상속받은 필드
		System.out.println("모델: " + dmbphone.model);
		System.out.println("color: " + dmbphone.color);

		// Dmb 클래스의 필드
		System.out.println("채널: " + dmbphone.channel);

		// Phone클래스로부터 상속받은 메소드 호출
		dmbphone.powerOn();
		dmbphone.bell();
		dmbphone.sendVoice("여보세요.");
		dmbphone.receiveVoice("안녕하세요 저는 홍길동인데요.");
		dmbphone.sendVoice("예 반갑습니다.");
		dmbphone.hangUp();

		// dmbphone 클래스의 메소드 호출
		dmbphone.turnOnDmb();
		dmbphone.changeChannelDmb(12);
		dmbphone.turnOffDmb();

	}

}
