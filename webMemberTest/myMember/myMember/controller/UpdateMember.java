package myMember.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import myMember.service.MyMemberServiceImpl;
import myMember.vo.MyMemberVO;

@WebServlet("/updateMember.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024
		* 100)

public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String id = request.getParameter("memId");
		String pass = request.getParameter("memPass");
		String name = request.getParameter("memName");
		String tel = request.getParameter("memTel");
		String addr = request.getParameter("memAddr");

		MyMemberVO vo = new MyMemberVO();

		vo.setMem_id(id);
		vo.setMem_pass(pass);
		vo.setMem_name(name);
		vo.setMem_tel(tel);
		vo.setMem_addr(addr);

		String uploadPath = "d:/d_other/uploadFiles";

		File f = new File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}

		Part part = request.getPart("mem_photo");

		String fileName = "";
		String headerValue = part.getHeader("content-disposition");

		String[] items = headerValue.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}

		vo.setMem_photo(fileName);

		part.write(uploadPath + File.separator + fileName);

		MyMemberServiceImpl.getInstance().updateMember(vo);

		response.sendRedirect(request.getContextPath() + "/memList.jsp");
	}

}
