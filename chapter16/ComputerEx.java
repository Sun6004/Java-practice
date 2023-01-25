package chapter16;

public class ComputerEx {

	public static void main(String[] args) {
		int r = 10;
		
		Caculator calculator = new Caculator();
		System.out.println("원면적: "+calculator.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		System.out.println("원면적: "+computer.areaCicle(r));

	}

}
