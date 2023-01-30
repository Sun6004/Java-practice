package chapter19;

public class SmartTV implements RemoteControl, Searchable{
	int volume;
	
	@Override
	public void serch(String url) {
		System.out.println(url+ "을 검색합니다.");
		
	}

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume= RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV볼륨: " + this.volume);	
		}
	public void search(String url) {
		System.out.println(url+ "을 검색합니다.");
	}

}
