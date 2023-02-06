package chapter25;

public class MathClass {
public static void main(String[] args) {
	int v1 = Math.abs(-5);
	double v2 =Math.abs(-3.14);
	System.out.println(v1);
	System.out.println(v2);
	
	double v3 = Math.ceil(5.3);
	double v4 = Math.ceil(-5.3);
	System.out.println(v3);
	System.out.println(v4);
	
	double v5 = Math.floor(5.3);
	double v6 = Math.floor(-5.3);
	System.out.println(v5);
	System.out.println(v6);
	
	int v7 = Math.floorDiv(5,9);
	double v8 = Math.max(2.3,2.5);
	System.out.println(v7);
	System.out.println(v8);
	
	
}	

}
