package threadTest;

public class ThreadTest15 {
	public static void main(String[] args) {
		ShareObj sObj = new ShareObj(); //공통 객체 생성
		
		TestThread th1 = new TestThread("TH.01", sObj);
		TestThread th2 = new TestThread("TH.02", sObj);
		
		th1.start();
		th2.start();
	}
}

//공통으로 사용할 클래스
class ShareObj{
	private int sum = 0;
	
	//동기화 처리
	//synchronized메소드 : 동기화 설정(여러개의 쓰래드가 하나의 공통 클래스를 사용할때 동기화
	public synchronized void add() { //방법1 
		
		//방법2 : 동기화 블록으로 처리
		synchronized (this) { // ()안에 동기화 처리할 객체
			
		int n = sum;
		
		n += 10; // 10씩 증가
		
		sum = n;
		
		System.out.println(Thread.currentThread().getName()+" 합계: "+sum);
		}
	}
}

//처리할 쓰레드 클래스
class TestThread extends Thread{
	private ShareObj sObj;

	//생성자
	public TestThread(String name,ShareObj sObj) {
		super(name); //쓰레드 이름 설정
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sObj.add();
		}
	}
	
}