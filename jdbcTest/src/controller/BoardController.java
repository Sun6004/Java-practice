package controller;

import java.util.Scanner;

import vo.BoardVO;

public class BoardController {
	private Scanner sc;
	
	
	public static void main(String[] args) {
		new BoardController().startBoard();
	}
	
	
	public void startBoard() {
		while(true) {
			int choice = dpMenu();
			
			switch (choice) {
			case 1:
				insert();
				break;
			case 2:
				look();
				break;
			case 3:
				update();
				break;
			case 4:
				serch();
				break;
			case 0:
				System.out.println("게시판을 종료합니다.");
				return;

			default:
				System.out.println("번호 잘못입력");
				break;
			}
		}
	}
	
	private void look() {
		// TODO Auto-generated method stub
		
	}


	private void update() {
		// TODO Auto-generated method stub
		
	}


	private void serch() {
		// TODO Auto-generated method stub
		
	}


	//게시글을 등록하는 메서드
	private void insert() {
		String title = null;
		String writer = null;
		String content = null;
		
		
		System.out.println();
		System.out.print("제목을 입력하세요: ");
		title = sc.nextLine();
		System.out.print("작성자를 입력하세요: ");
		writer = sc.nextLine();
		System.out.print("내용입력: ");
		content = sc.nextLine();
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		
	}


	private int dpMenu() {
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 선택");
		System.out.println("-------------------------------------------------------------");
		System.out.println(" 1. 새글작성 ");
		System.out.println(" 2. 게시글수정 ");
		System.out.println(" 3. 게시글삭제");
		System.out.println(" 4. 게시글 검색");
		System.out.println(" 5. 전체목록 출력");
		System.out.println(" 0. 프로그램 종료");
		System.out.println("-------------------------------------------------------------");
		
		return sc.nextInt();
		
	}
}
