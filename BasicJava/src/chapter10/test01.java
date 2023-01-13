package chapter10;

public class test01 {

	public static void main(String[] args) {
		//
		int[] scores = {83, 90, 87};	
		System.out.println("scores[0]: " + scores[0]);
		System.out.println("scores[1]: " + scores[1]);
		System.out.println("scores[2]: " + scores[2]);	
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum +=scores[i];
		}
		System.out.println("총합: " +sum);
		double avg = (double) sum/3;
		System.out.println("평균: " +avg);
		
		//
		int[] arr1 = new int[3];
		for(int i=0; i<3; i++) {
			System.out.println("arr1[" + i + "]: " + arr1[i]);
		}
		
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		for(int i=0; i<3; i++) {
			System.out.println("arr1[" + i + "]: " + arr1[i]);
		}
		double[] arr2 = new double[3];
		for(int i=0; i<3; i++) {
			System.out.println("arr2[" + i + "]: " + arr2[i]);
		}
		arr2[0] = 0.1;
		arr2[1] = 0.2;
		arr2[2] = 0.3;
		for(int i=0; i<3; i++) {
			System.out.println("arr2[" + i + "]: " + arr2[i]);
		}
		
		String[] arr3 = new String[3];
		for(int i=0; i<3; i++) {
			System.out.println("arr3[" + i + "]: " + arr3[i]);
		}
		arr3[0] = "1월";
		arr3[1] = "2월";
		arr3[2] = "3월";
		for(int i=0; i<3; i++) {
			System.out.println("arr3[" + i + "]: " + arr3[i]);
		}
		
		int[]score = {83,90,87};
		
		int b = 0;
		for(int i=0; i<score.length; i++) {
			b += score[i];
		}
		System.out.println("총합: "+b );

		double a = (double) b/ score.length;
		System.out.println("평균: " +a);
	}
}
