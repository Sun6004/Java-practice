package chapter26;

import java.util.*;

public class HashTableEx {
	public static void main(String[] args) {
		Map<String,String> map = new Hashtable<String,String>();
		
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Login ");
			System.out.print("Id: ");
			String id = sc.nextLine();
			System.out.print("Pw: ");
			String pw = sc.nextLine();
			
			if(map.containsKey(id)) {//아이디인 키가 존재하는지 확인
				if(map.get(id).equals(pw)) { //비밀번호를 비교
					System.out.println("Login sucsess");
					break;
				}else {
					System.err.println("pw X");
				}
			}else {
				System.err.println("id X");
			}
		}
	}
}
