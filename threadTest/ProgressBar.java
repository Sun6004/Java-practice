package threadTest;

public class ProgressBar {
	public static void main(String[] args) {
		PbThread ts = new PbThread();
		
		ts.start();
	}	
}

class PbThread extends Thread{
	@Override
	public void run() {
		int tot = 51;
		
		for (int i = 1; i < tot; i++) {
			int prog = i*51/tot;
		System.out.print("\r[");
		for (int j = 1; j < 50; j++) {
			if(j * 1 < prog) {
				System.out.print(">");
			}else {
				System.out.print("");
			}
			
		}
		
		System.out.printf("] %d%%",prog,"\n--------------------------------------------------");
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
		}
		}
		
	}

}
