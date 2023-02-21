package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArraylistTest01 {
	public static void main(String[] args) {
		
		//ArrayList의 기본적인 사용법은 Vector와 같다.
		
		ArrayList list1 = new ArrayList<>();
		
		//add() 메소드를 이용해서 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);

		System.out.println(list1);
		System.out.println(list1.size());
		System.out.println();
		//get메소드를 이용해서 데이터를 꺼내온다.
		System.out.println("1번째 자료: "+list1.get(1));
		
		//데이터 끼워넣기도 같음
		list1.add(3,"zzz");
		System.out.println(list1);
		
		//데이터 변경하기
		list1.set(3, "yyy");
		System.out.println(list1);
		String sTemp = (String)list1.set(1, "zxc");
		System.out.println(list1);
		System.out.println(sTemp); //반환값
		
		//삭제도 같음
		list1.remove(3);
		System.out.println(list1);
		list1.remove("zxc");
		
		//제네릭 사용가능
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("aaa");
		list2.add("bbb");
		list2.add("ccc");
		list2.add("ddd");
		list2.add("eee");
		

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i+"=>"+list2.get(i));
		}
		for (String str : list2) {
			System.out.println(str);
		}
		
		// contanins(비교객체) ==> 리스트에 저장된 데이터 중에서 '비교객체'가 있으면 true, 없으면false 반환
		System.out.println("ddd값 존재여부: "+list2.contains("ddd"));
		System.out.println("zzz값 존재여부: "+list2.contains("zzz"));
		
		//index of(비교객체)
		//lastIndexOf(비교객체) ==> 리스트에 "비교객체"가 있으면 '비교객체'가 저장된 index값을 반환하고
		// 없으면 -1을 반환한다.
		//index of 는 검색방향이 앞에서부터 뒤쪽으로, lastIndexOf()메소드는 뒤에서 앞쪽으로 검색
		// 비교객체가 많으면 검색해서 첫번째로 찾아진 데이터의 위치값을 반환.
		list2.add("aaa");
		list2.add("bbb");
		list2.add("ccc");
		list2.add("ddd");
		list2.add("eee");
		
		System.out.println("ddd의 위치값: " + list2.indexOf("ddd"));
		System.out.println("zzz의 위치값: " + list2.indexOf("zzz"));
		System.out.println("ddd의 위치값: " + list2.lastIndexOf("ddd")); //뒤쪽의 ddd위치
		
		// - toArray() => 리스트 안의 데이터를 배열로 변환해서 반환한다.
		// 기본적으로 Object형 배열로 변환한다.
		// - toArray(new 제네릭 타입명[0]) ==> 제네릭 타입의 배열로 변환해서 반환한다.
		Object[] strArr = list2.toArray();
		//String strArr = list2.toArray(); //스트링으로 직접 변환 안됨(사용불가)
		System.out.println("배열의 개수: " + strArr.length);
		
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(i+"번째 자료"+ strArr[i]);
		}
		System.out.println("------------------------------------");
		//제네릭 타입의 배열로 변환해서 가져오기
		String[]strArr2 = list2.toArray(new String[0]);
		for (String s : strArr2) {
			System.out.println(s);
		}
		
		
	}
}
