package board.controller;

import java.util.List;
import java.util.Scanner;

public class BoardController {
	private Scanner sc;
	private board.service.BoardService service;
	
	public static void main(String[] args) {
		new BoardController().startBoard();
	}
	public BoardController() {
		service = board.service.BoardServiceimpl.getInstance();
		sc = new Scanner(System.in);
	}
	
	public void startBoard() {
		String title = null;
		int choice = -1;
		while(true) {
			if(choice !=3) {
				title = null;
			}
			choice = dpMenu(title);
			
			switch (choice) {
			case 1:
				insert(); //게시글 작성
				break;
			case 2: //게시글 보기
				view();
				break;
			case 3: //검색
				serch();
				break;
			case 0:
				System.out.println("게시판을 종료합니다.");
				return;

			default:
				System.out.println("번호 잘못입력했습니다 다시입력하셈");
				break;
			}
		}
	}
	// 게시글 검색 메서드
	private String serch() {
		sc.nextLine();
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("검색 작업");
		System.out.println("---------------------------------------------------------------------");
		System.out.print("- 검색할 제목 입력: ");
		String title = sc.nextLine();
		
		return title;
	}
	private void view() {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력: ");
		int boardNo = sc.nextInt();
		
		board.vo.BoardVO boardVo = service.getBoard(boardNo);
		
		if(boardVo == null) {
			System.out.println(boardNo + "번의 게시글은 존재하지 않습니다.");
			return;
		}
		System.out.println();
		System.out.println(boardNo + "빈 글의 내용");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("- 제목: " + boardVo.getBoard_title());
		System.out.println("- 작성자: " + boardVo.getBoard_writer());
		System.out.println("- 내용: " + boardVo.getBoard_content());
		System.out.println("- 작성일: " + boardVo.getBoard_date());
		System.out.println("- 조회수: " + boardVo.getBoard_cnt());
		System.out.println();
		System.out.println("---------------------------------------------------------------------");	
		System.out.println("메뉴:   1.수정  	  2.삭제   		  3.리스트로 가기 ");
		System.out.println("---------------------------------------------------------------------");
		System.out.print("작업선택: ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1 : //수정
				update(boardNo);
				break;
			case 2 : //삭제
				delete(boardNo);
				break;
			case 3 : //리스트로 ㄱ
				return;
		
		}
		
	}

	//게시글 삭제하는 메서드
	private void delete(int boardNo) {
		int cnt = service.delete(boardNo);
		
		if(cnt>0) {
			System.out.println(boardNo+"번쨰 글이 삭제되었습니다.");
		}else {
			System.out.println(boardNo+"번 글 삭제 작업 실패!");
		}
		
	}
	private void update(int boardNo) {
		sc.nextLine(); // 버퍼비우기
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("---------------------------------------------------------------------");
		System.out.print("제목: ");
		String newTitle = sc.nextLine();
		System.out.print("내용: ");
		String newContent = sc.nextLine();
		
		//입력한 값과 게시글 번호를 VO객체에 저장한다.
		board.vo.BoardVO boardVo = new board.vo.BoardVO();
		boardVo.setBoard_no(boardNo);
		boardVo.setBoard_title(newTitle);
		boardVo.setBoard_content(newContent);
		
		int cnt = service.update(boardVo);
		
		if(cnt>0) {
			System.out.println(boardNo + "번 글이 수정되었습니다.");
		}else {
			System.out.println(boardNo+"번 글은 존재하지 않습니다.");
		}
	}
	//게시글을 등록하는 메서드
	private void insert() {
		String title = null;
		String writer = null;
		String content = null;
		
		sc.nextLine();//버퍼비우기
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("---------------------------------------------------------------------");
		System.out.println();
		System.out.print("제목을 입력하세요: ");
		title = sc.nextLine();
		System.out.print("작성자를 입력하세요: ");
		writer = sc.nextLine();
		System.out.print("내용입력: ");
		content = sc.nextLine();
		
		//입력받은 자료를 VO에 저장하기
		board.vo.BoardVO boardVo = new board.vo.BoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		
		int cnt = service.insert(boardVo);
		
		if(cnt>0) {
			System.out.println("새 글이 추가되었습니다..");
		}else {
			System.out.println("새 글 추가 실패!");
		}
		
	}


	//게시글 목록을 보여주고 메뉴를 나타내며 사용자가 입력한 메뉴 번호를 반환하는 메서드
	private int dpMenu(String searchTitle) {
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("NO	제목		작성자		조회수");
		System.out.println("-------------------------------------------------------------");
		
		List<board.vo.BoardVO> boardList = null;
		if(searchTitle == null) {
			boardList = service.getAllBoardList();			
		}else {
			boardList = service.getSearchBoardList(searchTitle);				
		}
		
		if(boardList == null || boardList.size() == 0) {
			System.out.println("게시글이 없습니다");
		}else {
			for(board.vo.BoardVO boardVo : boardList) {
				System.out.println(boardVo.getBoard_no() + "\t" + boardVo.getBoard_title() + "\t\t "
						+ boardVo.getBoard_writer() + "\t\t" + boardVo.getBoard_cnt());
			}
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴:  1.새글작성    2.게시글보기     3.검색     0.작업종료");
		System.out.println("-------------------------------------------------------------");
		System.out.print("작업선택: ");
		return sc.nextInt();
		
	}
}
