package chapter26;

import java.util.*;
import java.util.Map.Entry;

import chapter13_Filed.Member;
public class HashMapEx {
	public static void main(String[] args) {
		//Map => HashMap, HashTable, TreeMap, LinkedHashMap, Properties
		Map<String, Integer> map = new HashMap<>();
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); //같은 키값인 홍길동객체를 95로 덮어씀
		System.out.println(map.size());
		System.out.println(map.get("홍길동"));
		
		//1. entry로 접근
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		//entrySet.interator(); => while문으로 접근
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Entry<String,Integer> entry = entryIterator.next();
			System.out.println(entry.getKey()+":"+entry.getValue());		
		}
		
		//entruySet => foreach문으로 접근
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		//2. key로 접근
		Set<String> keySet = map.keySet();
		for (String Key : keySet) {
			System.out.println("  "+Key +":"+map.get(Key));
		}
		
		//3. value로 접근 => 키값은 모름.
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println(value);
		}
		
		Map<Member, Integer>map2 = new HashMap<>();
//		map2.put(new Member("홍길동", 30), 90);
//		map2.put(new Member("홍길동", 30), 95);
//		System.out.println(map2.get(new Member("홍길동",30)));
	}
}
