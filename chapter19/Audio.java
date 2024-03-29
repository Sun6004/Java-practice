package chapter19;

public class Audio implements RemoteControl {
	//필드
	private int volume;
	
	public void turnOn() {
		System.out.println("오디오를 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("오디오를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		
		System.out.println("현재 Audio볼륨: " +this.volume);
	}
}
