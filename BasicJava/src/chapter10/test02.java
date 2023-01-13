package chapter10;

import java.util.Iterator;

public class test02 {

	public static void main(String[] args) {
		//2차원 배열
		int[][] mathScore = new int[2][3];
		for(int i=0; i<mathScore.length; i++) {
			for(int k=0; k < mathScore[i].length; k++) {
				System.out.println("mathScores["+i+"]["+k+"]=" +mathScore[i][k]);
			}
		}
		System.out.println();
		
		int[][] eng = new int[2][];
		eng[0] = new int[2];
		eng[1] = new int[3];
		
		for(int i=0; i< eng.length; i++) {
			for(int k=0; k< eng[i].length; k++) {
				System.out.println("englishScores[" + i +"][" +k+ "]=" +eng[i][k]);
			}
		}
		System.out.println();
		
		int[][] java = {{95,80},{92,96,80}};
		for(int i=0; i<java.length; i++) {
			for(int k=0; k<java[i].length; k++) {
				System.out.println("javaScores[" +i+ "][" +k+"]=" +java[i][k]);
			}
		}
		
	}

}
