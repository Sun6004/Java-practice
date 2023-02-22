package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest2 {
	
	public static void main(String[] args) {
		ArrayList<Member> mem = new ArrayList<>();
		
		mem.add(new Member(1,"홍길동","010-1234-5678"));
		mem.add(new Member(5,"이순신","010-1235-5678"));
		mem.add(new Member(9,"성춘향","010-1237-5678"));
		mem.add(new Member(3,"강감찬","010-1239-5678"));
		mem.add(new Member(6,"일지매","010-1200-5678"));
		mem.add(new Member(2,"변학도","010-1456-5678"));
		
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
		Collections.sort(mem, new SortNumDesc());
		System.out.println("회원번호의 내림차순 정렬후: " );
		for (Member m : mem) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------");
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
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
	
}

//Member의 회원번호(num)의 내림차순으로 정렬하는 외부 정렬기준 클래스
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
//		if(mem1.getNum() > mem2.getNum()) {
//			return -1; //데이터를 봐꾸지 않음
//		}else if(mem1.getNum()<mem2.getNum()) {
//			return 1; 
//		}else {
//			return 0;
//		}
		//Wrapper클래스를 이용하는 방법1
		//return new Integer(mem1.getNum()).compareTo(mem2.getNum()) *-1; //compareTo는 기본적으로 오름차순/ *-1;로 음수로 봐꿔줘야 내림차순
		
		//Wrapper클래스를 이용하는 방법2
		//return Integer.compare(mem1.getNum(), mem2.getNum()) *-1; //compare도 오름차순정렬이 기본
		
		//if문을 사용하지 않는 방법(값이 양쪽 다 양수일때만 사용가능)
		return mem2.getNum() - mem1.getNum();
	}
	
	
}
