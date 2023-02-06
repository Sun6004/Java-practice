package chapter24;

public class StringEquals {
	public static void main(String[] args) {
		String var1 = new String("신민철");
		String var2 = "신민철";
		
		if(var1 == var2) {
			System.out.println("같은 String 객체를 참조");
		}else {
			System.out.println("다른 String 객체를 참조");
		}
		
		if(var1.equals(var2)) {
			System.out.println("같은 문자열");
		}else {
			System.out.println("다른 문자열");
		}
		
	}
}
