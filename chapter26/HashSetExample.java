package chapter26;

import java.util.*;

import chapter26.Student;

public class HashSetExample {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(1,"홍길동"));
		set.add(new Student(2,"신용권"));
		set.add(new Student(1,"조민우")); //학번이같으므로 저장되지않음
		
		Iterator<Student> iterator = set.iterator();
		for (Student student : set) {
			System.out.println(student.studentNum + ":" +student.name);
		}
	}
}
