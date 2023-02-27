package basic.genericTest;

// 제네릭을 사용하지 않는 class
class NonGeneric{
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
/*
 * 제네릭 클래스 만드는 방법
 * 형식)
 * class 클래스명<제네릭타입문자>{
 *		제네릭타입문자 변수명; => 변수 선언에 제네릭을 사용할 경우
 *		....
 *		제네릭타입문자 메소드명(){  =>반환값이 있는 메소드에 제네릭을 사용하는 경우
 *		....
 *		return 반환값;
 *		}
 *
 *		void 메소드명(제네릭타입문자 변수명1, ...){  =>메소드의 매개변수에 제네릭을 사용하는 경우
 *		....
 *		}
 * }
 * 
 * --제네릭 타입 글자--
 *  T = Type
 *  K = Key
 *  V = value
 *  E = Element(자료구조에 들어가는 데이터)
 */

class MyGeneric<T>{
	private T value; //변수선언

	public T getValue() { //반환값타입
		return value;
	}

	public void setValue(T value) { //매개변수
		this.value = value;
	}
}


public class GenericTest {
public static void main(String[] args) {
	NonGeneric ng1 = new NonGeneric();
	ng1.setValue("가나다라");
	
	NonGeneric ng2 = new NonGeneric();
	ng2.setValue(100);
	
	// String sTemp = ng1.getValue(); => Object형을 반환하기때문에 직접 저장안됨
	String sTemp = (String)ng1.getValue(); 
	int iTemp = (Integer)ng2.getValue(); //형변환 필요
	System.out.println(sTemp);
	System.out.println(iTemp);
	
	//String sTemp2 = (String)ng2.getValue(); => Integer cannot be cast String
	System.out.println();
	
	MyGeneric<String> mg1 = new MyGeneric();
	mg1.setValue("안녕하세요");
	
	MyGeneric<Integer> mg2 = new MyGeneric();
	mg2.setValue(123);
	
	sTemp = mg1.getValue();
	iTemp = mg2.getValue();
	
	System.out.println(sTemp);
	System.out.println(iTemp);

	//String sTemp2 = mg2.getValue();
}
}
