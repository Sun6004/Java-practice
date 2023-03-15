package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

/*
 *  회원을 관리하는 프로그램을 작성하시오 (myMember테이블 이용)
 *  
 *  아래의 메뉴를 모두 구현하시오. (CRUD기능 구현)
 *  메뉴 예시)
 *  1. 자료추가
 *  2. 자료삭제
 *  3. 자료수정
 *  4. 전체자료 출력
 *  0. 끝
 *  
 *  조건)
 *  회원ID 중복 X
 *  자료삭제는 회원ID를 입력받아서 처리
 *  자료 수정에서 회원ID는 변경불가
 */
public class JdbcTest06 {
	static Scanner sc = new Scanner(System.in);

	static Connection con = null;
	static Statement st = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static String id;
	static String pw;
	static String name;
	static String tel;
	static String addr;

	public static void main(String[] args) {

		System.out.println("회원 관리 프로그램");
		System.out.println("1. 자료추가");
		System.out.println("2. 자료삭제");
		System.out.println("3. 자료수정");
		System.out.println("4. 전체자료출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("----------------------");
		System.out.print("메뉴선택>>");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			insert();
			break;
		case 2:
			delete();
			break;
		case 3:
			modify();
			break;
		case 4:
			serch();
			break;
		case 0:
			System.exit(0);
			break;

		default:
			break;
		}

	}


	// 자료추가
	private static void insert() {
		try {
			int count = 0;

			con = DBUtil.getConnection();
			st = con.createStatement();
			System.out.print("id입력>> ");
			id = sc.next();
			System.out.print("pw입력>> ");
			pw = sc.next();
			System.out.print("이름입력>> ");
			name = sc.next();
			System.out.print("tel입력>> ");
			tel = sc.next();
			System.out.print("주소입력>> ");
			addr = sc.next();

			// id중복검사
			String sql2 = "select count(*) from MYMEMBER where MEM_ID='" + id + "'";
			rs = st.executeQuery(sql2);

			if (rs.next()) {
				count = rs.getInt(1);
			}

			if (count == 0) {
				String sql = "insert into MYMEMBER(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR) " + "values ('" + id
						+ "','" + pw + "','" + name + "','" + tel + "','" + addr + "')";
				st = con.createStatement();
				int cnt = st.executeUpdate(sql);

				if (cnt > 0) {
					System.out.println("자료 추가 성공!");
				} else {
					System.out.println("자료 추가 실패!");
					System.out.println("중복된 id입니다.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally { //자원반납.
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(st!=null)try {st.close();}catch(SQLException e) {}
			if(con!=null)try {con.close();}catch(SQLException e) {}
		}

	}

	// ----------------------------------------------------------------------------------------
	// 자료삭제
	private static void delete() {
		try {
			con = DBUtil.getConnection();
			st = con.createStatement();

			System.out.print("삭제할 회원의 id를 입력하세요: ");
			String deleteId = sc.next();

			// id 중복 검사
			String sql = "select count(*) from MYMEMBER where MEM_ID='" + deleteId + "'";
			rs = st.executeQuery(sql);

			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}

			if (count == 0) {
				System.out.println("해당 id의 회원이 존재하지 않습니다.");
			} else {
				sql = "delete from MYMEMBER where MEM_ID='" + deleteId + "'";
				st = con.createStatement();
				int cnt = st.executeUpdate(sql);

				if (cnt > 0) {
					System.out.println("자료 삭제 성공!");
				} else {
					System.out.println("자료 삭제 실패!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //자원반납.
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(st!=null)try {st.close();}catch(SQLException e) {}
			if(con!=null)try {con.close();}catch(SQLException e) {}
		}

	}

//----------------------------------------------------------------------------------------
	// 자료수정
	private static void modify() {
		try {
			con = DBUtil.getConnection();
			st = con.createStatement();
			System.out.print("수정할 회원의 id를 입력하세요: ");
			String updateId = sc.next();

			// id 중복 검사
			String sql = "select count(*) from MYMEMBER where MEM_ID='" + updateId + "'";
			rs = st.executeQuery(sql);

			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}

			if (count == 0) {
				System.out.println("해당 id의 회원이 존재하지 않습니다.");
			} else {
				sql = "select * from MYMEMBER where MEM_ID='" + updateId + "'";
				rs = st.executeQuery(sql);

				if (rs.next()) {
					System.out.println("회원 ID: " + rs.getString("MEM_ID"));
					System.out.println("회원 비밀번호: " + rs.getString("MEM_PASS"));
					System.out.println("회원 이름: " + rs.getString("MEM_NAME"));
					System.out.println("회원 전화번호: " + rs.getString("MEM_TEL"));
					System.out.println("회원 주소: " + rs.getString("MEM_ADDR"));
					System.out.println("-------------------------------");

					System.out.println("수정할 회원 정보를 입력하세요.");
					System.out.print("비밀번호: ");
					String updatePass = sc.next();
					System.out.print("이름: ");
					String updateName = sc.next();
					System.out.print("전화번호: ");
					String updateTel = sc.next();
					System.out.print("주소: ");
					String updateAddr = sc.next();

					sql = "update MYMEMBER set MEM_PASS=?, MEM_NAME=?, MEM_TEL=?, MEM_ADDR=? where MEM_ID=?";
					ps = con.prepareStatement(sql);
					ps.setString(1, updatePass);
					ps.setString(2, updateName);
					ps.setString(3, updateTel);
					ps.setString(4, updateAddr);
					ps.setString(5, updateId);

					int cnt = ps.executeUpdate();

					if (cnt > 0) {
						System.out.println("자료 수정 성공!");
					} else {
						System.out.println("자료 수정 실패!");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //자원반납.
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(st!=null)try {st.close();}catch(SQLException e) {}
			if(con!=null)try {con.close();}catch(SQLException e) {}
		}
	}
	
	//----------------------------------------------------------------------------------------
	// 전체자료 출력
	private static void serch() {
		 try {
		        con = DBUtil.getConnection();
		        String sql = "select * from MYMEMBER";
		        st = con.createStatement();
		        rs = st.executeQuery(sql);

		        System.out.println("======================================");
		        System.out.println("회원 정보 리스트");
		        System.out.println("======================================");
		        while(rs.next()) {
		            System.out.println("아이디: " + rs.getString("MEM_ID"));
		            System.out.println("비밀번호: " + rs.getString("MEM_PASS"));
		            System.out.println("이름: " + rs.getString("MEM_NAME"));
		            System.out.println("전화번호: " + rs.getString("MEM_TEL"));
		            System.out.println("주소: " + rs.getString("MEM_ADDR"));
		            System.out.println("--------------------------------------");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }finally { //자원반납.
				if(rs!=null)try {rs.close();}catch(SQLException e) {}
				if(st!=null)try {st.close();}catch(SQLException e) {}
				if(con!=null)try {con.close();}catch(SQLException e) {}
			}
		
	}
	
}
