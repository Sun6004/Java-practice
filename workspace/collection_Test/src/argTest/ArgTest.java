package argTest;

public class ArgTest {
	
	//메소드 만들기
	public int sumArr(int[] data ){
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	//가변형 인수 ==> 메서드의 인수 개수가 호출할 때마다 다를 때 사용한다.
	// -가변형 인수는 메서드 안에서는 배열로 처리된다.
	// -가변형 인수는 한가지 자료형만 사용할 수 있다.
	

	
	//가변형 인수용 메서드 만들기
	public int sumArg(int... data2) {
		int sum = 0;
		for (int i = 0; i < data2.length; i++) {
			sum += data2[i];
		}
		return sum;
	}
	//가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를 제일 뒤쪽에 배치해야 한다.
	public String sumArg2(String name, int... data2) { //가변형 변수를 일반변수(String)앞쪽에 배치하면 에러
		int sum = 0;
		for (int i = 0; i < data2.length; i++) {
			sum += data2[i];
		}
		return name + "씨의 점수: "+ sum;
	}
	
	public void myMethod(int a) {
		
	}
	
public static void main(String[] args) {
	ArgTest test = new ArgTest();
	
	int[] nums = {100,200,300};
	//nums = new int[]{100, 200, 300};
	
	System.out.println(test.sumArr(nums));
	//System.out.println(test.sumArr(new int[]{1,2,3,4,5 )); //1,2,3,4,5
	System.out.println(test.sumArg(100,200,300));
	System.out.println(test.sumArg(1,2,3,4,5));
	System.out.println();
	System.out.println(test.sumArg2("asd", 90,80,80));
	
	
	
	
//	int b = 100;
//	test.myMethod(b);
//	test.myMethod(200);
}
}
