package chapter02;

public class VariableUseExample {

	public static void main(String[] args) {
		int x =3;
		int y =5;
		System.out.println("x:" + x + ", y:" +y);
		
		//temp에 먼저x를 넣은후 x에 y를 저장
		int temp = x;
		x = y;
		y = temp;
		System.out.println("x:" + x + ", y:" +y);
	}//

}
