package chapter11;

public class test01 {

	public static void main(String[] args) {
		
		
		int[] scores = {38,94,16,3,76,94,82,47,59,8};
		int max = scores[0];
		int law = scores[0];
			for(int i=0; i<scores.length; i++) {
				if(max<scores[i]) {
					max = scores[i];
				}if(law>scores[i]) {
					law = scores[i];
				}
			}
			System.out.println(max);
			System.out.println(law);
			
		
	}

}
