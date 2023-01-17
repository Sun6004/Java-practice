package chapter11;

import java.util.Arrays;
import java.util.Random;

public class test05 {

	public static void main(String[] args) {
		
		
		Random random = new Random();
		int num[] = new int[6];
		int temp;
		
		for(int i =0; i< num.length; i++) {
			num[i] = random.nextInt(45)+1;
			
			for(int j=0; j<i; j++) {
				if(num[i] == num[j]) {
					i--;
					break;
				}
			}
		}	for(int i=0; i<num.length; i++) {
				for(int j=0; j<i; j++) {
					if(num[i] < num[j]) {
						temp = num[i];
						num[i] = num[j];
						num[j] = temp;
					}
				}
		}System.out.println(Arrays.toString(num));
	}

}
