package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseBall2 {
	private ArrayList<Integer> numList; // 난수
	private ArrayList<Integer> userList; // 사용자입력
	private int strike;
	private int ball;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new BaseBall2().gameStart();

	}

	public void gameStart() {
		System.out.println();
		System.out.println("*****************************************");
		System.out.println(" - 숫자 야구게임 시작! -");
		System.out.println("*****************************************");
		System.out.println("1~9사이의 서로 다른 숫자 3개를 입력하시오");
		System.out.println();

		// 난수를 만드는 메소드 호출
		createNum();

		// 만들어진 난수 확인
		System.out.println("만들어진 난수: " + numList);

		// 3스트라이크가 될때까지 입력받기
		int count = 0;
		do {
			inputData();// 입력용 메소드 호출
			ballCount();// 볼 카운트를 구하는 메소드
			count++;
		} while (strike != 3); // strike개수가 3이 아니면 계속반복

		System.out.println();
		System.out.println("축하합니다! ");
		System.out.println("당신은 " + count + "번 만에 맞췄습니다.");
	}

	// List 1~9 random num 3(Set)
	public void createNum() {
		Set<Integer> numSet = new HashSet<>();
		Random r = new Random();
		// 난수만들기
		while (numSet.size() < 3) {
			numSet.add(r.nextInt(9) + 1);
		}
		// 만들어진 난수를List에 저장
		numList = new ArrayList<>(numSet);

		// List의 데이터는 정렬되어 나오기 때문에 섞어주는작업
		Collections.shuffle(numList);
	}

	// 사용자로부터 3개의 정수를 입력받아 List에 추가하는 메서드
	// (단, 입력한 값들은 중복되지 않아야 한다.)
	public void inputData() {
		int num1, num2, num3;

		do {
			System.out.print("숫자입력>> ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			num3 = sc.nextInt();
			if (num1 == num2 || num1 == num3 || num2 == num3) {
				System.out.println("중복되는 값이 입력되었습니다. 다시 입력하세요.");
			}
		} while (num1 == num2 || num1 == num3 || num2 == num3);

		// 입력받은 값을 List에 추가
		userList = new ArrayList<>();
		userList.add(num1);
		userList.add(num2);
		userList.add(num3);
	}

	// 스트라이크와 볼의 개수를 구해서 출력
	public void ballCount() {
		strike = 0;
		ball = 0;

		for (int i = 0; i < userList.size(); i++) {
			for (int j = 0; j < numList.size(); j++) {
				// 중첩for문을 돌려 난수와 입력값이 같은것을 검사

				if (userList.get(i) == numList.get(i)) {
					if (i == j) {// 위치가 같은지 검사
						strike++;
					} else {
						ball++;
					}
				}
			}
		}
		System.out.println(userList.get(0) + " ," + userList.get(1) + "," + userList.get(2) + " ==>" + strike + "S "
				+ ball + "B ");
	}
}
