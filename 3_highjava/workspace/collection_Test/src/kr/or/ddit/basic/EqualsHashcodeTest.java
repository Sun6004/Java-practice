package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashcodeTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setNum(1);
		p2.setName("홍길동");
	
		Person p3 = p1;
		
		Person p4 = new Person();
		p4.setName("hong");
		p4.setNum(2);
		
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
		HashSet<Person> set = new HashSet<>();
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		System.out.println("Set의 개수:"+set.size()); //set입장에서 p1과p2가 다른객체여서 두개다 들어감
		
		System.out.println("--------------------------");
		System.out.println("p1: " + p1.hashCode());
		System.out.println("p2: " + p2.hashCode());
		System.out.println("p3: " + p3.hashCode());
		System.out.println("p4: " + p4.hashCode());
		
	}
	
}
class Person{ //extends Object가 생략되어있음.
	private int num;
	private String name;
	
	public Person() {
		
	}
	
	public Person(int num, String name) {
		super();
		this.num = num;
		this.name = name;
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
	
	//equals의 재정의
	@Override
	public boolean equals(Object obj) { //어떤 객체가 와도 비교할 수 있게 Object사용
		if(this == obj) {// 참조값이 같다
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) { // this.getClass() : this 가 가르키는 클래스 정보
			return false;
		}
		Person that = (Person) obj; //매개변수의 값의 현재 객체 유형으로 형변환 한다.
		
		if(this.name == null && that.name != null) {
			return false;
		}
		if(this.num == that.num && this.name == that.name) {
			return true;
		}
		if(this.num == that.num && this.name.equals(that.name)) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,num);
	}
}
