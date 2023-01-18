package chapter13_Filed;

public class Car {
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	//생성자
	Car(){
		
	}
	Car(String model){
		this.model = model;
	}
	Car(String model, String color){
		this.model = model;
		this.color = color;
	}
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	//중복코드 줄이기
	/*Car(){
	 *  this(null, null, 0);
	}
	Car(String model){
		this(model, null, 0);
	}
	Car(String model, String color){
		this(model,color,0);
	}
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		
		//하나만 써도 호출해서 씀
		System.out.println("자동차가 생산되었습니다");
	
	*/
}
