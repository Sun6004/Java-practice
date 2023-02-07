package chaptet27;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory(int memory) {//계산기에 메모리 값을 저장하는 메소드 
		//synchronized : 스레드가 메소드를 실행하는 즉시 객체잠금 스레드가 메소드를 실행 종료할 때까지
		this.memory = memory;
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
		
		System.out.println(Thread.currentThread().getName()+":"+ this.memory);
	}
}
