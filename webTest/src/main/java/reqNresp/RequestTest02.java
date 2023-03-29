package reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	
		String n1 = request.getParameter("num1");
		String n2 = request.getParameter("num2");
		String calc = request.getParameter("calc");
		
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		try {
			
		double result = 0; //계산 결과가 저장될 변수
		boolean r = true;
		
		switch (calc) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;	
			break;
		case "*":
			if (num2 == 0) {
				r = false;
				break;
			}else {
			result = (double) num1 / num2;	
			break;
			}
		case "/":
			result = num1 / num2;		
			break;
		case "%":
			result = num1 % num2;			
			break;

		default:
			break;
		}		
		
		PrintWriter out = response.getWriter();	
		if(r == true) {
		out.println("<html><head><meta charset='utf-8'> <title>Request객체 연습2</title> </head>");
		out.println("<body>");
		out.println("<h2>계산결과</h2><hr>");
		out.println(num1 + calc + num2 + "=" + result);
		out.println("</body></html>");
		}else {
			out.println("<html><head><meta charset='utf-8'> <title>Request객체 연습2</title> </head>");
			out.println("<body>");
			out.println("<h2>계산결과</h2><hr>");
			out.println("<p>계산실패</p>");
			out.println("</body></html>");	
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
