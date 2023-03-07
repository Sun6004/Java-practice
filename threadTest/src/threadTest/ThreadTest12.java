package threadTest;

import java.util.Arrays;
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
//		List<Horse> list = new ArrayList<>();
//		
//		list.add(new Horse("제주말"));
//		list.add(new Horse("조랑말"));
//		list.add(new Horse("흑마"));
//		list.add(new Horse("적토마"));
//		list.add(new Horse("백마"));
//		list.add(new Horse("똥마"));
//		list.add(new Horse("낙타"));
//		list.add(new Horse("타조"));
//		list.add(new Horse("캥거루"));
//		list.add(new Horse("코뿔소"));
		Horse[]horseArr = new Horse[] {
			new Horse("1번말"),	
			new Horse("2번말"),	
			new Horse("3번말"),	
			new Horse("4번말"),	
			new Horse("5번말"),	
			new Horse("6번말"),	
			new Horse("7번말"),	
			new Horse("8번말"),	
			new Horse("9번말"),	
			new Horse("10번말"),	
		};
		GameStage game = new GameStage(horseArr);
		
		for (Horse horse : horseArr) {
			horse.start(); //경주시작
		}
		game.start(); //말의 위치 출력
		
		for (Horse horse : horseArr) {
			try {
				horse.join();
			} catch (InterruptedException e) {

			}
		}
		try {
			game.join();
		} catch (InterruptedException e) {
		}
		System.out.println();
		System.out.println("경기 종료");
		System.out.println();
		
		//등수의 오름차순으로 정렬하기
		Arrays.sort(horseArr); //배열정렬하기
		
		for (Horse horse : horseArr) {
			System.out.println(horse);
		}
	}
}
		
//		System.out.println("*****경마 시작!*****");
//		for (Horse horse : list) {
//			horse.start();
//		}
//
//		for (Horse hs : list) {
//			try {
//				hs.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		Collections.sort(list);
//		System.out.println("경기종료");
//		System.out.println("*****************************************************");
//		System.out.println();
//		System.out.println(" 결과 =>");
//
//		for (Horse horse : list) {
//			System.out.println(horse.getName1() + "선수 " + horse.getRank() + " 등");
//		}
//	}
//}
//
//class Horse extends Thread implements Comparable<Horse>{
//	
//	private String name1;
//	  int rank;
//	   
//	  public Horse(String name) {
//	      this.name1 = name;
//	   }
//	   
//	  public String getName1() {
//	      return name1;
//	   }
//
//	  public void setName1(String name) {
//	      this.name1 = name;
//	   }
//
//	  public int getRank() {
//	      return rank;
//	   }
//
//	  public void setRank(int rank) {
//	      this.rank = rank;
//	   }
//	
//	@Override
//	public void run() {
//		Random rand = new Random();
//		
//		for (int i = 0; i < 50; i++) {
//			System.out.println("\n" + name1 + " : ");
//			for (int j = 0; j < i; j++) {
//				System.out.print("-");
//			}
//			System.out.print(">");
//
//			for (int j = 49; j > i; j--) {
//				System.out.print("-");
//			}
//
//			System.out.println();
//
//			try {
//				Thread.sleep(rand.nextInt(300));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//		}
//
//		setRank(ThreadTest12.rank2);
//		ThreadTest12.rank2++;
//	}
//	   
//	@Override
//	public int compareTo(Horse hor) {
//		if (rank > hor.getRank()) {
//			return 1;
//		} else {
//			return -1;
//		}
//	}
//}

class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0; //말의 등수를 구할 때 사용할 변수 
	private String horseName;
	private int rank;
	private int location;//현재위치

	public Horse(String name) {
	super();
	this.horseName = name;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.getRank());
	}

	@Override
	public String toString() {
		return "경주마"+  horseName + "은, rank=" + rank + "]등입니다.";
	}

	@Override
	public void run() {
		Random rand = new Random();
		for (int i = 1; i <=50; i++) {
			this.location = i;
			try {
				Thread.sleep(rand.nextInt(500));
			} catch (InterruptedException e) {
			}
		}
		//한 마리의 말의 경주가 끝나면 현재의 등수를 구해서 저장
		currentRank++;
		this.rank = currentRank;
	}
}
/*
* 경기 중간 중간에 각 말들의 위치를 아래와 같이 출력
 * 말이름01 : ---->--------------------------------------------------------
 * 말이름02 : ----------->-------------------------------------------------
 * 말이름03 : -->----------------------------------------------------------
 * ...
 * 말이름10 : ---------------------------->--------------------------------
 */
class GameStage extends Thread{
	private Horse[] horseArr; //경주에 참가한 말들의 정보가 저장될 배열변수 선언
	
	//생성자 
	public GameStage(Horse[] horseArr) {
		super();
		this.horseArr = horseArr;
	}

	@Override
	public void run() {
		while(true) {
			//경기가 끝났는지 여부 검사
			if(Horse.currentRank == horseArr.length) {
				break; //currentRank가 10이되면 경기종료
			}
			
			for (int i = 1; i <= 10; i++) {
				System.out.println();
			}
			
			for (int i = 1; i < horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName()+" :");
				
				for (int j = 1; j <= 50; j++) {
					if(horseArr[i].getLocation() == j) { //말의 현재위치가 j와 같으면
						System.out.print(" ▷");
					}else {
					System.out.print("-"); // "-" 50개 출력
					}
				}
				System.out.println();
			}
			try {
				Thread.sleep(100); //출력속도 조절
			} catch (InterruptedException e) {
			}
		}
	}
}