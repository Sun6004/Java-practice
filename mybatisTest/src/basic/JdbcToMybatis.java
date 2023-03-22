package basic;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
		
		Reader rd = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		int id = 0;
		
		try {
			rd = Resources.getResourceAsReader("mybatis/config/Config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
		} catch (Exception e) {
			System.out.println("myBatis초기화 실패");
			e.printStackTrace();
		}finally {
			if(rd != null) {
				try {
					rd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//select
		try {
			session = sqlSessionFactory.openSession();
			
			List<LprodVO> list = session.selectList("lprod.selectAll");
			id = list.size()+2;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		System.out.println(id);
		//insert
		System.out.println("상품등록");
		System.out.print("gu입력: ");
		String gu = sc.next();
		System.out.print("nm입력: ");
		String nm = sc.next();
		
		try {
			LprodVO vo = new LprodVO();
			vo.setLprod_id(id);
			vo.setLprod_gu(gu);
			vo.setLprod_nm(nm);
			
			int cnt = session.insert("lprod.insertLprod", vo);
			
			if(cnt > 0) {
				System.out.println("추가 성공");
			}else {
				System.out.println("추가 실패");
			}
			
		} finally {
			session.close();
			
		}
	}
}
