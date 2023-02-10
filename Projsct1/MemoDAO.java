package Projsct1;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO : Data Access Object, 데이터베이스에 접근해서 데이터 처리 담당
public class MemoDAO {
	// 전체 목록 조회/ 상세 메모 조회/ 메모등록,수정,삭제
	private static MemoDAO instance = new MemoDAO();

	public MemoDAO() {
	}

	public static MemoDAO getInstance() {
		return instance;
	}

	public List<MemoVO> selectMemos(String searchWord) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String pw = "java";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "LSI";

		// DriverManager에 DB드라이버를 등록하는 메소드를 사용할 수도 있음
		// DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url, user, pw);
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("	no, ");
		builder.append("	title, ");
		builder.append(" 	content,");
		builder.append(" 	mem_name writer,");
		builder.append(" 	register_date,");
		builder.append(" 	modify_date ");
		builder.append("FROM ");
		builder.append("	MEMO");
		builder.append("	INNER JOIN MEMBER ON MEMO.WRITER = MEMBER.MEM_ID");
		String sql = builder.toString();
		ResultSet resultSet = statement.executeQuery(sql);
		List<MemoVO> list = new ArrayList<>();
		while (resultSet.next()) {
			int no = resultSet.getInt("no");
			String title = resultSet.getString("title");
			String content = resultSet.getString("content");
			String writer = resultSet.getString("writer");
			Timestamp registerDate = resultSet.getTimestamp("register_date");
			Timestamp modifyDate = resultSet.getTimestamp("modify_date");
			list.add(new MemoVO(no, title, content, writer, registerDate, modifyDate));

		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;

	}

	public MemoVO selectMemo(int searchNo) {
		return null;
	}

	public int insertMemo(MemoVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String pw = "java";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "LSI";
		Connection connection = DriverManager.getConnection(url, user, pw);
		StringBuilder builder = new StringBuilder();
		builder.append("insert into memo(");
		builder.append("	no,");
		builder.append("	title,");
		builder.append("	content,");
		builder.append("	writer");
		builder.append(")values (");
		builder.append("	seq_memo.nextval,");
		builder.append("	?,");
		builder.append("	?,");
		builder.append("	?");
		builder.append(")");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getTitle());
		statement.setString(2, vo.getContent());
		statement.setString(3, vo.getWriter());
		int count = statement.executeUpdate();

		statement.close();
		connection.close();
		return count;

	}

	public int updateMemo(MemoVO vo) {
		return 0;
	}

	public int deleteMemo(int deleteNo) {
		return 0;
	}

}
