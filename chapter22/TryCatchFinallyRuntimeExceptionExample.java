package chapter22;

public class TryCatchFinallyRuntimeExceptionExample {
	public static void main(String[] args) { // String[] args = {}; 현재 값이 없음
		String data1;
		String data2;
		//alt+Shift+z : try/catch 단축키
		try {
			data1 = args[0];
			data2 = args[1];
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;
		}
		
		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(result);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			System.out.println("숫자로 변환할 수 없습니다.");
		}finally {
			System.out.println("다시 실행하세요.");
		}
	
	
	}
}
