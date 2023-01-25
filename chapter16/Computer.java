package chapter16;

public class Computer extends Caculator {
	double areaCicle(double r) {
		System.out.println("Caculator 객체의 areaCircle()실행");
		// super.areaCircle(r);
		return Math.PI * r * r;
	}
}
