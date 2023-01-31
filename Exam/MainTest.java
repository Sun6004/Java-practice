package Exam;

public class MainTest{
	public static void main(String[] args) {
		int n = 7;
		n = n+add(1,2);
		Foo f = new Foo(10);
		n = n + f.getA();
		out(n);
		
	}
	
	private static void out(int x) {
		System.out.println(x);
	}
	
	private static int add(int x, int y) {
		int z = x+y;
		return z;
	}
	
	public class Foo{
		int a;
		
		public Foo(int a) {
			this.a = a;
		}
		public int getA() {
			return a;
		}
	}
	public class Bar{
		int a;
		
		public int getA() {
			return a;
		}
	}
}
