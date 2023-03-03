package threadTest;

import java.util.Random;

import javax.swing.JOptionPane;

public class ThreadTest07 {
	
	//컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오.
	//컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
	//사용자의 가위 바위 보는 showInputDialog() 메소드를 이용하여 입력받는다
	//입력시간은 5초로 제한하고 카운트 다운을 진행한다.
	//5초안에 입력이 없으면 게임에 진것으로 처리한다.
	//5초안에 입력을 완료하면 승패를 구해서 출력한다.
	//결과예시)
	// 1) 5초안에 입력하지 못했을 경우
	// 결과: 시간초과로 패배하였습니다.
	// 2) 5초안에 입력을 완료하였을 경우
	// 결과=>
	// 컴퓨터: 가위
	// 유저: 바위
	// 유저 승리
	public static boolean Input;
	public static void main(String[] args) {
		
		System.out.println("---가위바위보 게임---");
		System.out.println("Game Start");
		System.out.println();
		System.out.println();
		
		Thread t1 = new Count();
		Thread t2 = new Input();
		
		t1.start();
		t2.start();
	}	
	
}
class Count extends Thread{
	@Override
	public void run() {
		System.out.println("---Count Down---");
		System.out.println();
		for (int i = 5; i >=1; i--) {
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되었으면 쓰레드를 종료시킨다.
			if (Input.inputCheck ==true) {
				return; //run()메소드가 종료되면 해당 쓰레드도 종료됩니다.
			}
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Time over");
		System.out.println("시간초과로 패배하셨습니다.");
		System.exit(1);
	}
}
class Input extends Thread{
	// 입력 여부를 확인하기 위한 변수선언 - 두 쓰레드에서 공통으로 사용할 변수
	public static boolean inputCheck = false;
	String result = "";
	Random rd = new Random();
	
	@Override
	public void run() {
		
		//swich를 이용
//		int com = rd.nextInt(3)+1;
//		String com2 = "";
//		
//		switch (com) {
//		case 1:
//			com2 ="가위";
//			break;
//		case 2:
//			com2 ="바위";
//			break;
//		case 3:
//			com2 ="보";
//			break;
//		}
		
		//배열을 이용한 난수
		String[] data = {"가위","바위","보"};
		
		int index = rd.nextInt(3); //0~2사이의 난수
		String com3 = data[index]; //컴퓨터의 가위바위보를 정함
		String str = null;
		do {
		str = JOptionPane.showInputDialog("가위바위보 입력");		
		}while(!"가위".equals(str) || !"바위".equals(str) || !"보".equals(str));

		//결과판정
		if(com3.equals(str)) {
			result += "무승부";
		}else if(com3.equals("가위") && str.equals("바위") || com3.equals("바위") && str.equals("보") ||  
				com3.equals("보") && str.equals("가위")) {
			result += "유저 승리 ㅊㅋ";
		}else {
			result +="패배 ㅅㄱ";
		}
	 System.out.println("결과 => ");
	 System.out.println("컴퓨터: " + com3);
	 System.out.println("유저: " + str);
	 System.out.println(result);

	}
}