package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;

public class ListSortTest2 {
	
	public static void main(String[] args) {
		ArrayList<Member> mem = new ArrayList<>();
		
		mem.add(new Member(1,"홍길동","010-1234-5678"));
		mem.add(new Member(5,"이순신","010-1234-5678"));
		mem.add(new Member(9,"성춘향","010-1234-5678"));
		mem.add(new Member(3,"강감찬","010-1234-5678"));
		mem.add(new Member(6,"일지매","010-1234-5678"));
		mem.add(new Member(2,"변학도","010-1234-5678"));
		
		System.out.println("정렬전...");
		for (Member m : mem) {
			System.out.println(m);
		}
		System.out.println("-----------------------------------------------");
		
		Collections.sort(mem);
		
		System.out.println("정렬후: " );
		for (Member m : mem) {
			System.out.println(m);
		}
		System.out.println("-----------------------------------------------");
	
		
		//회원 번호를 기준으로 내림차순 정렬하여 출력하시오.
		// ==> 외부 정렬 기준 클래스를 작성하여 처리한다. ( 클래스 이름: SortNumDesc)
	}
}

// Member Class의 '회원이름'을 기준으로 오름차순이 되도록 내부 정렬 기준을 추가하기
// ==> Comparable 인터페이스를 구현한다.

class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	@Override
	public int compareTo(Member mem) {
		//회원 이름의 오름차순	
		return this.getName().compareTo(mem.getName()); 
	}
	
	//생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	
	//getter/setter
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Member []";
	}
	
}