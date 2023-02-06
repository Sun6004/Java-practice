package chapter25;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateEx {
	public static void main(String[] args) {
		Date date = new Date();//시간이 갈때마다 계속 객체를 생성해야해서 효율적이지 못함
		
		
		//우리나라에서는 보기 힘든 날짜표현방식
		String dateString = date.toString();
		System.out.println(dateString);
		
		//날짜 포멧팅 SimpleDateFormat
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD E hh:mm:ssS");//날자와 시간 패턴에 맞게 문자열을 지정
		String format = dateFormat.format(date);
		System.out.println(format);
		
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		int msec = calendar.get(Calendar.MILLISECOND);
		int dayOfW = calendar.get(Calendar.DATE);
		
		System.out.printf("%4d-%02d-%02d %02d:%02d:%02d.%03d %d",year, month +1, day, hour, minute, sec, msec, dayOfW);
		
		
	}
}
