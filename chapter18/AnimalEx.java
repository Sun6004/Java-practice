package chapter18;

public class AnimalEx {

	public static void main(String[] args) {
		Tiger tiger = new Tiger();
		Cat cat = new Cat();
		tiger.sound();
		cat.sound();
		System.out.println("---------");
		
		//변수의 자동타입 반환
		Animal animal=null;
		animal = new Tiger(); //자동 타입 변환 및 재정의된 메소드 호출
		animal.sound();
		
		animal = new Cat();
		animal.sound();
		System.out.println("---------");
		
		animalSound(new Tiger());//자동 타입반환
		animalSound(new Cat());
	}
	public static void animalSound(Animal animal) {
		animal.sound(); //재정의된 메소드 호출
	}

}
