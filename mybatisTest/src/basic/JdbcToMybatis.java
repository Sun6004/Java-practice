package basic;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import util.MybatisSqlsessionFactory;

/*
 * LPROD 테이블에 새로운 데이터 추가하기
 * lprod_gu, lprod_nm은 직접 입력받아서 처리하고,
 * lprod_id는 현재의 lprod_id중에서 제일 큰 값보다 1 크게 한다.
 * 
 * 입력받은 lprod_qu가 이미 등록되어 있으면 다시 입력받아서 처리한다.
 * 
 * => JDBC예제 중 jdbcTest05.java를 myBatis용으로 변경하시오..
 * => mapper파일명은 jdbc-mapper.xml로 한다.
 */
public class JdbcToMybatis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		Reader rd = null;
//		SqlSessionFactory sqlSessionFactory = null;
//		SqlSession session = null;
//		int id = 0;
//		
//		try {
//			rd = Resources.getResourceAsReader("mybatis/config/Config.xml");
//			
//			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
//		} catch (Exception e) {
//			System.out.println("myBatis초기화 실패");
//			e.printStackTrace();
//		}finally {
//			if(rd != null) {
//				try {
//					rd.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
			
		// -----------------------------------------------------------------
		//
		SqlSession session = null;
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			
			//데이터 중 제일 큰값+1 구하기
			int nextId = session.selectOne("jdbc.nextId");
			
			// LPROD_GU값을 입력 받고 중복되면 다시 입력받기
			String gu;
			int count = 0;
			do {
				System.out.print("상품 분류코드(gu) 입력: ");
				gu = sc.next();
				
				count = session.selectOne("jdbc.lprodCount", gu);
				
				if(count > 0) {
					System.out.println("입력한 상품코드 "+gu+" 는 이미 존재합니다");
					System.out.println("다시 입력하세요");
					System.out.println();
				}
			} while(count > 0);
			
			System.out.print("상품 분류명(nm) 입력: ");
			String nm = sc.next();
			
			//입력값들을 Vo에 저장하기
			LprodVO vo = new LprodVO();
			vo.setLprod_id(nextId);
			vo.setLprod_gu(gu);
			vo.setLprod_nm(nm);
			
			int cnt = session.insert("jdbc.insertLprod", vo);
			
			if(cnt > 0) {
				System.out.println("등록성공");
			}else {
				System.out.println("등록실패");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
	}
}
