package chapter24;

public class TimeExample {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis()); //시간이 얼마나 걸리는지 측정할 때 주로 사용
		
		long time1 = System.nanoTime(); //시작시간 읽기
		
		int sum = 0;
		for (int i = 1; i <=1000000; i++) {
			sum += i;
		}
		
		long time2 = System.nanoTime(); //끝 시간
		
		System.out.println("1~1000000까지 합: " +sum);
		System.out.println("계산에"+ (time2-time1)+"나노초가 소요됨.");
	}
}
