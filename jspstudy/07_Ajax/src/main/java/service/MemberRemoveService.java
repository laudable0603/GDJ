package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import repository.MemberDao;

public class MemberRemoveService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			//요청 파라미터
			Optional<String> opt = Optional.ofNullable(request.getParameter("memberNo"));
			int memberNo = Integer.parseInt(opt.orElse("0"));
			
			// 삭제
			int result = MemberDao.getInstance().deleteMember(memberNo);
			
				
				
	
				// 삭제할 데이터 타입 (JSON)
				response.setContentType("application/json");
				
				//응답데이터
				/*
				  성공 응답
				  {"isSuccess":true}
				  실패 응답
				  {"isSuccess":false}
				 
				 */
				JSONObject obj = new JSONObject();
				obj.put("isSuccess", result > 0);
				
				PrintWriter out = response.getWriter();
				out.println(obj.toString());
				out.close();
		} catch (Exception e) {
			response.setContentType("text/plain; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("잘못된 정보가 전달 되었습니다.");
			out.close();
		}
		

	}

}
