package threadTest;

public class ThreadTest19 {
	
	public static void main(String[] args) {
		DataBox databox = new DataBox();
		
		ProducerThread th1 = new ProducerThread(databox);
		ConsumerThread th2 = new ConsumerThread(databox);
		
		th1.start();
		th2.start();
	}
}

//데이터를 공통으로 사용하는 클래스
class DataBox{
	private String value;
	
	//데이터를 꺼내가는 메소드
	// ==> value 변수값이 null이면 value변수에 문자열이 채워질때까지 기다리고,
	// 	   value 변수에 값이 있으면 해당 문자열을 반환한다.
	// 문자열을 반환 후에는 value변수를 null로 만든다.
	public synchronized String getValue() {
		if(value == null) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		//value값을 반환하고 value를 null로 만듬
		String temp = value;
		System.out.println("쓰레드가 읽은 데이터: "+temp);
		
		value = null;		
		notify(); //null이 되었으니 value값을 채워줄 상대 쓰레드 깨우기
		
		return temp;
	}
	
	
	//데이터를 저장하는 메소드
	// ==> value변수에 값이 있으면 value변수가 null이 될 때까지 기다림
	// 		value변수가 null이 되면 새로운 데이터값을 저장
	public synchronized void setValue(String value) {
		if(this.value != null) { //value에 값이 있으면
			try {
				wait();
			} catch (InterruptedException e) {
			}	
		}
		this.value = value;
		System.out.println("Thread에서 새로 저장한 데이터: " + this.value);
		
		notify();
	}
}

//데이터를 공급하는 쓰레드
class ProducerThread extends Thread{
	private DataBox box;

	public ProducerThread(DataBox box) {
		super();
		this.box = box;
	}	
	@Override
	public void run() {
		String[] nameArr = {"Hong", "Lee", "Kim"};
		for (int i = 0; i < nameArr.length; i++) {
			box.setValue(nameArr[i]);
		}
	}
}

//데이터를 꺼내서 사용하는 쓰레드
class ConsumerThread extends Thread{
	private DataBox box;
	private String data;

	public ConsumerThread(DataBox box) {
		super();
		this.box = box;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			setData(box.getValue());
		}
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}