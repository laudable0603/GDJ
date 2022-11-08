package com.gdu.app09.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app09.domain.BoardDTO;

@Repository  // 컴포넌트로 등록
public class BoardDAO {

	// SqlSessionTemplate
	// Mybatis에서 지원하는 매퍼처리 클래스
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private String mapper = "mybatis.mapper.board.";
	
	
	public List<BoardDTO> selectAllBoards() {
		return sqlSessionTemplate.selectList(mapper + "selectAllBoards");
	}
	
	public BoardDTO selectBoardByNo(int boardNo) {
		return sqlSessionTemplate.selectOne(mapper + "selectBoardByNo", boardNo);
	}
	
	public int insertBoard(BoardDTO board) {
		return sqlSessionTemplate.insert(mapper + "insertBoard", board);
	}
	
	public int updateBoard(BoardDTO board) {
		return sqlSessionTemplate.update(mapper + "updateBoard", board);
	}
	
	public int deleteBoard(int boardNo) {
		return sqlSessionTemplate.delete(mapper + "deleteBoard", boardNo);
	}
	
}
