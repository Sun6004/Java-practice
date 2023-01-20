package chapter15;

public class Person {
	final String nation = "Korea";
	final String ssn;
	String name;
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
public static void main(String[] args) {
		Person p1 = new Person("123456-1234567", "Hong");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		//final 필드이기 때문에 사용불가
		//p1.nation = "usa";
		//p1.ssn = "654321-7654321"; 
		p1.name = "Hongsam";
		System.out.println(p1.name);
		
	}

}
	

