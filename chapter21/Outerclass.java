package chapter21;

public class Outerclass {
	String name;
	void method() {
		System.out.println("Outer class");
	}
	
	//OuterClass는 자바가 실행될 때 필요한 클래스 메타 정보를 method area에 올려둠
	//InnerClass는 OuterClass처럼 method area에 정보를 올리지 않는다.
	//OuterClass가 생성되어야만 InnerClass를 생성가능
	
	static class InnerClass{
		public InnerClass() {
			
		}
		String name;
		void method() {
			System.out.println("Inner Class");
		}
	}
	//InnerClass innerclass = Outerclass. new InnerClass(); <- InnerClass호출방법
	//InnerClass에 static 선언시 Innerclass innerclass = new OuterClass.InnerClass(); 사용가능(바로 접근가능)
	
	
	//중첩인터페이스
	interface NestedInterface{
		void ruh();
	}
}

