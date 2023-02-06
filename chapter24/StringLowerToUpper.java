package chapter24;

public class StringLowerToUpper {
	public static void main(String[] args) {
		String str1 = "Java Programing";
		String str2 = "JAVA Programing";
		
		System.out.println(str1.equals(str2));
		
		//toLower/toUpper Case()메소드는 두 문자열을 대소문자와 관계없이 비교할때 사용
		//equalsIgnoreCase()메소드를 사용하면 위를 생략하고 equals비교가능
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2));
		
		System.out.println(str1.equalsIgnoreCase(str2));
	}
}
