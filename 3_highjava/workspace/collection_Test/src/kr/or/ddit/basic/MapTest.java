package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		/*
		 *  -Map : key값과 value값을 한 쌍으로 관리하는 객체
		 *   - key값은 중복을 허용하지 않고 순서(index)가 없다.(set의 특징과 같음.)
		 *   - value값은 중복을 허용.
		 */
		
		HashMap<String, String> map = new HashMap<>();
		//자료추가 => put(key, value)
		map.put("name", "Hong");
		map.put("addr", "Deajeon");
		map.put("tel", "010-7777-7777");
		
		//Set과 비슷하게 순서가 랜덤하게 나옴
		System.out.println("map: " + map);
		
		//자료수정 ==> 데이터를 추가할 때 key값이 같으면 나중에 입력한 값으로 덮어쓴다.
		map.put("addr", "Seoul");
		System.out.println("map: " + map);
		
		
		//자료삭제 ==> remove(key): key값이 같은 자료를 찾아 삭제한다. 삭제된 자료의 value값이 반환됨
//		String temp = map.remove("tel");
//		System.out.println("map: " + map);
//		System.out.println(temp);//반환된value값
		
		//자료읽기 ==> get(key): key값과 짝이되는 value값이 반환됨.
		// 주어진 key 값이 map에 없으면 null이 반환
		System.out.println("이름: "+map.get("name"));
		
		//key값의 존재 여부를 확인 ==> containsKey(key)
		// map에 해당 key값이 있는지 검사해서 true / false
		
		System.out.println("tel존재여부: " + map.containsKey("tel"));
		System.out.println("age존재여부: " + map.containsKey("age"));
		System.out.println("---------------------------------------------");
		
		//map에 저장된 모든 데이터를 읽어와 사용하기
		//방법1) 모든 key값을 가져와 처리하기 ==> keySet()메소드 이용
		// keySet()메소드는 map에 있는 모든 key값을 읽어와 Set형으로 반환하는 메소드
		
		//방법1-1) keySet()정보를 Iterator로 처리하기
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next(); //key값 한개 가져오기
			String value = map.get(key);
			
			System.out.println(key+":"+value);
		}
		System.out.println("---------------------------------------------");
		
		//방법1-2) keySet()정보를 forEach문으로 처리하기
		for (String key : map.keySet()) {
			String value = map.get(key);
		
			System.out.println(key+":"+value);
		}
		System.out.println("---------------------------------------------");
		
		//방법2) value값만 가져와서 처리하기
		for (String value : map.values()) {
			System.out.println(value);
		}

	}
}
