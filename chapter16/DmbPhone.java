package chapter16;

public class DmbPhone extends Phone {
	// 필드
	int channel;

	// 생성자
	public DmbPhone(String model, String color, int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
	}

	// 메소드
	void turnOnDmb() {
		System.out.println("채널" + channel + "번 방송 수신을 시작합니다.");
	}

	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널" + channel + "번 으로 봐꿉니다.");
	}

	void turnOffDmb() {
		System.out.println("Dmb방송 수신을 멈춥니다.");
	}
}
