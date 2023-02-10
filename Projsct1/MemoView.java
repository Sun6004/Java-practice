package Projsct1;

import java.util.List;
import java.util.Scanner;

public class MemoView {
	public void printMemos(List<MemoVO> list) {
		System.out.println("메모 전체 목록");
		for (MemoVO vo : list) {
			System.out.println(vo);
		}
	}
	public MemoVO insertInputMemo(Scanner scanner) {
		System.out.print("제목: ");
		String title = scanner.nextLine();
		System.out.print("내용: ");
		String content = scanner.nextLine();
		System.out.println("작성자: ");
		String writer = scanner.nextLine();
		return new MemoVO(title, content, writer);
	}
	public void insertResult(int count) {
		if(count > 0) {
			System.out.println("메모가 정상적으로 등록되었습니다.");
		}else{
			System.out.println("메모가 정상적으로 등록되지 않았습니다.");
		}
	}
}
