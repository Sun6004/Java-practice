package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
	
	//등수를 구하는 메소드
	public void setRank(List<Student> studentList) {
		for (Student std1 : studentList) { //등수를 구할 기준 데이터를 구하기 위한 반복문
			int rank = 1; //처음에는 1등으로 초기화 해놓고 시작한다.
			
			for (Student std2 : studentList) { //비교대상
				if(std1.getTot() < std2.getTot()) { //for문 동작중 기준데이터보다 비교데이터가 더 큰값을 만나면
					rank ++; //rank값이 증가
				}
			}
			//구해진 등수를 Student 객체의 rank변수에 저장한다
			std1.setRank(rank);
		}
	}

	public static void main(String[] args) {

		// 문제) 학번,이름,국어점수,영어점수,수학점수,총점,등수를 멤버로 갖는 Student 클래스를 만든다.
		// 이 클래스의 생성자에서는 학번,이름,국어점수,영어점수,수학점수만 인수로 받아서 초기화 처리한다.
		// 이 Student객체는 list에 저장하여 관리한다.
		// list에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
		// 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부정렬 기준도 구현하여
		// 정렬된 결과를 출력하시오.
		// (등수는 list에 전체 데이터가 추가된 후에 구해서 저장한다.)
		StudentTest test = new StudentTest();
		ArrayList<Student> memlist = new ArrayList<>();

		memlist.add(new Student(1, "asd", 95, 80, 90));
		memlist.add(new Student(5, "zxc", 100, 100, 98));
		memlist.add(new Student(3, "qwe", 80, 80, 85));
		memlist.add(new Student(2, "zzz", 100, 100, 98));
		memlist.add(new Student(4, "kkk", 55, 50, 40));
		
		//등수 구하는 메소드
		test.setRank(memlist);
		
		System.out.println("<학번순 오름차순 정렬>");
		Collections.sort(memlist);
		for (Student s : memlist) {
			System.out.println(s);
		}
		
		System.out.println("------------------------------------");
		System.out.println();
		System.out.println("<총점의 내림차순 정렬>");
		Collections.sort(memlist, new SortByTotal());
		for (Student s : memlist) {
			System.out.println(s);
		}

	}
}

class Student implements Comparable<Student> {
	private int num;
	private String name;
	private int korScore;
	private int engScore;
	private int matScore;
	private int tot;
	private int rank;
	
	public Student(int num, String name, int korScore, int engScore, int matScore) {
		super();
		this.num = num;
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.matScore = matScore;
		this.tot = korScore + engScore + matScore;

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMatScore() {
		return matScore;
	}

	public void setMatScore(int matScore) {
		this.matScore = matScore;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", korScore=" + korScore + ", engScore=" + engScore
				+ ", matScore=" + matScore + ", tot=" + tot + ", rank=" + rank + "]";
	}

	//학번의 오름차순으로 정렬
	@Override
	public int compareTo(Student s) {
		return Integer.compare(this.getNum(), s.getNum());
	}

}

class SortByTotal implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {

		int compare = Integer.compare(s1.getTot(), s2.getTot()) * -1;
		if (s1.getTot() == s2.getTot()) {
			return s1.getName().compareTo(s2.getName());
		} /*
			 * else { return Integer.compare(s1.getTot(), s2.getTot())*-1; }
			 */
		return compare;
	}
}