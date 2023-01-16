package chapter11;
import java.util.Calendar; 

public class EnumExample {
	public static void main(String[] args) {
		
	
	Calendar now= Calendar.getInstance();
	
	int week = now.get(Calendar.DAY_OF_WEEK);
	Week today = null;
	
	switch (week) {
	case 1 :
		today = Week.SUNDAY;
		break;
	case 2 :
		today = Week.MONDAY;
		break;
	case 3 :
		today = Week.TUESDAY;
		break;
	case 4 :
		today = Week.WEDNESDAY;
		break;
	case 5 :
		today = Week.THURSDAY;
		break;
	case 6 :
		today = Week.FRIDAY;
		break;
	case 7 :
		today = Week.SATURDAY;
		break;
	}
	System.out.println("오늘요일: " +today+today.korName);
	if (today == Week.SUNDAY) {
		System.out.println("일요일엔 쉽니다.");
	}else {
		System.out.println("공부를 합니다.");
	}
	}
}
