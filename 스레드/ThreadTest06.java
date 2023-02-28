package threadTest;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
	}
}

//데이터를 입력하는 쓰레드
class DataInput extends Thread{
	// 입력 여부를 확인하기 위한 변수선언 - 두 쓰레드에서 공통으로 사용할 변수
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("입력하시오");
		
		inputCheck = true; //입력이 완료되면 true를 반환
		
		System.out.println("입력한 값: "+str);
	}
}

//카운트다운을 진행하는 쓰레드
class CountDown extends Thread{
	@Override
	public void run() {
		System.out.println("count down");
		for (int i = 10; i >=1; i--) {
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되었으면 쓰레드를 종료시킨다.
			if (DataInput.inputCheck ==true) {
				return; //run()메소드가 종료되면 해당 쓰레드도 종료됩니다.
			}
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Time over");
		System.exit(1);
	}
}