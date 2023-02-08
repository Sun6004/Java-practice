package chapter28_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class JDBCPrograming {
	public static void main(String[] args) throws Exception {
//		Java DataBase Connectivity : 자바와 데이터베이스 연동
//		Database vendor : 자바와 DB를 연동시키는 드라이버같은 역할
//		0. 준비물 : DBMS(Oracle) driver 
//		(연결방법)
//		1. 드라이버 로딩(Reflection 기법 사용)
		new OracleDriver();
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. 접속 정보를 이용하여 DBMS에 접속(Connection)
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","LSI","java"); //"IP","sql id","sql pw"

		//3. 쿼리를 전송할 객체생성 (Statement:쿼리작성)생성
		Statement statement = connection.createStatement();

		//4. 쿼리를 실행 또는 전송
		String sql ="select mem_id, mem_name, mem_hp, mem_mail from member"; // " "안에 ;절대 금지


		//5. select: 쿼리 결과를 객체(ResultSet)로 전달받음, 
		ResultSet resultSet = statement.executeQuery(sql); 
		//select : executeQuery / insert,update,delete : exeCuteUpdate:
		//		  ㄴ insert, update, delete: 실행 완료된 카운트 결과 전송	
		while(resultSet.next()) { //resultSet.next();커서위치의 다음행의 데이터를 가져옴
			String memId = resultSet.getString("mem_id"); //가져올 행의 타입(컬럼명...) 
			String memName = resultSet.getString("mem_name");
			String memHp = resultSet.getString("mem_hp");
			String memMail = resultSet.getString("mem_mail");
			System.out.printf("%s\t%s\t%s\t%s\n", memId, memName, memHp, memMail);
		}

		//	6. 자원(Resource: Connection, Statement, ResultSet) 반납
		resultSet.close();
		statement.close();
		connection.close();
	}
}
