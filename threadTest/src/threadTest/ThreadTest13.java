package threadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ThreadTest13 {
	public static void main(String[] args) {
		List<Horse2> horse = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			horse.add(new Horse2(i + "번말"));
		}

		for (Horse2 a : horse) {
			a.start();
		}
		PrintPosition pp = new PrintPosition(horse);
		pp.start();
		

		for (Horse2 a : horse) {
			try {
				a.join();
				pp.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		Collections.sort(horse);
		for (Horse2 a : horse) {
			a.printRank();
		}

	}

}

class PrintPosition extends Thread {
	List<Horse2> horse = new ArrayList<>();

	public PrintPosition(List<Horse2> horse) {
		this.horse = horse;
	}

	@Override
	public void run() {
		while (Horse2.getResult()<9) {
			System.out.println("=============================================================================");
			System.out.println();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			for (Horse2 a : horse) {
				System.out.println(a.getName1() + " : ");
				for (int i = 0; i < 50; i++) {
					if (i != a.getPosition()) {
						System.out.print("-");
					} else {
						System.out.print(">");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public List<Horse2> getHorse() {
		return horse;
	}

	public void setHorse(List<Horse2> horse) {
		this.horse = horse;
	}
}

class Horse2 extends Thread implements Comparable<Horse2> {
	private static int result = 1;
	private String name;
	private int rank;
	private int position;

	public Horse2(String name) {
		this.name = name;
	}

	public void printRank() {
		System.out.println(rank + "등 : " + name);
	}

	@Override
	public void run() {
		Random rnd = new Random();
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(rnd.nextInt(500));
			} catch (Exception e) {
				// TODO: handle exception
			}
			position++;
		}
		rank = result++;
	}

	@Override
	public int compareTo(Horse2 o) {
		if (this.rank > o.rank) {
			return 1;
		} else if (this.rank == o.rank) {
			return 0;
		} else {
			return -1;
		}
	}

	public static int getResult() {
		return result;
	}

	public static void setResult(int result) {
		Horse2.result = result;
	}

	public String getName1() {
		return name;
	}

	public void setName1(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}

