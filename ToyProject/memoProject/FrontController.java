package memoProject;


public class FrontController {
	private static FrontController instance = new FrontController();
	private FrontController() {
		
	}
	public static FrontController getInstance() {
		return instance;
	}
	private MemoController controller = MemoController.getInstance();
	private MemoView view = Memoview.getInstance();
	
	
}
