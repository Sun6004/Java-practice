package chapter02;

public class StringEx {
	
	//m+ Ctrl +스페이스 : void main 
	public static void main(String[] args) {
		char c = 'A';
		String name = "홍길동";
		String job = "프로그래머";
		
		System.out.println(name);
		System.out.println(job);
		//이스케이프 문자 : \" \" , \t, \n = \r 
		String str = "우리는 \"개발자\"입니다.";
		System.out.println(str);
		System.err.println("번호\t이름\t직업");
		//println : 줄봐꿈해줌 print : 줄봐꿈 안함
		System.out.print("행단위\n 출력");
		
		
		int var1 = 10;
		long var2 = 100;
		long var3 = 10000000000000L;
		/*소수점 double타입 사용
		float 리터럴뒤에f붙여야함
		float 수수점7자리까지 정밀
		double 소수점15자리까지 정밀*/
		double pi = 3.14;
		float var = 3.14f;
		//부동소수점 공부하기
		
	}//

}
