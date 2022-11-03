package com.gdu.app06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app06.domain.BoardDTO;
import com.gdu.app06.repository.BoardDAO;

/*
	@@Service
	안녕. 난 Service에 추가하는 @Component야.
	servlet-context.xml에 등록된 <context:component-scan> 태그에 의해서 bean으로 검색되지.
	root-context.xml이나 @Configration에 @Bean으로 등록하지 않아도 컨테이너에 만들어 져.
*/


@Service //서비스가 사용하는 @Component

public class BoardServiceImpl implements BoardService {

	// Service는 DAO를 사용합니다. 언제나
	@Autowired //컨테이너에 생성된  Bean중에서 BoardDAO타입의 bean을 가져오시오
	private BoardDAO dao; //null값이 아님
	
	
	
	@Override
	public List<BoardDTO> findAllBoards() {
		return dao.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int board_no) {
		return dao.selectBoardByNo(board_no);
	}

	@Override
	public int saveBoard(BoardDTO board) {
		return dao.insertBoard(board);
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		
		return dao.updateBoard(board);
	}

	@Override
	public int removeBoard(int board_no) {
		
		return dao.deleteBoard(board_no);
	}

}
