package chapter18;

public class Student extends Human{
	
	private String major;
	
	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String toString() {
		
		return String.format("전공: " + major);
	}

}
