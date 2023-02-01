package chapter21;

public class Anonymous {
	RemoteControl field = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("On TV");
		}
		
		@Override
		public void turnOff() {
			System.out.println("Off TV");
		}
	};
}
