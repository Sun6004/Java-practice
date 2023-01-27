package chapter17;

public class Hankook extends Tire{
	//fild
	
	//생성자
	public Hankook(String location, int maxRotation) {
		super(location,maxRotation);
	}
	
	//메소드
	public boolean roll() {
		++accRotation;
		if(accRotation < maxRotation) {
			System.out.println(location + "한국타이어 수명"+(maxRotation-accRotation)+"회");
			return true;
		}else {
			System.out.println("***" + location+"한국타이어 펑크***");
			return false;
		}
	}
}
