package chapter26;

import java.util.*;
public class HashSetEx {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java"); //Hash는 같은 문자열의 객체는 같은 객체로 보고 한번만 저장
		set.add("myBATIS");
		set.add("Database");
		
		set.remove("Database"); //인덱스가 없기때문에 삭제할 객체를 직접 지정해줘야함
		
		System.out.println("총 객체수: "+set.size());
		
		//모든 원소에 접근해서 데이터 가져오기
		Iterator<String> iterator = set.iterator();
		
		
		//객체를 지정해서 꺼낼수 없기떄문에 조건문을 사용해서 하나씩 꺼냄(순서는 랜덤)
		while (iterator.hasNext()) {//객체 수만큼 루핑
			String element = iterator.next();
			System.out.println(element);
		}		
		//향상된for문
		iterator = set.iterator();
		for(String element : set) {
			System.out.println("\t"+element);	
		}
	}
}
