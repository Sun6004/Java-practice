package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountdel.do")
public class cookieCountdel extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cArr = request.getCookies();
		
		// 이름이 count인 쿠키 찾기
		if(cArr != null) {
			for (Cookie c : cArr) {
				 if("count".equals(c.getName())) {
					 // count 라는 쿠키를 찾아서 유지 시간을 0으로 한 후에 다시 저장한다.(삭제작업)
					 c.setMaxAge(0);
					 response.addCookie(c); 
				 }
			}
		}
		out.println("<html><head><meta charset='utf-8'><title>쿠키 count 연습</title></head>");
		out.println("<body>");
		
		out.println("<h2> 카운트가 초기화 되었습니다. </h2><br><br>");
		
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		
		out.println("</body> </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
