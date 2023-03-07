package threadTest;

public class DaemonThread1 {
 // 일반 쓰레드의 작업을 돕는 보조적인 역할을 수행
 // 일반 쓰레드가 모두 종료되면 자동적으로 종료
 // 가비지컬렉터, 자동저장, 화면자동갱신 등에 사용
 // 무한루프와 조건문을 이용해 실행 후, 대기하다가 특정조건이 만족하면 작업을 수행하고 다시 대기하도록 작성
	
	public static void main(String[] args) {
		AutoSavaing auto = new AutoSavaing();
		
		//데몬 쓰레드로 설정하기 ==> 반드시 start()메소드를 호출하기 전에 설정해야 한다.
		auto.setDaemon(true);
		
		auto.start();
		
		try {
			for (int i = 0; i <= 20 ; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("쓰레드 종료");
		
	}
}

//자동 저장하는 쓰레드( 3초에 한번씩 자동 저장하는 쓰레드)
class AutoSavaing extends Thread{
	//작업 내용을 저장하는 메소드
	public void save() {
		System.out.println("작업 내용을 저장합니다.");
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			save();
		}
	}
}