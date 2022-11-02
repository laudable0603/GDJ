package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.Notice;
import repository.NoticeDao;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public ActionForward findAllNotices(HttpServletRequest request) {
		
		// 페이징 처리의 기본은 목록을 가져오는 것
		// 파라미터 page 확인 
		// 파라미터 page가 없으면 page=1로 처리
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));//0이 아님을 주의
		
		// 전체 목록 갯수 구하기
		NoticeDao dao = NoticeDao.getInstance();
		int totalRecordCnt = dao.selectAllNoticesCnt();
		
		
		// 한 페이지에 표시할 목록의 개수(목록 하나: record)
		int recordPerPage = 10;
		
		// 특정 page에 표시할 목록의 시작번호와 끝 번호
		//				begin		end
		// page = 1: 	  1			 10
		//        2:      11         20
		//       ...      .. .      ...
		//        4:      31         35( 전체 목록이 35인 경우)
		// 여기서 begin과 end는 ROWNUM을 의미한다.* 따라서 역순 정렬한뒤 삭제시 문제없게 한다..?
		int begin = (page - 1) * recordPerPage + 1; 
		//page=1 : 0 * 10 + 1 = 1page
		//page=2 : 1 * 10 + 1 = 2page
		
		int end = begin + recordPerPage - 1;
		
		if(end > totalRecordCnt) {
			end = totalRecordCnt;
		}
		
		// begin + end를 Map으로 만들어서 NoticeDao에게 전달해야함
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", end);
		
		// begin에서 end사이 목록 가져오기
		List<Notice> notices = dao.selectAllNotices(map);
		
		// 목록을 forward하기 위해서 request에 저장
		request.setAttribute("notices", notices);
		
		// board 폴더의 list.jsp로 forward
		return new ActionForward("/notice/list.jsp", false);
	}

}
