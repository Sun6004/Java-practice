package chapter24;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import chapter23.Member;

public class ClassExample {
	public static void main(String[] args) {
	Class<Member> clazz = Member.class;
	//Class clazz2 = Class.forName("chapter23.Member");
	System.out.println(clazz.getName());
	System.out.println(clazz.getSimpleName());
	System.out.println(clazz.getPackage());
	
	clazz.getDeclaredFields(); //private까지 모든 필드들을 가져옴
	Member member = new Member("1");
	
	Field[] fields = clazz.getDeclaredFields();
	// <Reflection>
//	field.setAccessible(true);
//	Consstructor[] constructor = clazz.getConstructors();
//	Member member = null;
//	for(Constructor constructor : constructor) {
//		member = (Member) constructor.newInstance("1");
//	}
//	System.out.println(member.getClass());
//	Field[] fields = clazz.getDeclaredFields();
	
	for (Field field : fields) {
		System.out.println("필드명: " + field.getName());
		System.out.println("필드타입: " + field.getType());
		field.setAccessible(true);
//	field.set(member, "123");
		
		
	}
	
	Method[] methods = clazz.getDeclaredMethods();
	for(Method method : methods) {
		System.out.println("메소드명"+ method.getName());
		System.out.println("메소드 반환타입"+ method.getModifiers());
	}
}
}
