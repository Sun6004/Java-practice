package chapter11;

import java.util.Random;


public class test04 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int[]array=new int[6];
		int n;
		
		System.out.println("---------------");
		System.out.println("면         빈도");
		System.out.println("---------------");
		for (int i = 0; i <= 10000; i++) {
			n = rand.nextInt(6);//0  5
			array[n]++;
		}

		for (int i =0; i < array.length; i++){	
			System.out.println((i+1)+"         " + array[i]);
		}
	}
}
