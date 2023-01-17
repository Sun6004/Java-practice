package chapter11;

import java.util.Arrays;
import java.util.Random;

public class test06 {

	public static void main(String[] args) {
		Random ran = new Random();
		int[]arr = new int[45];
		for(int i =0; i<arr.length; i++) {
			arr[i] = i+1;
			
		}
		for(int i = 0; i<arr.length; i++) {
			
			int num = ran.nextInt(45);
			int temp = arr[i];
			arr[i] = arr[num];
			arr[num] = temp;
		}
		for (int i=0; i<6; i++) {
			if(i!=0) {	
			System.out.print(",");
			}
				System.out.print(arr[i]);
		
		}

	}

}
