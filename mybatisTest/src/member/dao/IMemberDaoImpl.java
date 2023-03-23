package member.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.vo.MemberVO;
import util.MybatisSqlsessionFactory;

public class IMemberDaoImpl implements IMemberDao{
	
	private static IMemberDaoImpl dao;
	
	private IMemberDaoImpl() { }
		
	public static IMemberDaoImpl getInstance() {
		if(dao==null) dao = new IMemberDaoImpl();
		return dao;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		SqlSession session = null;
		session = MybatisSqlsessionFactory.getSqlSession();
		//int cnt = 0;
		int insertcnt = 0;
		try {
//			int count = 0;
//			count = session.selectOne("myMember.getMemberCount", memVo.getMem_id());
//			MemberVO vo = new MemberVO();
//			vo.setMem_id(vo.getMem_id());
//			vo.setMem_pass(vo.getMem_pass());
//			vo.setMem_name(vo.getMem_name());
//			vo.setMem_tel(vo.getMem_tel());
//			vo.setMem_addr(vo.getMem_addr());
			
			insertcnt = session.insert("member.insertMember", memVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			session.commit();
			session.close();
		}
		return insertcnt;		
	}

	@Override
	public int deleteMember(String memId) {
		SqlSession session = null;
		session = MybatisSqlsessionFactory.getSqlSession();
		int delcnt = 0;
		try {
			delcnt = session.delete("member.deleteMember", memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return delcnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		SqlSession session = null;
		session = MybatisSqlsessionFactory.getSqlSession();
		int upcnt = 0;
		try {
			upcnt = session.update("member.updateMember", memVo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return upcnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		SqlSession session = null;
		List<MemberVO> memList = null;
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			memList = session.selectList("member.getAllMember");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.commit();
			session.close();
		}
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		SqlSession session = null;
		session = MybatisSqlsessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.update("member.getMemberCount", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember3(Map<String, String> dataMap) {
		SqlSession session = null;
		session = MybatisSqlsessionFactory.getSqlSession();
		int count = 0;
		try {
			count = session.update("member.updateMember3", dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return count;
	}

}
