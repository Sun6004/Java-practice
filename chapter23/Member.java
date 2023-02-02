package chapter23;

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Member)) {
			return false;
		}
		Member member = (Member) obj;
		return id.equals(member.id);
	}
	
	public int hashCode() {
		return id.hashCode();
	}
}
