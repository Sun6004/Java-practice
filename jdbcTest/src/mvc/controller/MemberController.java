package mvc.controller;

import java.util.Scanner;

import mvc.service.IMemberService;

public class MemberController {
	private Scanner sc;
	private IMemberService service;

	public static void main(String[] args) {
		
		

	}

	public MemberController(Scanner sc, IMemberService service) {
		super();
		this.sc = sc;
		this.service = service;
	}
	private void DisplayMenu() {
		System.out.println();
		System.out.println("-----------------------");
		System.out.println("회원 관리 프로그램");
		System.out.println("-----------------------");
		System.out.println("1. 자료추가");
		System.out.println("2. 자료삭제");
		System.out.println("3. 자료수정");
		System.out.println("4. 전체자료출력");
		System.out.println("5. 자료선택수정");
		System.out.println("0. 프로그램 종료");
		System.out.println("----------------------");
	}
}
