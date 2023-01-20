package chapter15;

public class Time {
	private int hour;
	private int minute; 
	private int second; 

	public Time() {

	}
	public Time(int hour, int minute, int second){		
		if(hour>24 || hour<0) {
			this.hour = 0;
		}else {
			this.hour = hour;
		}
		if(minute>60 || minute<0) {
			this.minute=0;
		} else {
			this.minute = minute;
		}
		if(second>60 || second<0) {
			this.second = 0;
		} else {
			this.second = second;
		}	
	}
	public String toString() {
		return String.format("%02d:%02d:%02d", hour,minute,second);
			
	}
}
