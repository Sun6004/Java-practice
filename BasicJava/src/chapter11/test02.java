package chapter11;

import java.util.Random;

public class test02 {

	public static void main(String[] args) {
		
		Random random = new Random();
		int num[] = new int[6];
		
		for(int i =0; i<6; i++) {
			num[i] = random.nextInt((45)+1);
			
			for(int j=0; j<i; j++) {
				if(num[j]==num[i]) {
					i--;
					break;
				}
			}	
		}
		for(int i =0; i<6; i++) {
			System.out.println(num[i]);
		}
		
	}
}
