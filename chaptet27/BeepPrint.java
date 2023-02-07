package chaptet27;

public class BeepPrint {
	public static void main(String[] args) {
		Runnable beepTest = new BeepTest(); //Runnable : 구현 객체를 만들어 대입해야하는 인터페이스 타입의 스레드객체
		Thread thread = new Thread(beepTest); //작업 스레드 생성
		
		thread.start();  //BeepTest run을 start
		
		
		for (int i = 0; i <5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
		thread.setName("Beep"); // 스레드이름설정
		System.out.println(thread.getName());
	}
}
