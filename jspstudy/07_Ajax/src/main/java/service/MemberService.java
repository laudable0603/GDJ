package service;import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//actionForword를 반환하지 않는다. void 반환 ajax방식은 페이지 이동이 없기때문이다.
}
