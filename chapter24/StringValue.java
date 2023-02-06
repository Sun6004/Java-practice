package chapter24;

public class StringValue {
	public static void main(String[] args) {
		
		//valuOf()메소드는 기본타입의 값을 문자열로 변환
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);
		
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

	}
}
