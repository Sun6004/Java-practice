package chapter26;

import java.util.*;

//DAO : Data Access Object+
public class BoardDao {

	public List<Board2> getBoardList() {
		List<Board2> list = new ArrayList<Board2>();
		list.add(new Board2("제목1", "내용1"));
		list.add(new Board2("제목2", "내용2"));
		list.add(new Board2("제목3", "내용3"));
		return list;
	}

}
