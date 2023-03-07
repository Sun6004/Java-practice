package threadTest;

public class ThreadTest03 {
	public static void main(String[] args) {
		//Thread가 실행되는 시간 체크해보기
		Thread th = new Thread(new MyRunner2());
		
		//System.currentTimeMillis() 메소드 => 표준시간으로부터 실행된 시점까지 경과한 시간을 밀리세컨드(1/1000) 단위로 반환한다
		long startTime = System.currentTimeMillis();
		th.start();
		try {
			th.join(); //현재 위치에서 대상이 되는 쓰레드(변수 th 쓰레드)가 끝날때까지 기다린다.
		} catch (InterruptedException e) {
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간: " +(endTime - startTime));
	}
}

class MyRunner2 implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for (long i = 1L; i <= 2_000_000_000; i++) {
			sum += i;
		}
		System.out.println("합계: " +sum);
	}
}