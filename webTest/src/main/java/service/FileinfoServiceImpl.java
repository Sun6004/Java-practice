package service;

import java.util.List;

import dao.FileinfoDaoImpe;
import dao.IFileInfoDao;
import vo.FileinfoVO;

public class FileinfoServiceImpl implements IFileinfoService{
	private IFileInfoDao dao;
	private static FileinfoServiceImpl service;
	
	private FileinfoServiceImpl() {
		dao = FileinfoDaoImpe.getInstance();
	}
	public static FileinfoServiceImpl getInstance() {
		if(service==null) service = new FileinfoServiceImpl();
		return service;
	}
	@Override
	public int insertFileinfo(FileinfoVO vo) {
		// TODO Auto-generated method stub
		return dao.insertFileinfo(vo);
	}

	@Override
	public List<FileinfoVO> getAllFileinfo() {
		// TODO Auto-generated method stub
		return dao.getAllFileinfo();
	}

	@Override
	public FileinfoVO getFileinfo(int fileNo) {
		// TODO Auto-generated method stub
		return dao.getFileinfo(fileNo);
	}
	

}
