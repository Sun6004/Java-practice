package Projsct1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class TestUnit {

	MemoDAO dao = MemoDAO.getInstance();
	@Test
	void selectMemo() {
		
		MemoVO memo = dao.selectMemo(0);
		assertNull(memo);
	}
	@Test
	void insertMemo() {
		try {
			int insertMemo = dao.insertMemo(new MemoVO("7번째 시간", "이제 2시간남음","a001"));
			assertEquals(1, insertMemo);
			List<MemoVO> list = dao.selectMemos("");
			assertEquals(14, list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
