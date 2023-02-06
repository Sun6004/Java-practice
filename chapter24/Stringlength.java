package chapter24;

public class Stringlength {
	public static void main(String[] args) {
		String ssn = "7306241230123";
		//length(): 문자열의 길이(문자의 수)를 리턴
		int lenth = ssn.length();
		if(lenth ==13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		}else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
	}
}
