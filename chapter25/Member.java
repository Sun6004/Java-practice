package chapter25;

public class Member {
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return id+ ":" + name;
	}

	public static void main(String[] args) {
		Member member = new Member("blue", "파란");
		System.out.println(member);
	}
}
