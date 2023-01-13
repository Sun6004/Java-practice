package chapter10;

public class test03 {

	public static void main(String[] args) {// String[] args = new String[0];

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		// foreach 향상된 for문
		// : (in과같은의미)
		// jdk 1.5이상부터 사용가능
		for (String string : args) {
			System.out.println(string);
		}

		int[] scores = { 95, 71, 84, 93, 87 };
		int sum = 0;
		for (int score : scores) {
			sum = sum + score;
		}
		System.out.println("총점: " + sum);
		double avg = (double) sum / scores.length;
		System.out.println("평균점수: " + avg);
	int[][] array = {
			{95,86},
			{83,92,96},
			{78,83,93,87,88}
	};
	System.out.println(array.length);
	System.out.println(array[2].length);
	
	
	int max = 0;
	int[] array1 = {1,5,3,8,2};
		for(int i=0; i<array1.length; i++){
			if(max < array1[i]){
				max = array1[i];
			}
		}System.out.println("max: "+max);
		
	}
	
}