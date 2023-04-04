package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FileinfoServiceImpl;
import service.IFileinfoService;
import vo.FileinfoVO;


@WebServlet("/fileDownload.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//파라미터로 넘어온 파일번호(fileno)를 구한다.
		String strFileno = request.getParameter("fileno");
		int fileNo = Integer.parseInt(strFileno);
		
		// 파일번호를 이용하여 DB에서 해당 파일의 정보를 가져옴
		IFileinfoService service = FileinfoServiceImpl.getInstance();
		
		FileinfoVO vo = service.getFileinfo(fileNo);
		// 업로드된 파일이 저장될 폴더 설정 
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 업로드된 파일들이 저장된 폴더 설정
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		//다운받을 파일의 정보를 갖는 file객체 생성 ==>실제 저장된 파일명 지정
		File downFile = new File(f, vo.getSAVE_FILE_NAME());
		
		if(downFile.exists()) { // 파일이 있을 때 작업
			// contentType설정
//			response.setContentType("text/html; charset=utf-8"); //html로 보낼때
//			response.setContentType("application/json; charset=utf-8"); //json으로 보낼때
			response.setContentType("application/octet-stream; charset=utf-8"); //file전송
			
			//Response객체에 'content-fisposition'헤더 속성을 추가한다.
			String headerKey = "content-disposition";
			
			// 위 헤더속성의 value값에는 클라이언트가 다운 받아서 저장할 파일명을 지정한다.
			// ==> 업로드할 때의 원본 파일명을 지정해 준다.
			//String headerValue = "attachment; filename=\""+vo.getORIGIN_FILE_NAME()+"\"";
			String headerValue = "attachment; " + getEncodedFileName(request, vo.getORIGIN_FILE_NAME());
		
			
			response.setHeader(headerKey, headerValue);
			
			// 서버쪽의 파일을 읽어서 클라이언트로 전송한다.
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				// 출력용 스트림 객체 생성 ==> respone객체 이용
				bout = new BufferedOutputStream(response.getOutputStream());
				
				//파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(downFile));
				
				byte[] temp = new byte[1024];
				int len = 0;
				while((len = bin.read(temp))>0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
			} catch (Exception e) {
				System.out.println("입출력오류: " +e.getMessage());
			}finally {
				if(bout !=null)try {
					bout.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(bin!=null)try {
					bin.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
		}
		}else { //파일이 없을 떄
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>"+vo.getORIGIN_FILE_NAME()+"파일이 존재하지 않음.</h3>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// 다운로드 파일명에 한글이 포함되었을 때 한글이 깨지는 것을 방지하는 메서드
	private String getEncodedFileName(HttpServletRequest request, String filename) {
		String encodedFilename = "";
		String userAgent = request.getHeader("user-agent");
		
		try {
			
			if(userAgent.contains("MSIE") || userAgent.contains("Trident")) { // MSIE 10 버전 이하의 웹브라우저 찾기
				encodedFilename = "filename=\"" + URLEncoder.encode(filename, "utf-8").replaceAll("\\+", "\\ ")+"\"";
			}else {
				encodedFilename = "filename*=UTF-8''"+URLEncoder.encode(filename,"utf-8").replaceAll("\\+", "%20");
			}
		} catch (Exception e) {
			throw new RuntimeException("지원하지 않는 웹브라우저입니다..");
		}
		
		return encodedFilename;
	}

}
