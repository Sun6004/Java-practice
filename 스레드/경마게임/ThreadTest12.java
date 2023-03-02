package threadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * 10마리의 말들이 경주하는 프로그램 작성하기
 * 
 * 말은 Horse라는 이름의 쓰레드 클래스로 작성하며
 * 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 맴버변수로 갖는다.
 * 그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준을 갖고 있다.
 * (Comparable인터페이스 구현)
 * 
 * 경기 구간은 1~ 50구간으로 되어 있다.
 * 경기가 끝나면 등수 순으로 출력한다.
 * 
 * 경기 중간 중간에 각 말들의 위치를 아래와 같이 출력
 * 말이름01 : ---->--------------------------------------------------------
 * 말이름02 : ----------->-------------------------------------------------
 * 말이름03 : -->----------------------------------------------------------
 * ...
 * 말이름10 : ---------------------------->--------------------------------
 * 
 */
public class ThreadTest12 {
	static int rank2 = 1;

	
	public static void main(String[] args) {
		List<Horse> list = new ArrayList<>();
		
		list.add(new Horse("제주말"));
		list.add(new Horse("조랑말"));
		list.add(new Horse("흑마"));
		list.add(new Horse("적토마"));
		list.add(new Horse("백마"));
		list.add(new Horse("똥마"));
		list.add(new Horse("낙타"));
		list.add(new Horse("타조"));
		list.add(new Horse("캥거루"));
		list.add(new Horse("코뿔소"));
		
		System.out.println("*****경마 시작!*****");
		for (Horse horse : list) {
			horse.start();
		}

		for (Horse hs : list) {
			try {
				hs.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(list);
		System.out.println("경기종료");
		System.out.println("*****************************************************");
		System.out.println();
		System.out.println(" 결과 =>");

		for (Horse horse : list) {
			System.out.println(horse.getName1() + "선수 " + horse.getRank() + " 등");
		}
	}
}

class Horse extends Thread implements Comparable<Horse>{
	
	private String name1;
	  int rank;
	   
	  public Horse(String name) {
	      this.name1 = name;
	   }
	   
	  public String getName1() {
	      return name1;
	   }

	  public void setName1(String name) {
	      this.name1 = name;
	   }

	  public int getRank() {
	      return rank;
	   }

	  public void setRank(int rank) {
	      this.rank = rank;
	   }
	
	@Override
	public void run() {
		Random rand = new Random();
		
		for (int i = 0; i < 50; i++) {
			System.out.println("\n" + name1 + " : ");
			for (int j = 0; j < i; j++) {
				System.out.print("-");
			}
			System.out.print(">");

			for (int j = 49; j > i; j--) {
				System.out.print("-");
			}

			System.out.println();

			try {
				Thread.sleep(rand.nextInt(300));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		setRank(ThreadTest12.rank2);
		ThreadTest12.rank2++;
	}
	   
	@Override
	public int compareTo(Horse hor) {
		if (rank > hor.getRank()) {
			return 1;
		} else {
			return -1;
		}
	}
}

