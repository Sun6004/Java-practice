package chapter14;

public class Computer {
	int sum1(int[] values) {
		int sum = 0;
		for(int i = 0; i<values.length; i++) {
			sum +=values[i];
		}
		return sum;
	}
	int sum2(int ... valuse) {
		int sum = 0;
		for(int i = 0; i< valuse.length; i++) {
			sum +=valuse[i];
		}
		return sum;
	}
	
	int sum3(int ... valuse) {
		int sum = 0;
		for(int i =0; i<valuse.length; i++) {
			sum -=valuse[i];
		}
		return sum;
	}
	int sum4(int ... valuse) {
		int sum = 0;
		int sum2 = 0;
		int sum3 = 0;
		for(int i = 0; i<valuse.length; i++) {
			sum2 += valuse[i];
			for(int j=0; j<valuse.length; j++) {
				sum += valuse[i];
			}
		}sum3 = sum+sum2;
		return sum3;
	}
	
}
