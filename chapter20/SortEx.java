package chapter20;

import java.util.Arrays;

public class SortEx {
	public static void main(String[] args) {
		//정렬 알고리즘 shorting
		//탐색 (검색)
		
		int[] numbers = {4,2,9,1,6,7,1,3};
		String[]names = {"전지혜","박승우","배문기","박정수","오미나","이지영","정은지"};
		
		//인터페이스가 구현된 배열객체를 넣으면 정렬해줌
		//Comparable interface가 구현되어야 사용가능
		Arrays.sort(args);
		
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		System.out.println();
		
	}
}
