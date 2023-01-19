package chapter14;

public class ComputerExample {

	public static void main(String[] args) {
		Computer mycom = new Computer();
		
		int[] valuse1 = {1,2,3};
		int result1 = mycom.sum1(valuse1);
		System.out.println(result1);
		
		int result2 = mycom.sum1(new int[] {1,2,3,4,5});
		System.out.println(result2);
		
		int result3 = mycom.sum2(1,2,3);
		System.out.println(result3);
		
		int result4 = mycom.sum2(1,2,3,4,5);
		System.out.println(result4);
		
		int result5 = mycom.sum2(1,2,3,4,5,6,7,8,9);
		System.out.println(result5);
		
		int result6 = mycom.sum3(10,1,2);
		System.out.println(result6);
		
		int result7 = mycom.sum4(1,2,4);
		System.out.println(result7);

	}

}
