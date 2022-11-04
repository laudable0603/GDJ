package com.gdu.app07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

import com.gdu.app07.config.BoardAppContext;
import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.repository.BoardDAO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class BoardServiceImpl implements BoardService {

	// Service는 DAO를 사용합니다. 언제나
	//@Autowired //컨테이너에 생성된  Bean중에서 BoardDAO타입의 bean을 가져오시오
	private BoardDAO dao;
	
	// 생성자의 매개변수 BoardDAO dao로 new BoardDAO()가 주입되고 있다.
	//BoardAppContext.java를 참고.
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}

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
