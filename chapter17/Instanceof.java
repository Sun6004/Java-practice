package chapter17;

public class Instanceof {
	public static void method1(Parent2 parent) {
		if(parent instanceof Child2) { // Child2 타입으로 변환이 가능한지 확인.
			Child2 child = (Child2) parent;
			System.out.println("method1 - Child2로 변환성공");
		}else {
			System.out.println("method1 - Child2로 변환실패");
		}
	}
	
	public static void method2(Parent2 parent) {
		Child2 child = (Child2)parent; //ClasscastException 발생가능성있음
		System.out.println("method2 - Child2로 변환성공");
	}
	
	public static void main(String[] args) {
		Parent2 parentA = new Child2();
		method1(parentA);
		method2(parentA); //Child2 객체를 매개값으로 전달
		
		Parent2 parentB = new Parent2();
		method1(parentB);
		method2(parentB);		
	}
}
