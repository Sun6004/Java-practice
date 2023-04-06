package myMember.service;

import java.util.List;

import myMember.vo.MyMemberVO;

public interface MyMemberService {
public List<MyMemberVO> getMemberList();
	
	public int insertMember(MyMemberVO vo);
	
	public MyMemberVO getMember(String memId);
	
	public int updateMember(MyMemberVO vo);
	
	public int delMember(String memId);
	
	public MyMemberVO getPhoto(int memId);
}
