package chapter15;

public class Earth {
	//Naming Convention(명명 규칙)
	//상수는 모두 대문자
	//글자 연결시 _를 붙여준다
	static final double PI = 3.14159;
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_AREA = 4 * Math.PI *EARTH_RADIUS * EARTH_RADIUS;
	
	public static void main(String[] args) {
		System.out.println("지구의 반지름: " +EARTH_RADIUS + "Km");
		System.out.println("지구의 표면적: " +EARTH_AREA + "Km^2");
		
	}
}
