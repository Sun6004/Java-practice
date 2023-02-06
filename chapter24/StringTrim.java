package chapter24;

public class StringTrim {
	public static void main(String[] args) {
		String tel1 = "  02";
		String tel2 = "123  ";
		String tel3 = "  1234  ";
		
		//trim()메소드는 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성하고 리턴
		//trim()메소드는 문자열 앞뒤의 공백만 제거할 뿐 중간의 공백은 제거하지 않음
		String tel = tel1.trim()+tel2.trim()+tel3.trim();
		System.out.println(tel);
	}
}
