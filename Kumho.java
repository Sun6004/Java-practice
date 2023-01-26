package chapter17;

//상속 관계(is a) KumhoTire is a Tire
public class Kumho extends Tire{
	//필드
	
	//생성자
	public Kumho(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	//메소드
	public boolean roll() {
		++accRotation;
		if(accRotation < maxRotation) {
			System.out.println(location + "금호타이어 수명"+(maxRotation-accRotation)+"회");
			return true;
		}else {
			System.out.println("***" + location+"금호타이어 펑크***");
			return false;
		}
	}
}
