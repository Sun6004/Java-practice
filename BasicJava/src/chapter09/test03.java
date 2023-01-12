package chapter09;

public class test03 {

	public static void main(String[] args) {
		//
		int[] a = {83, 90, 87};
		int num = a.length;
		
		System.out.println(num);
		
		int sum = 0;
		for(int i =0; i<a.length; i++) {
			sum += a[i];
		}
		System.out.println(sum);
		
		double avg = (double)sum /a.length;
		System.out.println(avg);
		
		if(args.length != 2) {
			System.out.println("값의 수가 부족합니다.");
			System.exit(0);
		}
		
		String str1 = args[0];
		String str2 = args[1];
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		int result = num1 +num2;
		System.out.println(num1 +"+"+num2 +"=" +result);
		

	}

}
