package chapter26;

import java.util.*;
import java.util.Vector;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListEx {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		list = new Vector<>();
		list = new LinkedList<>();
		
		list.add("java");//0
		list.add("JDBC");//1
		list.add("Servlet/JSP"); //2번쨰 인덱스에 "Database"를 넣었기떄문에 3번인덱스로 밀림
		list.add(2, "Database"); //2번째 인덱스에 "Database"를 넣음
		list.add("iBATIS");//4
		
		System.out.println(list.size());
		
		String string = list.get(2);
		System.out.println(string);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i +": "+ list.get(i));
		}
		
		//list 삭제
		list.remove(2); //"Database" 가 삭제되고 "Servlet/JSP"가 2번인덱스에 들어감
		list.remove(2); //"Servlet/JSP"가 삭제
		list.remove("iBATIS");
		for(String str : list) {
			System.out.println(str);
		}
		list.clear(); //모든데이터 삭제

	}
}
