package myMember.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imgView.do")
public class imgView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 파라미터로 넘어온 파일번호를 구한다.
		String fileName = request.getParameter("filename");

		
		// 파일이 저장된 폴더 경로 지정하기
		String uploadPath = "d:/d_other/uploadFiles";

		// 저장될 폴더가 없으면 새로 만든다.
		java.io.File f = new java.io.File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}

		String imgPath = uploadPath + File.separator +fileName;
		File imgFile = new File(imgPath);

		if (imgFile.exists()) { // 이미지 파일이 있을 때..
			BufferedInputStream bin = null;
			
			BufferedOutputStream bout = null;

			try {
				// 출력용 스트림 객체 생성
				bout = new BufferedOutputStream(response.getOutputStream());
				bin = new BufferedInputStream(new FileInputStream(imgFile));

				byte[] temp = new byte[1024];
				int len = 0;

				while ((len = bin.read(temp)) > 0) {
					bout.write(temp, 0, len);

				}
				bout.flush();
			} catch (Exception e) {
				System.out.println("입출력오류: " + e.getMessage());
			} finally {
				if (bin != null) {
					bin.close();
				}
				if (bout != null) {
					bout.close();
				}
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
