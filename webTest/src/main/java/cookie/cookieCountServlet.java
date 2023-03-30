package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountServlet.do")
public class cookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int count = 0; //현재 count값이 저장될 변수
		
		// 쿠키이름을 count로 함 ==> 현재 이 쿠키가 있는지 검사
		Cookie[] cookieArr = request.getCookies();
		if(cookieArr != null) {
			for (Cookie c : cookieArr) {
				if("count".equals(c.getName())) { // count라는 쿠키가 있는지 검사
					String value = c.getValue(); // 현재의 쿠키값 가져오기
					count = Integer.parseInt(value);
				}
			}
		}
		
		count++;
		
		//증가된 count값을 쿠키값으로 갖는 쿠키 생성
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		
		// 생성된 쿠키정보 저장하기
		response.addCookie(countCookie);
		
		out.println("<html><head><meta charset='utf-8'><title>쿠키 count 연습</title></head>");
		out.println("<body>");
		
		out.println("<h2>어서오세요. 당신은"+count+"번째 방문자 입니다.</h2><br><br>");
		
		out.println("<a href='"+ request.getContextPath() +"/cookieCountServlet.do'>카운트 증가하기</a>");
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		
		out.println("</body> </html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
