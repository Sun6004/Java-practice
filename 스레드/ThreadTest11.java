package threadTest;

import java.util.Random;

/*
 *  3개의 쓰레드가 각각 알파벳 A~Z까지를 출력하는데 
 *  출력을 끝낸 순서대로 결과를 나타내는 프로그램 만들기
 */ 
public class ThreadTest11 {
	public static void main(String[] args) {
		DisplayCharacter[] charArr = new DisplayCharacter[] {
				new DisplayCharacter("홍길동"),
				new DisplayCharacter("이순신"),
				new DisplayCharacter("강감찬")
		};
		
		for(DisplayCharacter dc : charArr) {
			dc.start();
		}
		for(DisplayCharacter dc : charArr) {
			try {
				dc.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println();
		System.out.println("경기결과");
		System.out.println("순위: " + DisplayCharacter.ranking);
		System.out.println();
	}
}

//알파벳을 출력하는 쓰레드
class DisplayCharacter extends Thread{
	public static String ranking = " ";
	private String name;
	
	public DisplayCharacter(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		Random rd = new Random();
		for (char c ='A'; c<='Z'; c++) {
			System.out.println(name+ "의 출력 문자: " +c);
			try {
				Thread.sleep(rd.nextInt(100)); //일시정지 시간을 난수로 지정
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("-------------------------------");
		System.out.println(name + "의 출력 끝");
		
		//출력을 끝낸 순서대로 이름을 배치
		DisplayCharacter.ranking += name+ "";
	}
}