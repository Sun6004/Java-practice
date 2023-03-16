package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
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
	private static Scanner sc = new Scanner(System.in);

	private static Connection con = null;
	private static Statement st = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static String id;
	private static String pw;
	private static String name;
	private static String tel;
	private static String addr;
	private static int choice;

	public static void main(String[] args) {
		
		startMember();
	}
	// ----------------------------------------------------------
	
	// 실행
	// ----------------------------------------------------------------------------------------
	private static void startMember() {
		
		while(true) {
			menu();
			System.out.print("메뉴선택>>");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				insert();  //추가
				break;
			case 2:
				delete();  //삭제
				break;
			case 3:
				modify();  //수정
				break;
			case 4:
				serch();  //출력
				break;
			case 5:
				update();  //선택수정
				break;
			case 6:
				update2();  //원하는 항목을선택수정
				break;
		
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
				
			default:
				System.out.println("번호를 잘못입력했습니다. 다시 입력하세요.");
			}
		}		
	}
	// 메뉴
	// ----------------------------------------------------------------------------------------
	private static void menu() {
		System.out.println();
		System.out.println("-----------------------");
		System.out.println("회원 관리 프로그램");
		System.out.println("-----------------------");
		System.out.println("1. 자료추가");
		System.out.println("2. 자료삭제");
		System.out.println("3. 자료수정");
		System.out.println("4. 전체자료출력");
		System.out.println("5. 자료선택수정");
		System.out.println("0. 프로그램 종료");
		System.out.println("----------------------");
	}

	//원하는 항목 선택해서 수정
	// ----------------------------------------------------------------------------------------
	private static void update2() {
		int choiceNum;
		try {
			con = DBUtil.getConnection();
			st = con.createStatement();
			
			String sql = null;
			
			System.out.println("수정하고 싶은 항목을 선택하세요.");
			System.out.println("----------------------------------------------");
			System.out.println("1.비밀번호   2.이름   3.전화번호   4.주소");
			System.out.println("----------------------------------------------");
			System.out.print("선택>> ");
			choiceNum = sc.nextInt();
			
			//key:수정할 컬럼명 / value: 수정할 데이터값
			//수정할 데이터값이 있을때만 Map에 추가된다.
			Map<String, String> dataMap = new HashMap<>();
			String temp = ""; //SQL문의 set이후에 수정할 컬럼 설정하는 부분이 저장될 변수
			@SuppressWarnings("unused")
			int num = 0;
			
			for (String fieldName : dataMap.keySet()) {
				if(!"".equals(temp)) {
					temp +=", ";
				}
				temp += fieldName + "=" +dataMap.get(fieldName);
			}
			String sql2 = "update mymember set"+temp+"where mem_id=?";
			ps = con.prepareStatement(sql2);
			ps.setString(1, id);
			
			switch (choiceNum) {
			case 1:
				System.out.print("새로운 비밀번호>> ");
				String newPw = sc.nextLine().trim();
				if(!"".equals(newPw)) {
				dataMap.put("MEM_PASS",newPw);
				}
				sql = "";
				ps=con.prepareStatement(sql);
				break;
			case 2:
				System.out.print("새로운 이름>> ");
				String newNm = sc.nextLine().trim();
				if(!"".equals(newNm)) {
				dataMap.put("mem_name", newNm);
				}
				sql = "";
				ps=con.prepareStatement(sql);
				break;
			case 3:
				System.out.print("새로운 전화번호>> ");
				String newPh = sc.nextLine().trim();
				if(!"".equals(newPh)) {
				dataMap.put("mem_tel", newPh);
				}
				sql = "";
				ps=con.prepareStatement(sql);
				break;
			case 4:
				System.out.print("새로운 주소>> ");
				String newAdr = sc.nextLine().trim();
				if(!"".equals(newAdr)) {
				dataMap.put("mem_addr", newAdr);
				}
				sql = "";
				ps=con.prepareStatement(sql);
				break;

			default:
				System.out.println("잘못된 번호입니다 꺼지세요 ㅡㅡ");
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//자료선택수정
	// ----------------------------------------------------------------------------------------

	private static void update() {
			
			try {
			con = DBUtil.getConnection();
			st = con.createStatement();
			System.out.print("수정할 회원의 id를 입력하세요: ");
			String updateId = sc.next();
			int choice = 0;
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
				System.out.println("수정하고싶은 정보를 선택하세요");
				System.out.println("1. 비밀번호 변경");
				System.out.println("2. 전화번호 변경");
				System.out.println("3. 주소 변경");
				System.out.println("4. 이름 변경");
				choice = sc.nextInt();
				
				switch (choice) {
				case 1:
					System.out.print("수정할 비밀번호 입력: ");
					String updatePass = sc.next();
					
					String sql2 = "update MYMEMBER set MEM_PASS=? where MEM_ID=?";

                    ps = con.prepareStatement(sql2);
                    ps.setString(1, updatePass);
                    ps.setString(2, updateId);
                    ps.executeUpdate();
                    System.out.println("비밀번호가 수정되었습니다.");
					break;
				case 2:
					System.out.print("수정할 전화번호 입력: ");
					String updateTel = sc.next();
					
					String sql3 = "update MYMEMBER set MEM_TEL=? where MEM_ID=?";

                    ps = con.prepareStatement(sql3);
                    ps.setString(1, updateTel);
                    ps.setString(2, updateId);
                    ps.executeUpdate();
                    System.out.println("전화번호가 수정되었습니다.");
					break;
				case 3:
					System.out.print("수정할 주소 입력: ");
					String updateAddr = sc.next();
					
					 String sql4 = "update MYMEMBER set MEM_ADDR=? where MEM_ID=?";

	                    ps = con.prepareStatement(sql4);
	                    ps.setString(1, updateAddr);
	                    ps.setString(2, updateId);
	                    ps.executeUpdate();
					System.out.println("주소가 수정되었습니다.");
					break;
				
				case 4:
					System.out.print("수정할 이름 입력: ");
					String updateName = sc.next();
					
					String sql5 = "update MYMEMBER set MEM_NAME=? where MEM_ID=?";
					
					ps = con.prepareStatement(sql5);
					ps.setString(1, updateName);
					ps.setString(2, updateId);
					ps.executeUpdate();
					System.out.println("이름이 수정되었습니다.");
					break;
	
				default:
					System.out.println("잘못 선택하였습니다.");
					break;
					
				}
			
			}

		} catch (Exception e) {
			e.printStackTrace();
	}
	}

	// 자료추가
	// ----------------------------------------------------------------------------------------

	private static void insert() {
		
		try {
			int count = 0;

			System.out.println("추가할 회원정보를 입력하세요.");
			System.out.println("------------------------------");
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
				System.out.println(deleteId+ "회원은 존재하지 않습니다.");
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

//--------------------------------------------------------------------------------------------
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
		        int cnt = 0;

		        System.out.println("==========================================================");
		        System.out.println("======================  회원 정보 리스트  ====================");
		        System.out.println("==========================================================");
		        System.out.println(" ID     비밀번호   이름        전화번호         주소       ");
		        System.out.println("============================================================");
		        while(rs.next()) {
		        	cnt ++;
//		            System.out.println("아이디: " + rs.getString("MEM_ID"));
//		            System.out.println("비밀번호: " + rs.getString("MEM_PASS"));
//		            System.out.println("이름: " + rs.getString("MEM_NAME"));
//		            System.out.println("전화번호: " + rs.getString("MEM_TEL"));
//		            System.out.println("주소: " + rs.getString("MEM_ADDR"));
		            String id2 = rs.getString("MEM_ID");
		            String pw2 = rs.getString("MEM_PASS");
		            String name2 = rs.getString("MEM_NAME");
		            String tel2 = rs.getString("MEM_TEL");
		            String addr2 = rs.getString("MEM_ADDR");
		            
		            System.out.println(id2 + "\t" + pw2 + "\t" + name2 + "\t" + tel2 + "\t" +addr2);

		        }
		        if(cnt == 0) {
		        	System.out.println("등록된 회원정보가 없습니다.");
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
