package chapter07;

public class test06 {

	public static void main(String[] args) {
		//배열의 length필드
		
		int[] score = {83,90,87};
		
		int sum =0;
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		System.out.println("총합: " +sum);
		
		double avg = (double) sum/score.length;
		System.out.println("평균: " +avg);

	}

}
