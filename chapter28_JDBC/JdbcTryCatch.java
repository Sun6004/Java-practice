package chapter28_JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTryCatch {
	public static void main(String[] args) {
		
		//finally 문에서 close를 사용하기 위해서 ctrl +1 로 만들어서 밖으로 빼줌
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "LSI";
			String password = "java";

			connection = DriverManager.getConnection(url,user,password);
			
		
			statement = connection.createStatement();
		
			//문자열 결합보다는 StringBuilder나 StringBuffer를 사용하는게 성능면에서 좋음
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT ");
			builder.append("    mem_id, ");
			builder.append("    mem_name, ");
			builder.append("    mem_bir, ");
			builder.append("    mem_add1, ");
			builder.append("    mem_add2, ");
			builder.append("    mem_job ");
			builder.append("FROM ");
			builder.append("    member ");
			String sql = builder.toString();
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				String memId = resultSet.getString("mem_id");
				String memName = resultSet.getString("mem_name");
				Date memBir = resultSet.getDate("mem_bir");
				String memAdd1 = resultSet.getString("mem_add1");
				String memAdd2 = resultSet.getString("mem_add2");
				String memJob = resultSet.getString("mem_job");
				System.out.printf("%s\t%s\t%s\t%s\t\t%s\t%s\n", memId,memName,
								  memBir.toLocalDate().toString(),
								  memAdd1,memAdd2,memJob);	
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//자원반납은 반드시 해줘야하기때문에 finally문에 close기술
			try {
				if(resultSet != null) {
				resultSet.close();
				}
			} catch (SQLException e2) {
			}
			try {
				if(statement != null) {
				statement.close();
				}
			} catch (SQLException e1) {
			}
			try {if(connection != null) {
				connection.close();
			}
			} catch (SQLException e) {
			}
		}
	}
}
