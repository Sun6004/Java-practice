package memoProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.logging.annotations.StringBlinder;

public class memoDAO {
	private static memoDAO instance = new memoDAO();
	private memoDAO() {
		
	}
	public static memoDAO getInstance() {
		return instance;
	}
	public List<memoVO> selectMemos() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "PRACTICE";
		String pw = "java";
		Connection connection = DriverManager.getConnection(url,user,pw);
		//객체생성
		Statement statement = connection.createStatement();
		//StringBuilder: 문자열을 더할때 사용
		StringBuilder builder = new StringBuilder();
	builder.append(" SELECT ");
	builder.append(" 	M_NO, ");
	builder.append("    TITLE, ");
	builder.append("    CONTENT ");
	builder.append(" FROM ");
	builder.append(" 	MEMO");
	String sql = builder.toString();
	ResultSet resultSet = statement.executeQuery(sql);
	List<memoVO> list = new ArrayList<>();
	while (resultSet.next()) {
		int mNo = resultSet.getInt("M_NO");
		String mTitle = resultSet.getString("TITLE");
		String mContent = resultSet.getString("CONTENT");
		list.add(new memoVO(mTitle, mContent));
		
	}
		resultSet.close();	     
		statement.close();
		return list;		            
	}
	public memoVO selectMemo(int searchNo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "PRACTICE";
		String pw = "java";
		Connection connection = DriverManager.getConnection(url,user,pw);
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT ");
		builder.append(" 	M_NO, ");
		builder.append("    TITLE, ");
		builder.append("    CONTENT ");
		builder.append(" FROM ");
		builder.append(" 	MEMO");
		String sql = builder.toString();
		//statement: sql문을 전달하는 역할
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, searchNo);
		//execute: return값이 resultSet이면 true
		//executeQuery: ResultSet 객체에 결과값을 담음
		ResultSet resultSet = statement.executeQuery();
		memoVO memo = null;
		if(resultSet.next()) {
			String mNo = resultSet.getString("M_NO");
			String mTitle = resultSet.getString("TITLE");
			String mContent = resultSet.getString("CONTENT");
			memo = new memoVO(mNo, mTitle, mContent);
		}
		resultSet.close();
		statement.close();
		connection.close();	
		return memo;	
	}
	public int insertMemo(memoVO vo) throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PRACTICE";
		String pw = "java";
		Connection connection = DriverManager.getConnection(url,user,pw);
		StringBuilder builder = new StringBuilder();
		builder.append(" insert into");
		builder.append(" 	MEMO");
		builder.append(" 	( ");
		builder.append(" 		M_NO,");
		builder.append(" 		TITLE,");
		builder.append(" 		CONTENT");
		builder.append(" 	) ");
		builder.append(" VALUES ");
		builder.append(" 	( ");
		builder.append(" 		?,");
		builder.append(" 		?,");
		builder.append(" 		? ");
		builder.append(" 	)");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, vo.getNo());
		statement.setString(2, vo.getTitle());
		statement.setString(3, vo.getContent());
		//executeUpdate: 수행결과로 Int 타입의 값을 반환, SELECT 구문을 제외한 다른 구문을 수행할 때 사용
		int count = statement.executeUpdate();
		statement.close();
		connection.close();
		return count;
	}
	public int deleteMemo(int deleteNo) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "PRACTICE";
		String pw = "java";
		Connection connection = DriverManager.getConnection(url,user,pw);
		StringBuilder builder = new StringBuilder();
		builder.append("delete from ");
		builder.append("	memo ");
		builder.append("where ");
		builder.append("	no = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, deleteNo);
		
		int count = statement.executeUpdate();
		statement.close();
		connection.close();
		return count;
	}
	public int updateMemo(memoVO vo) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "PRACTICE";
		String pw = "java";
		Connection connection = DriverManager.getConnection(url,user,pw);
		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE ");
		builder.append(" 	memo ");
		builder.append("SET ");
		builder.append("	title = ? ");
		builder.append(" 	content = ? ");
		builder.append(" 	writer = ? ");
		builder.append(" WHERE ");
		builder.append(" 	no = ?");
		
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getTitle());
		statement.setString(2, vo.getContent());
		statement.setString(3, vo.getWriter());
		statement.setString(4, vo.getNo());
		
		int count = statement.executeUpdate();
		statement.close();
		connection.close();
		return count;
	}
}

