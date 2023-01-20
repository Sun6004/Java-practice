package chapter15.package1; //패키지가 동일

public class B {
	//필드
	A a1 = new A(true);
	A a2 = new A(1);
	//A a3 = new A("문자열"); //private생성자 접근불가
	
	public B() {
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
		//a.field3 = 1;//private err
		
		a.method1();
		a.method2();
		//a.method3();//private err
	}
}
