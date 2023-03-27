package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  @Webwervlet 에너테이션의 속성들
 *  1. name: 서블릿 이름을 설정(기본값: 빈 문자열 "")
 *  2. urlPattens: 서블릿의 URL패턴의 목록을 설정한다. (기본값: 빈 배열({ }))
 *  			 	예) urlPatterns="/url1" 또는 urlPatterns={"/url1"} ==> 패턴이 1개일 때
 *  				예) urlPatterns={"/url1", "/url2",...} ==> 패턴이 2개 이상일 때
 *  3. value: urlPatterns와 동일한 기능을 한다.
 *  4. description: 주석(설명글)을 설정한다.
 */
@WebServlet(description="에너테이션을 이용한 서블릿 설정 연습", urlPatterns = {"/servletTest02.do"})
public class ServletTest02 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		//처리한 내용출력하기 
		//방법 2ㅣ print()이용하기
		out.println("<html><head><meta charset='utf-8'><title> 첫번째 servlet연습</title></head><body>");
		out.println("<h1 style='text-align:center;'>ㅎㅇㅎㅇ 2번째 서블릿임~<br> 에너테이션을 이용하여 서블릿을 등록하는 예제임.");
		out.println("</h1></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
