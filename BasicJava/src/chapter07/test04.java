package chapter07;

import java.io.StreamCorruptedException;

public class test04 {

	public static void main(String[] args) {
		// 문자열 비교
		String var1 = "신민철";
		String var2 = "신민철";
		
		if(var1 == var2) {
			System.out.println("참조가같음");
		}else {
			System.out.println("참조가다름");
		}
		
		if(var1.equals(var2)) {
			System.out.println("문자열이 같음");
		}
		
		String var3 = new String("신민철");
		String var4 = new String("신민철");
		
		if(var3 == var4) {
			System.out.println("참조가같음");
		}else {
			System.out.println("참조가다름");
		}
		
		if(var3.equals(var4)) {
			System.out.println("문자열이같음");
		}
		
		//값 목록으로 배열생성
		int[]score = {83,90,87};
		
		System.out.println("score[0]: " + score[0]);
		System.out.println("score[1]: " + score[1]);
		System.out.println("score[2]: " + score[2]);
		
		int sum= 0;
		for(int i =0; i<3; i++) {
			sum+= score[i];
		}
		System.out.println("총합: " +sum);
		double avg = (double) sum/3;
		System.out.println("평균: " +avg);
		
		//배열생성2
		int[]scores;
		scores = new int[] {83,90,87};
		int sum1 = 0;
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합:" +sum1);
		
		int sum2 = add (new int[] {83,90,87});
		System.out.println("총합: "+sum2);
		//소수점 반올림
		double avg2 = (double) sum2 /3;
		System.out.println("평균: " + Math.round(avg2)); //첫째자리반올림
		System.out.println("평균: " + Math.round(avg2 * 10) / 10.0);//둘째자리
		System.out.println("평균: " + Math.ceil(avg2*100)/100.0);//올리기
		System.out.println("첫째 자리 버림 : " + Math.floor(avg2)); //버리기
		System.out.println("넷째 자리 버림 : " + Math.floor(avg2 * 1000) / 1000.0);
			
	
		}
	//총합을 계산해서 리턴하는 메소드
	// add(new int)시 사용
	public static int add(int[]scores) {
		int sum3 = 0;
		for (int i=0; i<3; i++) {
			sum3 += scores[i];
		}
		return sum3;
	}

	}
	


