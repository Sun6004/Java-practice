package threadTest;

//yield() 메소드 연습용 예제
public class ThreadTest09 {
public static void main(String[] args) {
	YieldThread th1 = new YieldThread("1번 쓰레드");
	YieldThread th2 = new YieldThread("2번 쓰레드");
	
	th1.start();
	th2.start();
	
	try {
		Thread.sleep(5);
	} catch (InterruptedException e) {
	}System.out.println("11111111111111111");
	th1.work = false;
	try {
		Thread.sleep(5);
	} catch (InterruptedException e) {
	}System.out.println("2222222222222222222222222");
	th1.work = true;
	try {
		Thread.sleep(5);
	} catch (InterruptedException e) {
	}System.out.println("3333333333333333333333");
	
}
}
//yield() 연습용 쓰레드
class YieldThread extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public YieldThread(String name) {
		super();
	}
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println(getName() + "작업중");
			}else {
				System.out.println(getName()+ "양보");
				Thread.yield();
			}
			
		}
	}
}
