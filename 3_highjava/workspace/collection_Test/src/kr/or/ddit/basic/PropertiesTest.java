package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {
	/* 
	 * Properties 객체는 Map의 축소된 기능의 객체라고 할 수 있다.
	 * Map은 key값과 value값에 모든 종류의 객체를 사용할 수 있지만
	 * Properties객체는 key와 value에 String만 사용할 수 있다.
	 * 
	 * Map은 put(), get()메소드를 이용하여 데이터를 입출력하지만 
	 * Properties객체는 setProperty(), getProperty() 메소드를 사용하여 입출력한다.
	 * Properties객체는 데이터를 파일로 입출력 할 수 있다. 
	 */
public static void main(String[] args) {
	Properties prop = new Properties(); //객체생성
	prop.setProperty("name", "Sun");
	prop.setProperty("age", "20"); //숫자를 넣고싶으면 문자열로 변환하여 사용
	
	//숫자형 변수를 넣을때 사용하는 방법
	int age = 25;
	prop.setProperty("age2", ""+ age); //방법1
	prop.setProperty("age3", String.valueOf(age));//방법2
	
	prop.setProperty("tel", "010-1717-1717");
	prop.setProperty("addr", "Deajeon");
	
	//데이터 꺼내오기
	String name = prop.getProperty("name");
	String strAge = prop.getProperty("age");
	String tel = prop.getProperty("tel");
	String addr = prop.getProperty("addr");
	//숫자형 변수를 넣었을때 꺼내오는 방법
	int iAge = Integer.parseInt(prop.getProperty("age2"));
	
	System.out.println(name +"  "+ strAge +"  "+ tel+"  " + addr);
	System.out.println(iAge);
}
}
