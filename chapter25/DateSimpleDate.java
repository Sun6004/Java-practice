package chapter25;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSimpleDate {
	public static void main(String[] args) {
		Date now = new Date();
		
		SimpleDateFormat day = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
		System.out.println(day.format(now));
	}
}
