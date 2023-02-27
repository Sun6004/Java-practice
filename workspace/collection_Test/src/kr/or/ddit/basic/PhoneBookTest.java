//package kr.or.ddit.basic;
//
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.Set;
//
///*문제) 이름, 주소 전화번호를 멤버로 갖는 Phone클래스를 만들고
// * Map을 이요하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
// * -Map의 구조: 주소값은 입력한 '이름'으로 사용하고 value값은 Phone클래스의 인스턴스로 한다.
// * HashMap<String, Phone> 변수명;
// * 
// * -아래 메뉴를 구현한다.
// *  1. 전화번호 등록
// *  2. 전화번호 수정
// *  3. 전화번호 삭제
// *  4. 전화번호 검색
// *  5. 전화번호 전체 출력
// *  0. 프로그램 종료
// *  ---------------------------------
// *   번호입력>> 1
// *   
// *   새롭게 등록할 전화번호 정보를 입력하세용.
// *   이름: 홍길동
// *   전화번호: 010-0000-1717
// *   주소: 대전역
// *  
// *   홍길동 씨의 전화번호 정보가 등록되었습니다.
// *   
// *   (등록된 이름을 입력할 경우)
// *   홍길동 은 이미 등록된 이름입니다.
// *   
// *   번호입력>> 5
// *   ------------------------------------
// *   번호	이름	전화번호		주소
// *    1		홍길동	010-0000-1717	대전역
// */
//public class PhoneBookTest {
//	public static void main(String[] args) {
//		Phone ph = new Phone();
//		HashMap<String, Phone> phoneBookMap;
//		Scanner sc = new Scanner(System.in);
////		pubilc PhoneBookTest() {
////			
////		}
//		
//		new PhoneBookTest().phoneBookStart();
//		
////		private HashMap<String, Phone> phoneBookMap;
//		int menuNum = sc.nextInt();
//				
//}
//		private void phoneBookStart() {
//			System.out.println();
//			System.out.println("전화번호 관리 프로그램");
//			System.out.println();
//			
//			while(true) {
//				int choice = displayMenu();
//				
//				switch (choice) {
//				case 1:
//					insert();
//					break;
//				case 2:
//					upDate();
//					break;
//				case 3:
//					delete();
//					break;
//				case 4:
//					search();
//					break;
//				case 5:
//					displayAll();
//					break;
//				case 0:
//					System.out.println("프로그램을 종료합니다.");
//					return;
//
//				default:
//					System.out.println("잘못된 번호를 입력하였습니다.");
//					break;
//				}
//			}
//	}
//		/*
//		 * Scanner 의 next(), nextInt(), nextDouble() 등...
//		 *  ==> 띄어쓰기, tab키,Enter키를 구분 문자로 분리해서 분리된 자료만 읽어간다.
//		 * Scanner 의 nextLine() 
//		 *  ==> 한 줄 단위로 입력한다.(즉, 자료를 입력하고 Enter 키를 누르면 Enter키까지 읽어 Enter키를 뺀 나머지를 반환한다.)
//		 *  
//		 *  -컴퓨터의 입력 작업은 입력된 데이터를 입력 버퍼에 저장하고 이것을 차례로 꺼내가는 방법으로 처리된다.
//		 * 그래서 next(), nextInt()등과 같은 메소드를 실행한 후에 nextLine()을 사용할 때는
//		 * 입력 버퍼를 비워줘야 한다.(방법: nextLine()을 한번 더 사용한다.)
//		 */
//		private void search() {
//			
//		}
//		// 전화번호 정보를 등록하는 메소드
//		private static void insert() {
//			Scanner sc = new Scanner(System.in);
//			System.out.println();
//			System.out.println("새롭게 등록할 전화번호를 입력하세요.");
//			System.out.print("이름입력: ");
//			String name = sc.next();
//				
//			
//			HashMap<String, String> phoneBookMap;
//			//이미 등록된 사람인지 여부 검사
//			if(phoneBookMap.containsKey(name)==true) {
//				System.out.println(name+"씨는 이미 등록된 사람입니다." );
//				return;
//			}
//			System.out.print("전화번호: ");
//			String tel = sc.next();
//			
//			sc.nextLine();
//			System.out.print("주소: ");
//			String addr = sc.nextLine();
//				
//			Phone p = new Phone(name, tel, addr);
//			phoneBookMap.put(name, p);
//			System.out.println(name+ "씨 전화번호 정보 등록완료!");
//			}
//				
//	//메뉴를 출력하고 사용자가 입력한 작업번호를 반환하는 메소드
//	private int displayMenu() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("---------------------------------");
//		System.out.println("1. 전화번호 등록");
//		System.out.println("2. 전화번호 수정");
//		System.out.println("3. 전화번호 삭제");
//		System.out.println("4. 전화번호 검색");
//		System.out.println("5. 전화번호 전체 출력");
//		System.out.println("0. 프로그램 종료");
//		System.out.println("---------------------------------");
//		System.out.println("");
//		System.out.print("번호입력: ");
//		return sc.nextInt();
//
//		
//	}
//	//전화번호 정보를 삭제하는 메소드
//	private static void delete() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println();
//		System.out.println("삭제할 전화번호 정보를 입력하세요.");
//		System.out.print("삭제할이름: ");
//		String name = sc.next();
//		
//		//삭제할 대상이 있는지 검사
//		if(!phoneBookMap.containsKey(name)==true) {
//			System.out.println(name+"씨는 이미 등록되지 않은 사람입니다." );
//			return;
//		}
//		phoneBookMap.remove(name);
//		
//		System.out.println(name+ "씨의 정보를 삭제했습니다.");
//	}
//	//전화번호 정보를 수정하는 메소드
//	private static void upDate() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println();
//		System.out.println("수정할 전화번호 정보를 입력하세요.");
//		System.out.print("이름입력: ");
//		String name = sc.next();
//		
//		//수정할 대상이 등록되어 있지 않으면 수정 작업을 못함
//		if(!phoneBookMap.containsKey(name)==true) {
//			System.out.println(name+"씨는 이미 등록되지 않은 사람입니다." );
//			return;
//		}
//		System.out.print("새로운 전화번호: ");
//		String newTel = sc.next();
//		System.out.print("새로운 주소");
//		String newAddr = sc.next();
//		
//		//같은 key값에 새로운 전화번호 정보를 저장한다. ==> 수정작업
//		phoneBookMap.put(name, newPhone(name,newTel,newAddr));
//		
//		System.out.println(name+"씨의 전화번호 정보를 변경했습니다.");
//		}
//	
//	//전화번호 전체 출력하는 메소드
//	private static void displayAll() {
//		System.out.println();
//		System.out.println("--------------------------");
//		System.out.println("번호 \t 이름 \t 전화번호 \t주소");
//		System.out.println("--------------------------");
//		
//		Set<String> phoneKeySet = phoneBookMap.keySet();
//		
//		if(phoneKeySet.size()==0) {
//			System.out.println("등록된 전화번호 정보가 없습니다.");
//		}else {
//			int num = 0;
//			for (String name : phoneKeySet) {//Set개수만큼 반복
//				num++;
//				Phone p = phoneBookMap.get(name); //value값(phone 객체) 구하기
//				System.out.println(num+"\t"+p.getName() +"\t"+p.getTel()+"\t" +p.getAddr());
//			}
//		}
//	}
//
//}
//class Phone{
//	private String name;
//	private String tel;
//	private String addr;
//	
//	
//	public Phone() {
//		super();
//	}
//
//	public void Phone(String tel, String addr) {
//		this.tel = tel;
//		this.addr = addr;
//	}
//
//	public Phone(String name, String tel, String addr) {
//		super();
//		this.name = name;
//		this.tel = tel;
//		this.addr = addr;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getTel() {
//		return tel;
//	}
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//	public String getAddr() {
//		return addr;
//	}
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}
//
//	@Override
//	public String toString() {
//		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
//	}
//	
//}
