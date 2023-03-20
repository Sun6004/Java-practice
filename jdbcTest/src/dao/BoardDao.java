package dao;

import java.util.List;

import vo.BoardVO;

public interface BoardDao {

	/**
	 * 
	 * @param boardVo
	 * @return 1/0
	 */
	public int insert(BoardVO boardVo);
	
	/**
	 * 
	 * @param no
	 * @return 1/0
	 */
	public int delete(int no);
	
	/**
	 * 
	 * @param boardVo
	 * @return 1/0
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
