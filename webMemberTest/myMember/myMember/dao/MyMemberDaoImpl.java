package myMember.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myMember.vo.MyMemberVO;
import util.MybatisSqlsessionFactory;

public class MyMemberDaoImpl implements MyMemberDao{
	
	private static MyMemberDaoImpl dao;
	
	private MyMemberDaoImpl() {
		
	}
	
	public static MyMemberDaoImpl getInstance() {
		if(dao == null)dao = new MyMemberDaoImpl();
		return dao;
	}

	@Override
	public List<MyMemberVO> getMemberList() {
		SqlSession session = null;
		List<MyMemberVO> list = null;
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			list = session.selectList("myMember.getMemberList");
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public int insertMember(MyMemberVO vo) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			res = session.insert("myMember.insertMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.commit();
			if(session != null) session.close();
		}
		return res;
	}
	

	@Override
	public MyMemberVO getMember(String memId) {
		SqlSession session = null;
		MyMemberVO vo = null;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			vo = session.selectOne("myMember.getMember", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session != null) session.close();
		}
		return vo;
	}

	@Override
	public int updateMember(MyMemberVO vo) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			res = session.update("myMember.updateMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session != null) session.close();
		}
		return res;
	}

	@Override
	public int delMember(String memId) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			res = session.delete("myMember.delMember", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session != null) session.close();
		}
		return res;
	}

	@Override
	public MyMemberVO getPhoto(int memId) {
		SqlSession session = null;
		MyMemberVO vo = null;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			vo = session.selectOne("myMember.getPhoto", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session != null) session.close();
		}
		return vo;
	}
	
}
