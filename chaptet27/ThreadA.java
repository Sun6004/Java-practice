package chaptet27;

public class ThreadA extends Thread{
	public ThreadA() {
		setName("ThreadA");//스레드 이름설정
	}
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName()+"가 출력한내용");
			 
		}
	}
}
