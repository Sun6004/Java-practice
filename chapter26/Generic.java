package chapter26;

public class Generic<E> {
	
	private E element; //제네릭 타입변수
	
	void set(E element) { //제네릭 파라미터 메소드
		this.element = element;
	}
	
	E get() {
		return element;
	}
	
	static class Main{
		public static void main(String[] args) {
			
			Generic<String> a = new Generic<String>();
			Generic<Integer> b = new Generic<Integer>();
			
			a.set("10");
			b.set(10);
			
			System.out.println("a data: " + a.get());
			//반환된 변수의 타입 출력
			System.out.println("a E Type: "+ a.get().getClass().getName());
			
			System.out.println();
			System.out.println("b data: " + b.get());
			System.out.println("b E Type: "+ b.get().getClass().getName());
			
		}
	}
	
}
