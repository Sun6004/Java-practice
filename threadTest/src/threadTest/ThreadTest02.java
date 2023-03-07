package threadTest;

public class ThreadTest02 {
	public static void main(String[] args) {
		//멀티 쓰레드 프로그렘
		
		//Thread를 사용하는 방법
		
		//방법1
		//Thread클래스를 상속한 class의 인스턴스를 생성한 후 이 class의 인스턴스의 start()메소드를 호출하여 실행
		
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		//방법2
		//Runnable인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성한다.
		//그리고 이 인스턴스를 Thread 객체를 생성할 때 생성자의 인수값으로 넣어서 생성한다.
		//이 때 생성된 Thread 객체의 start()메소드를 호출해서 실행한다.
		MyRunnable r = new MyRunnable();
		Thread th2 = new Thread(r);
		th2.start();
		
		//방법2-2
		//Runnable 인터페이스를 익명 구현체로 작성하여 처리하기
		Runnable r2 = new Runnable() {	
			
			@Override
			public void run() {
				for (int i = 1; i <=100; i++) {
					System.out.print("%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		Thread th3 = new Thread(r2);
		th3.start();
	}
}


//방법1 => Thread를 상속한 class작성하기
class MyThread1 extends Thread{
	@Override
	public void run() {
		//이 run()메소드는 쓰레드가 처리할 내용을 기술하는 곳이다.
		for (int i = 1; i <=100; i++) {
			System.out.print("*");
			try {
				//Thread.sleep(시간)메소드 => 주어진 시간동안 잠시 멈춤 (1000 = 1초)
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}
//방법2 => Runnable인터페이스를 구현한 class작성하기
class MyRunnable implements Runnable{
	@Override
	public void run() {
		for (int i = 1; i <=100; i++) {
			System.out.print("$");
			try {
				//Thread.sleep(시간)메소드 => 주어진 시간동안 잠시 멈춤 (1000 = 1초)
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}
