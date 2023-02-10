package Projsct1;

import javax.sound.midi.ControllerEventListener;

public class MemoApplication {
	public static void main(String[] args) throws Exception{
		FrontController frontController = new FrontController();
		frontController.process();
	}
}
