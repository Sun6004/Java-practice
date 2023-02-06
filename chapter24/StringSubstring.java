package chapter24;

public class StringSubstring {
	public static void main(String[] args) {
		String ssn = "880815-1234567";
		//substring() 은 주어진 인덱스에서 문자열을 추출
		//0~6까지의 문자열을 추출
		String firstNum = ssn.substring(0,6);
		System.out.println(firstNum);
		
		//인덱스7부터 끝까지 문자열을 추출
		String secNum = ssn.substring(7);
		System.out.println(secNum);
		
		
	}
}
