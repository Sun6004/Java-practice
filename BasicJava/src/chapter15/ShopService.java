package chapter15;

public class ShopService {
	
	private static ShopService singletone = new ShopService();
	
	private ShopService(){}
	
	static ShopService getInstans() {
		return singletone;
	}
	

	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstans();
		ShopService obj2 = ShopService.getInstans();
		
		if(obj1 == obj2) {
			System.out.println("같은 객체입니다.");
		}else {
			System.out.println("다른 객체입니다.");
		}
		
}
}
