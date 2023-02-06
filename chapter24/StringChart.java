package chapter24;

public class StringChart {
	public static void main(String[] args) {
		String ssn = "020521-4234567";
		//charAt():문자열 길이에서 매개값으로 주어진 인덱스의 문자를 리턴
		//char로 반환
		char sex = ssn.charAt(7);//7번째 인덱스가
		switch (sex) {
		case '1':
		case '3':
			System.out.println("남자 입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자 입니다.");
			break;
		}
	}
}
