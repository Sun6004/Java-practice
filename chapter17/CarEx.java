package chapter17;

import java.util.Iterator;

public class CarEx {

	public static void main(String[] args) {
		Car car = new Car(); //car객체 생성
		
		for (int i = 1; i <=6; i++) {
			int problemLocation = car.run();
			
			switch (problemLocation) {
			case 1:
				System.out.println("앞왼쪽 한국타이어로 교체");
				car.flTire = new Hankook("앞왼쪽", 15);
				break;
			case 2:
				System.out.println("앞오른쪽 금호타이어로 교체");
				car.frTire = new Kumho("앞오른쪽", 13);
				break;
			case 3:
				System.out.println("뒤왼쪽 한국타이어로 교체");
				car.flTire = new Hankook("뒤왼쪽", 14);
				break;
			case 4:
				System.out.println("뒤오른쪽 금호타이어로 교체");
				car.flTire = new Hankook("뒤오른쪽", 17);
				break;
			}
			System.out.println("--------------------------");//1회전시 출력되는 내용 구분
		}
		

	}

}
