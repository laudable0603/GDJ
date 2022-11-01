package com.gdu.app05.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.gdu.app05.domain.Board;

public interface BoardService {
	
	//ajax 응답 전용
	public  ResponseEntity<Board> execute1(HttpServletRequest request);
	public  ResponseEntity<Board> execute2(String title, String content);
	public  ResponseEntity<Board> execute3(Board board);
}
