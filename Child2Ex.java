package chapter17;

public class Child2Ex {
	public static void main(String[] args) {
		Parent2 parent = new Child2();
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		/*불가능
		 *parent.field2 = "data2";
		 *parent.method3();
		 */
		
		//강제 타입변환
		Child2 child = (Child2) parent;
		child.field2 = "yyy";
		child.method3();
		
		
		
	}
	//객체 타입확인
			public void method(Parent2 parent) {
				if(parent instanceof Child2) {
					Child2 child = (Child2)parent;
				}
			}
}
