package chapter22;

public class ClassCastExceptionExample {
	class InnerClass{}
	public static void main(String[] args) {
		Cat cat = new Cat();
		changeCat(cat);
		
		Tiger tiger = new Tiger();
		changeCat(tiger);
	}
	
	public static void changeCat(Animal animal) {
		if(animal instanceof Cat) { //타입체크 <= 없으면 ClassCastException 오류 발생가능 
			Cat cat = (Cat) animal; //10라인에서 Tiger객체를 매개값으로 주어 Cat타입으로 변환할 수 없기 때문
		}
	}
	
}
 class Animal{}
 class Cat extends Animal{}
 class Tiger extends Animal{}