package myMember.service;

import java.util.List;

import myMember.dao.MyMemberDao;
import myMember.dao.MyMemberDaoImpl;
import myMember.vo.MyMemberVO;

public class MyMemberServiceImpl implements MyMemberService{

	
	private MyMemberDao dao;
	private static MyMemberServiceImpl service;
	
	private MyMemberServiceImpl() {
		dao = MyMemberDaoImpl.getInstance();
	}
	public static MyMemberServiceImpl getInstance() {
		if(service==null) service = new MyMemberServiceImpl();
		return service;
	}
	
	
	@Override
	public List<MyMemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return dao.getMemberList();
	}

	@Override
	public int insertMember(MyMemberVO vo) {
		// TODO Auto-generated method stub
		return dao.insertMember(vo);
	}

	@Override
	public MyMemberVO getMember(String memId) {
		// TODO Auto-generated method stub
		return dao.getMember(memId);
	}

	@Override
	public int updateMember(MyMemberVO vo) {
		// TODO Auto-generated method stub
		return dao.updateMember(vo);
	}

	@Override
	public int delMember(String memId) {
		// TODO Auto-generated method stub
		return dao.delMember(memId);
	}
	@Override
	public MyMemberVO getPhoto(int memId) {
		// TODO Auto-generated method stub
		return dao.getPhoto(memId);
	}
	
}
