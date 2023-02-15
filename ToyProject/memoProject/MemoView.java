package memoProject;

import java.util.List;
import java.util.Scanner;

public class MemoView {
	private static MemoView instance = new MemoView();
	private MemoView() {
		
	}
	public static MemoView getInstance() {
		return instance;
	}
	public int mainMenu(Scanner scanner) {
		System.out.println("-----------------------------");
		System.out.println("1.목록|2.등록|3.수정|4.삭제|0.종료");
		System.out.println("-----------------------------");
		System.out.print("메뉴를 선택하세요▷");
		return Integer.parseInt(scanner.nextLine());
	}
	public memoVO insertMemo(Scanner scanner) {
		System.out.println("새 메모 작성");
		System.out.print("제목: ");
		String title = scanner.nextLine();
		System.out.print("내용: ");
		String content = scanner.nextLine();
		System.out.print("작성자: ");
		String writer = scanner.nextLine();
		return new memoVO(writer, title, content, writer);	
	}
	public void insertResult(int count) {
		if(count > 0) {
			System.out.println("메모가 정상 등록되었습니다.");
		}else {
			System.out.println("메모가 정상적으로 등록되지 않았습니다.");
		}
	}
	public void selectMemos(List<memoVO>memos) {
		System.out.println("전체 목록");
		for(memoVO vo : memos) {
			System.out.println(vo);
		}
	}
	public memoVO updateMemo(Scanner scanner) {
		System.out.println("수정할 메모 번호를 입력하세요. ");
		int no = Integer.parseInt(scanner.nextLine());
		System.out.print("제목: ");
		String title = scanner.nextLine();
		System.out.print("내용: ");
		String content = scanner.nextLine();
		System.out.print("작성자 아이디: ");
		String writer = scanner.nextLine();
		return new memoVO(writer, title, content, writer);
	}
	public void updateResult(int count) {
		if(count > 0) {
			System.out.println("메모가 수정되었습니다. ");
		}else {
			System.out.println("메모가 정상적으로 수정되지 않았습니다.");
		}
		
	}
	public int deleteMemo(Scanner scanner) {
		System.out.println("삭제할 메모 번호를 입력하세요.");
		return Integer.parseInt(scanner.nextLine());
	}
	public void deleteResult(int count) {
		if(count > 0) {
			System.out.println("메모가 삭제되었습니다.");
		}else {
			System.out.println("메모가 정상적으로 삭제되지 않았습니다.");
		}
	}
	
}
