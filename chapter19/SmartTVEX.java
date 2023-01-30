package chapter19;

public class SmartTVEX {
	public static void main(String[] args) {
		SmartTV tv = new SmartTV();
		
		RemoteControl rc = tv;
		Searchable searchable = tv;
	}

}
