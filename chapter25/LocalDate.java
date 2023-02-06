package chapter25;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDate {
	public static void main(String[] args) {
		//LocalDate => 날짜만 사용가능
		//LocalDateTime => 날짜와 시간도 가능
		
		LocalDateTime now = LocalDateTime.now(); //현재시각 반환
		System.out.println(now);
		
		// method chaining 방식
		String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd E hh:mm:ss.SSS"));
		System.out.println(format);
	}
}
