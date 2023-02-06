package chapter24;

public class StringReplace {
	public static void main(String[] args) {
		String oldstr = "자바는 객체지향 언어입니다. 자바는 풍부한API를 지원합니다.";
		//replace(): 첫번째 문자열을 두번째 매개값인 문자열로 대치한 새로운 문자열을 생성
		//String문자열은 수정이 불가능하기 때문에 새로운 문자열이기떄문에 newStr
		String newstr = oldstr.replace("자바", "JAVA");
		System.out.println(oldstr);
		System.out.println(newstr);
		
		System.out.println("홍길동".contains("동1"));
		"자바 프로그래밍".replace("자바","JAVA");
		//정규 표현식(Regular Expression) 패턴을 분석해서 대치
	}
}
