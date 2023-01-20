package chapter15;

public class Singleton {
	private String name;
	
	private static Singleton instance = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getinstance() {
		return instance;
	}
	
}
