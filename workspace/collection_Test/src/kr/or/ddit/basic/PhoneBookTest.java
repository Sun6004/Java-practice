package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

/*문제) 이름, 주소 전화번호를 멤버로 갖는 Phone클래스를 만들고
 * Map을 이요하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * -Map의 구조: 주소값은 입력한 '이름'으로 사용하고 value값은 Phone클래스의 인스턴스로 한다.
 * HashMap<String, Phone> 변수명;
 * 
 * -아래 메뉴를 구현한다.
 *  1. 전화번호 등록
 *  2. 전화번호 수정
 *  3. 전화번호 삭제
 *  4. 전화번호 검색
 *  5. 전화번호 전체 출력
 *  0. 프로그램 종료
 *  ---------------------------------
 *   번호입력>> 1
 *   
 *   새롭게 등록할 전화번호 정보를 입력하세용.
 *   이름: 홍길동
 *   전화번호: 010-0000-1717
 *   주소: 대전역
 *  
 *   홍길동 씨의 전화번호 정보가 등록되었습니다.
 *   
 *   (등록된 이름을 입력할 경우)
 *   홍길동 은 이미 등록된 이름입니다.
 *   
 *   번호입력>> 5
 *   ------------------------------------
 *   번호	이름	전화번호		주소
 *    1		홍길동	010-0000-1717	대전역
 */
public class PhoneBookTest {
	public static void main(String[] args) {
		Phone ph = new Phone();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---------------------------------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("---------------------------------");
		
		System.out.println("");
		System.out.print("번호입력: ");
		int menuNum = sc.nextInt();
		switch (menuNum) {
		case 1:
			System.out.print("");
			System.out.print("");
			System.out.print("");
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 0:
			System.out.println("프로그램을 종료합니다.");
			System.exit(1);

		default:
			break;
		}
		
		
	}
	private void intoNum(){
		
	}
}



class Phone{
	String name;
	String tel;
	String addr;
	
	
	public Phone() {
		super();
	}
	

	public void Phone(String tel, String addr) {
		this.tel = tel;
		this.addr = addr;
	}


	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
