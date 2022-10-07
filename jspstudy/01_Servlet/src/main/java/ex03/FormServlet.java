package ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		request.setCharacterEncoding("UTF-8");
		
		//변수
		String id = request.getParameter("id");
		if(id == null || id.isEmpty()) {//널인지 빈문자열인지 구분 안되면 해당 코드 사용하자.
			id = "빈 아이디";
		}		
		String pwd = request.getParameter("pwd");
		if(pwd.isEmpty()) {
			pwd = "빈 비밀번호";
		}
		String gender = request.getParameter("gender");
		if(gender == null) {
			gender = "체크안함";
		}
		String city = request.getParameter("city");
		if(city.isEmpty()) {
			city = "도시선택X";
		}
		String email_id = request.getParameter("email_id");
		String domain = request.getParameter("domain");
		
		//배열
		String[] phone = request.getParameterValues("phone");
		for(int i=0; i<phone.length; i++) {
			if(phone[i].isEmpty()) {
				phone[i] = "빈 전화" + (i+1);
			}
		}
		String strPhone = phone[0] + "-" + phone[1] + "-" + phone[2];
		
		String[] agree = request.getParameterValues("agree");
		if(agree == null) {
			agree = new String[1];
			agree[0] = "빈 동의";
		}
		
		
		
		//응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<h3>아이디 : " + id + "</h3>");
		out.println("<h3>비밀번호 : " + pwd + "</h3>");		
		out.println("<h3> 성별: " + gender + "</h3>");
		out.println("<h3> 거주지: " + city + "</h3>");
		out.println("<h3> 핸드폰: " + strPhone + "</h3>");		
		out.println("<h3> 이메일: " + email_id +"@"+ domain + "</h3>");		
		out.println("<h3>동의여부 : " + Arrays.toString(agree) + "</h3>");		
		List<String> list = Arrays.asList(agree);
		if(list.contains("marketing")) {
			out.println("<h3>마케팅 동의한 회원</h3>");
		}
		
			
		
		
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
