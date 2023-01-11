package chapter08;

import java.util.Random;

public class test01 {

	public static void main(String[] args) {
		//break /continue(skip)
		Random random = new Random();
		while(true) {
			
			int num = random.nextInt(6)+1;
			System.out.println(num);
			if(num == 6) {
				break;
			}
			
		}
		System.out.println("프로그램 종료");
		
		//바깥쪽 반복문 종료
		Outter: for(char upper = 'A'; upper<='Z'; upper++) {
			for(char lower='a'; lower<='z'; lower++) {
				System.out.println(upper+"-"+lower);
				if(lower=='g') {
					break Outter;
				}
			}
		}
		System.out.println("프로그램 실행 종료");
		
		//continue
		for(int i=1; i<=10; i++) {
			if(i%2 !=0) {
				continue; //2로나눈 나머지가 0이 아닐경우 조건식으로이동
			}
			System.out.println(i);
		}
		
		
		

	}

}
