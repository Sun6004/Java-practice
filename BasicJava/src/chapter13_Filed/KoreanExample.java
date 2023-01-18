package chapter13_Filed;

public class KoreanExample {

	public static void main(String[] args) {
	/*	Korean k1 = new Korean();
		k1.name = "박자바";
		k1.ssn = "1021345-1234567";
		
	  	Korean k2 = new Korean();
		k2.name = "김자바";
		k2.ssn = "1022245-1234567";
		
		Korean k3 = new Korean();
		k3.name = "최자바";
		k3.ssn = "1034345-1255567";
		
	*/
		Korean k1 = new Korean("박자바", "011225-1234567");
		System.out.println("k1.name: "+k1.name);
		System.out.println("k1.ssn: "+k1.ssn);
		
		Korean k2 = new Korean("감자바", "930525-0654321");
		System.out.println("k2.name: "+k2.name);
		System.out.println("k2.ssn: "+k2.ssn);
		
	}

}
