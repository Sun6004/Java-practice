package chapter17;

public class Child extends Parent {

	private String name;
	
	public Child() {
		//super();
		this("홍길동");//얘때문에 super가 생략 
		System.out.println("Child()call");
	}
	public Child(String name) {
		//super();
		this.name = name;
		System.out.println("Child(String name)call");
	}
	

}
