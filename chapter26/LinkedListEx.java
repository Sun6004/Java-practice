package chapter26;

import java.util.*;

public class LinkedListEx {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList걸린시간: "+ (endTime-startTime) +"ns");
		
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		
		endTime = System.nanoTime();
		System.out.println("Linked 걸린시간: " +(endTime-startTime)+ "ns");
		//중간에 데이터를 추가하는 경우LinkedList가 빠름
	}
}
