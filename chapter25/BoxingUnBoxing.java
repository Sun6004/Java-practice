package chapter25;

public class BoxingUnBoxing {
	public static void main(String[] args) {
		int a = 10;
		
		Integer b = new Integer(10);//boxing
		int bb = b.intValue(); //Unboxing
		
		Boolean c = new Boolean(false);
	
	
	//Auto Boxing/UnBoxing
	Integer d = 10; //자동으로 new Integer처럼 boxing됨
	int e = new Integer(10); //Auto UnBoxing
	
	Integer obj = new Integer(200);
	Integer obj2 = new Integer(200);
	
	int value1 = obj; //auto unboxing
	int value2 = obj + 100; // 원래 객체에 +할수없지만 Auto unboxing 되어 가능
	
	System.out.println(obj);
	System.out.println(value1);
	System.out.println(value2);
	System.out.println(obj == value1);
	System.out.println(obj == obj2);
	System.out.println(obj.equals(obj2));
	
	long startTime = System.nanoTime();
	Integer sum = 0;
	for (int i = 1; i <=1000; i++) {
		sum+=i;
		//sum = sum+1
	}
	
	System.out.println(sum);
	long endTime = System.nanoTime();
	System.out.println("기본연산 걸린시간: "+(endTime - startTime));
	
	Integer int1 = 100;
	Integer int2 = 200;
	int sum2 = Integer.sum(int1, int2);
	System.out.println(sum2);
	
	
	}
	
}
