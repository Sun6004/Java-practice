package chapter19;

public class Television implements RemoteControl {
	//필드
	int volume;

	//추상메소드의 실체 메소드
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	
	//인터페이스 상수를 이용해서 volume필드의 값을 제한.
	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME){
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV볼륨: " + this.volume);	
	}
	
}
