package chapter14;

public class MemberService {

	String name = "hong";
	int age = 20;
	
	boolean login(String id, String pw) {
			if("hong".equals(id)&& "12345".equals(pw)) {
				System.out.println("로그인 성공");
				return true;
			}else {				
				System.out.println("로그인 실패");
				return false;
			}//return 문에선 else 생략가능
		}
	
	void logout(String id) {
		System.out.println(name+" 로그아웃 되었습니다.");
	}	
	
}
