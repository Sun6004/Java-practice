package chaptet27;

import java.awt.Toolkit;

public class Beep {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit(); //Toolkit 객체얻기
		for (int i = 0; i < 5; i++) {
			toolkit.beep(); // 비프음 발생
			try {Thread.sleep(500);} catch(Exception e) {}//0.5초간 일시정지
		}//Thread.sleep() : 실행중인 스레드를 잠시 멈출때사용 
		
		for (int i = 0; i <5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);} catch(Exception e) {}
		}
		 
	}
}
