package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MybatisSqlsessionFactory;
import vo.FileinfoVO;

public class FileinfoDaoImpe implements IFileInfoDao {
	
	private static FileinfoDaoImpe dao;
	private FileinfoDaoImpe() {}
	public static FileinfoDaoImpe getInstance() {
		if(dao==null) dao = new FileinfoDaoImpe();
		return dao;
	}
	
	@Override
	public int insertFileinfo(FileinfoVO vo) {
		SqlSession session = null;
		int cnt = 0; //반환값 저장
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			cnt = session.insert("fileinfo.insertFileinfo", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public List<FileinfoVO> getAllFileinfo() {
		SqlSession session = null;
		List<FileinfoVO> list = null;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			list = session.selectList("fileinfo.getAllFileinfo");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public FileinfoVO getFileinfo(int fileNo) {
		SqlSession session = null;
		FileinfoVO vo = null;
		
		try {
			session = MybatisSqlsessionFactory.getSqlSession();
			vo = session.selectOne("fileinfo.getFileinfo", fileNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session != null) session.close();
		}
		return vo;
	}
	
}
