package chapter15.package2; //패키지가 다름

import java.util.Iterator;

import chapter15.package1.A;

public class C {
	//필드
	A a1 = new A(true);
	//A a2 = new A(1);//default 같은 패키지에서만 사용가능
	//A a3 = new A("문자열");//private 오로지 클래스내부에서만 사용가능
	
	public C() {
		A a = new A();
		a.field1 = 1;
		//a.field2 = 2; //default err
		//a.field3 = 3; //private err
		
		a.method1();
		//a.method2(); //default err
		//a.method3(); //private err
	
	}
	
}
