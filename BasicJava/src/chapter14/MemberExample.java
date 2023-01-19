package chapter14;

public class MemberExample {

	public static void main(String[] args) {
		MemberService mem = new MemberService();
		boolean result = mem.login("hong", "12345");
		if(result) {
			System.out.println(mem.name+" 로그인 되었습니다.");
			mem.logout("hong");
		}else {
			System.out.println("id혹은pw가 틀렸습니다");
		}
				

	}

}
