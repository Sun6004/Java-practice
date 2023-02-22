package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 *  정렬과 관련된 interface는 Comparable, Comparator 이렇게 두 가지가 있다.
 *  Comparable 은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을때 구현하는 인터페이스다.
 *   - 내부 정렬 기준을 작성할 때 사용.
 *  Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을 때 구현하는 인터페이스다.
 *   - 외부 정렬 기준
 *   
 *  Comparable 에서는 compareTo() 메소드를 재정의 하고,
 *  Comparator 에서는 compare() 메소드를 재정의 해야한다.
 *  
 *  String클래스, Wrapper클래스들, Date클래스, File클래스에는 내부 정렬 기준이 구현되어 있다.
 *   - 내부 정렬 기준은 오름차순으로 처리되도록 구현되어 있다.
 */  

public class ListSortTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬전: " +list);
		
		//정렬은 Collections.sort() 메소드를 이용해서 정렬한다.
		//Collections.sort() 메소드는 기본적으로 내부 정렬 기준으로 정렬한다.
		Collections.sort(list);
		System.out.println("정렬후: " + list);
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1); arr.add(3); arr.add(5); arr.add(2); arr.add(0); arr.add(7);
		System.out.println(arr);
		Collections.sort(arr);
		System.out.println(arr);
		
		Collections.shuffle(list); //자료섞기
		System.out.println("섞은후: "+list);
		
		//외부 정렬 기준을 적용해서 정렬하기
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬후:"+list);
		
	}
}
// 정렬 방식을 정해주는 class를 작성한다. (이것을 외부 정렬 기준 클래스 라고 한다.)
// Comparator 인터페이스를 구현해서 작성한다.
class Desc implements Comparator<String>{
	// compare() 메소드를 이용해서 정렬하고자 하는 기준을 정해준다.
	
	// compare() 메소드의 반환값과 그 의미
	// -0은 두 값(str1,str2)이 같다.
	// -양수는 앞, 뒤의 순서를 봐꾼다.
	// 음수는 앞, 뒤의 순서를 봐꾸지 않는다.
	
	// 예) 오름차순으로 정렬할 경우 ==> 앞의 값이 크면 양수, 같으면 0, 작으면 음수를 반환하도록 구현
	
	@Override
	public int compare(String str1, String str2) {
		//내림차순으로 구현
		if(str1.compareTo(str2)>0) {
			return -999; //음수 아무거나 표현가능
		}else if(str1.compareTo(str2)<0) {
			return 999; 
		}
		return 0;
	}
	
	
}