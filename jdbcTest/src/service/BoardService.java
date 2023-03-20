package service;

import java.util.List;

import vo.BoardVO;
import vo.MemberVO;

public interface BoardService {
	
	/**
	 * 
	 * @param boardVo insert할 데이터가 저장
	 * @return 성공실패 1/0
	 */
	public int insert(BoardVO boardVo);
	
	/**
	 * 게시물 no를 매개변수로 받아서 해당 게시물을 삭제하는 메서드
	 * 
	 * @param no 삭제할 게시글no
	 * @return 삭제성공 : 1, 삭제 실패 : 0
	 */
	public int delete(int no);
	
	/**
	 *  update메서드
	 * 
	 * @param boardVo  update할 게시물 정보가 저장된 객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int update(BoardVO boardVo);
	
	/**
	 * DB의 전체 게시물을 가져와서 List에 담아서 반환하는 메서드
	 * 
	 * @return BoardVO 객체가 저장된 List객체
	 * 
	 */
	public List<BoardVO> getAllBoard();
}
