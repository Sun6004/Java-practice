package chaptet27;

import java.awt.Toolkit;

public class BeepTest implements Runnable{
	public void run() {
		
		//스레드 실행 내용
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				//e.printStackTrace(); 에러출력문
			}
		}
	}
}
