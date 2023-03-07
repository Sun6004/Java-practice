package threadTest;

/*
 *  wait(), notify() 메소드를 이용한 두 쓰레드가 번갈아 한번씩 실행되는 예제
 *  
 *  wait(), notify(), notifyAll()메소드는 동기화 영역에서만 사용 가능하다.
 *  
 */
public class ThreadTest18 {
	public static void main(String[] args) {
		WorkOBJ work = new WorkOBJ();
		
		ThreadA th1 = new ThreadA(work);
		ThreadB th2 = new ThreadB(work);
		
		th1.start();
		th2.start();
	}
}

//공통으로 사용하는 객체
class WorkOBJ{
	public synchronized void testMethodA() {
		System.out.println("testMethodA() 메소드 실행중..");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
	
	public synchronized void testMethodB() {
		System.out.println("testMethodB() 메소드 실행중..");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}

//WorkOBJ의 testMethodA()메소드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkOBJ work;
	
	public ThreadA(WorkOBJ work) {
		this.work = work;
	}
	@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				work.testMethodA();
			}
			//마지막에 Waiting pool에 있는 쓰레드를 깨워주기
			synchronized (work) { //동기화 블럭
				work.notify();				
			}
		}
}

//WorkOBJ의 testMethodB()메소드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkOBJ work;
	
	public ThreadB(WorkOBJ work) {
		this.work = work;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			work.testMethodB();
		}
		synchronized (work) {
			work.notify();				
		}
	}
	}
