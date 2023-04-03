package json;

import java.util.List;

public interface LprodDao {
	/**
	 * Lprod 테이블의 전체 데이터를 list에 담아서 반환
	 * @return lprodVO가 저장된 list
	 */
	public List<LprodVO> getLprodList();
	
}
